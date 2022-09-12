package com.weng.ros_first.code_glance_pro.listener

import com.intellij.openapi.Disposable
import com.intellij.openapi.editor.event.VisibleAreaEvent
import com.intellij.openapi.editor.event.VisibleAreaListener
import com.intellij.openapi.editor.ex.RangeHighlighterEx
import com.intellij.openapi.editor.impl.event.MarkupModelListener
import com.weng.ros_first.code_glance_pro.panel.vcs.MyVcsPanel
import java.awt.event.ComponentAdapter
import java.awt.event.ComponentEvent

class MyVcsListener(private val myVcsPanel: MyVcsPanel) : ComponentAdapter(), VisibleAreaListener, MarkupModelListener,
    Disposable {
    init {
        val editor = myVcsPanel.glancePanel.editor
        editor.contentComponent.addComponentListener(this)
        editor.scrollingModel.addVisibleAreaListener(this, this)
        editor.filteredDocumentMarkupModel.addMarkupModelListener(this, this)
    }

    /** ComponentAdapter */
    override fun componentResized(componentEvent: ComponentEvent?) = repaint()

    /** VisibleAreaListener */
    override fun visibleAreaChanged(e: VisibleAreaEvent) = repaint()

    /** MarkupModelListener */
    override fun afterAdded(highlighter: RangeHighlighterEx) = repaint(highlighter)

    override fun beforeRemoved(highlighter: RangeHighlighterEx) = repaint(highlighter)

    private fun repaint(highlighter: RangeHighlighterEx? = null) {
        val editor = myVcsPanel.glancePanel.editor
        if (myVcsPanel.isVisible && (highlighter == null ||
                    (highlighter.isThinErrorStripeMark && highlighter.getErrorStripeMarkColor(editor.colorsScheme) != null))
        ) myVcsPanel.repaint()
    }

    override fun dispose() {
        myVcsPanel.glancePanel.editor.contentComponent.removeComponentListener(this)
    }
}