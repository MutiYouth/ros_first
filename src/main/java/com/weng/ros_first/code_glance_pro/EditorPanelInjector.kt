package com.weng.ros_first.code_glance_pro

import com.intellij.ide.ui.LafManager
import com.intellij.ide.ui.LafManagerListener
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.editor.impl.EditorImpl
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.fileEditor.FileEditorManagerListener
import com.intellij.openapi.fileEditor.TextEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Disposer
import com.intellij.openapi.vfs.VirtualFile
import com.weng.ros_first.code_glance_pro.config.CodeGlanceConfigService.Companion.ConfigInstance
import com.weng.ros_first.code_glance_pro.config.SettingsChangeListener
import com.weng.ros_first.code_glance_pro.panel.GlancePanel
import com.weng.ros_first.code_glance_pro.panel.vcs.MyVcsPanel
import java.awt.BorderLayout
import java.awt.Component
import javax.swing.JPanel

class EditorPanelInjector(private val project: Project) : FileEditorManagerListener,SettingsChangeListener, LafManagerListener {
    private val logger = Logger.getInstance(javaClass)
    private var isFirstSetup = true
    private val config = ConfigInstance.state
    init{
        ApplicationManager.getApplication().messageBus.connect(project).let{
            it.subscribe(SettingsChangeListener.TOPIC, this)
            it.subscribe(LafManagerListener.TOPIC, this)
        }
    }

    /** FileEditorManagerListener */
    override fun fileOpened(fem: FileEditorManager, virtualFile: VirtualFile) {
        val where = if (config.isRightAligned) BorderLayout.LINE_END else BorderLayout.LINE_START
        for (textEditor in fem.getEditors(virtualFile).filterIsInstance<TextEditor>()) {
            val editor = textEditor.editor as? EditorImpl
            val layout = (editor?.component as? JPanel)?.layout
            if (layout is BorderLayout && layout.getLayoutComponent(where) == null) {
                val myPanel = getMyPanel(editor)
                editor.component.add(myPanel, where)
                myPanel.applyGlancePanel { changeOriginScrollBarWidth() }
            }
        }
    }

    /** SettingsChangeListener */
    override fun onGlobalChanged() {
        val where = if (config.isRightAligned) BorderLayout.LINE_END else BorderLayout.LINE_START
        processAllGlanceEditor{
            it.component.remove(this)
            val oldGlancePanel = applyGlancePanel { Disposer.dispose(this) }
            val myPanel = getMyPanel(it)
            it.component.add(myPanel, where)
            myPanel.applyGlancePanel {
                oldGlancePanel?.let{ glancePanel -> originalScrollbarWidth = glancePanel.originalScrollbarWidth }
                changeOriginScrollBarWidth()
                updateImage()
            }
        }
    }

    /** LafManagerListener */
    override fun lookAndFeelChanged(source: LafManager) = if(isFirstSetup) isFirstSetup = false else {
        processAllGlanceEditor{ applyGlancePanel{ refresh() } }
    }

    private fun processAllGlanceEditor(block: Component.(editor: EditorImpl)->Unit){
        try {
            for (textEditor in FileEditorManager.getInstance(project).allEditors.filterIsInstance<TextEditor>()) {
                val editor = textEditor.editor as? EditorImpl
                val layout = (editor?.component as? JPanel)?.layout
                if (layout is BorderLayout) {
                    (layout.getLayoutComponent(BorderLayout.LINE_END) ?: layout.getLayoutComponent(BorderLayout.LINE_START))?.block(editor)
                }
            }
        }catch (e:Exception){
            logger.error(e)
        }
    }

    private fun getMyPanel(editor: EditorImpl): JPanel {
        val glancePanel = GlancePanel(project, editor)
        val jPanel = if (config.hideOriginalScrollBar) MyPanel(glancePanel).apply {
            glancePanel.myVcsPanel = MyVcsPanel(glancePanel)
            add(glancePanel.myVcsPanel!!, BorderLayout.WEST)
        } else glancePanel
        glancePanel.hideScrollBarListener.addHideScrollBarListener()
        return jPanel
    }

    private fun Component.applyGlancePanel(block: GlancePanel.()->Unit): GlancePanel?{
        val glancePanel = if (this is MyPanel) panel else if (this is GlancePanel) this else null
        glancePanel?.block()
        return glancePanel
    }

    internal class MyPanel(val panel: GlancePanel):JPanel(BorderLayout()){
        init{
            add(panel)
            isOpaque = false
        }
    }
}