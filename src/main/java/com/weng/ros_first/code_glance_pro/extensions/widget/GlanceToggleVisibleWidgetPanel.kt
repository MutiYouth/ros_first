package com.weng.ros_first.code_glance_pro.extensions.widget

import com.intellij.openapi.actionSystem.ActionPlaces
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.ex.ActionManagerEx
import com.intellij.openapi.actionSystem.ex.ActionUtil
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.fileEditor.TextEditor
import com.intellij.openapi.fileEditor.ex.FileEditorManagerEx
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.StatusBar
import com.intellij.openapi.wm.StatusBarWidget
import com.intellij.openapi.wm.StatusBarWidget.WidgetPresentation
import com.intellij.openapi.wm.impl.status.StatusBarUtil
import com.intellij.util.Consumer
import com.weng.ros_first.code_glance_pro.config.CodeGlanceConfigService.Companion.ConfigInstance
import com.weng.ros_first.code_glance_pro.config.SettingsChangeListener
import com.weng.ros_first.code_glance_pro.panel.GlancePanel
import com.weng.ros_first.code_glance_pro.util.CodeGlanceIcons
import com.weng.ros_first.code_glance_pro.util.message
import java.awt.event.MouseEvent
import javax.swing.Icon

class GlanceToggleVisibleWidgetPanel(private val project: Project) : StatusBarWidget, StatusBarWidget.IconPresentation {
	private val toggleAction: AnAction = ActionManagerEx.getInstance().getAction("CodeGlance.toggle")
	private var myStatusBar: StatusBar? = null

	override fun getIcon(): Icon? {
		if(ConfigInstance.state.hoveringToShowScrollBar) return null
		return CodeGlanceIcons.Widget
	}

	override fun ID(): String = ID

	override fun getPresentation(): WidgetPresentation = this

	override fun dispose() {
		myStatusBar = null
	}

	override fun install(statusBar: StatusBar) {
		myStatusBar = statusBar
		updateStatusBar()
		val connect = project.messageBus.connect(this)
		connect.subscribe(SettingsChangeListener.TOPIC, object : SettingsChangeListener {
			override fun onHoveringOriginalScrollBarChanged(value: Boolean) = updateStatusBar()
		})
	}

	override fun getTooltipText(): String? {
		val editor = getEditor()?: return null
		return if (isVisible(editor)) message("glance.visible.show") else message("glance.visible.hide")
	}

	override fun getClickConsumer(): Consumer<MouseEvent> = Consumer{
		getEditor()?.let {
			ActionUtil.invokeAction(toggleAction,it.contentComponent,ActionPlaces.UNKNOWN,null,null)
		}
		updateStatusBar()
	}

	private fun isVisible(editor: Editor) = editor.getUserData(GlancePanel.CURRENT_GLANCE)?.isVisible == false

	private fun getEditor(): Editor? {
		val fileEditor = StatusBarUtil.getCurrentFileEditor(myStatusBar) ?: FileEditorManagerEx.getInstanceEx(project).selectedEditor
		return if (fileEditor is TextEditor) fileEditor.editor else null
	}

	private fun updateStatusBar() {
		myStatusBar?.updateWidget(ID())
	}

	companion object {
		const val ID = "CodeGlanceWidget"
	}
}