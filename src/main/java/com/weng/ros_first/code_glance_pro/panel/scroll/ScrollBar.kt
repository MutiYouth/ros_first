package com.weng.ros_first.code_glance_pro.panel.scroll

import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.openapi.editor.ScrollType
import com.intellij.openapi.editor.VisualPosition
import com.intellij.openapi.editor.ex.MarkupModelEx
import com.intellij.openapi.editor.ex.RangeHighlighterEx
import com.intellij.openapi.ui.popup.Balloon
import com.intellij.ui.HintHint
import com.intellij.util.Alarm
import com.intellij.util.ui.JBUI
import com.weng.ros_first.code_glance_pro.config.enums.MouseJumpEnum
import com.weng.ros_first.code_glance_pro.panel.GlancePanel
import com.weng.ros_first.code_glance_pro.panel.GlancePanel.Companion.fitLineToEditor
import java.awt.AlphaComposite
import java.awt.Color
import java.awt.Cursor
import java.awt.Graphics2D
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.event.MouseWheelEvent
import javax.swing.SwingUtilities
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

class ScrollBar(private val glancePanel: GlancePanel) {
    var hovering = false
    private val config = glancePanel.config
    private val editor = glancePanel.editor
    private val scrollState = glancePanel.scrollState
    private val alarm = Alarm(glancePanel)
    private val myEditorFragmentRenderer = CustomEditorFragmentRenderer(editor)

    // 视图滚动
    private var myWheelAccumulator = 0
    private var myLastVisualLine = 0
    private var visibleRectColor: Color = Color.decode("#" + config.viewportColor)
    private var visibleRectAlpha = DEFAULT_ALPHA
        set(value) {
            if (field != value) {
                field = value
                glancePanel.repaint()
            }
        }

    // 矩形y轴
    private val vOffset: Int
        get() = scrollState.viewportStart - scrollState.visibleStart

    init {
        val mouseHandler = MouseHandler()
        glancePanel.addMouseListener(mouseHandler)
        glancePanel.addMouseWheelListener(mouseHandler)
        glancePanel.addMouseMotionListener(mouseHandler)
        glancePanel.addMouseListener(glancePanel.myPopHandler)
    }

    fun paint(gfx: Graphics2D) {
        gfx.color = visibleRectColor
        gfx.composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, visibleRectAlpha)
        gfx.fillRect(0, vOffset, glancePanel.width, scrollState.viewportHeight)
    }

    fun clear() {
        alarm.cancelAllRequests()
        myEditorFragmentRenderer.clearHint()
    }

    private fun showToolTipByMouseMove(e: MouseEvent) {
        val y = e.y + myWheelAccumulator
        val visualLine = fitLineToEditor(editor, glancePanel.getMyRenderVisualLine(y + scrollState.visibleStart))
        myLastVisualLine = visualLine
        val point = SwingUtilities.convertPoint(
            glancePanel, 0, if (y > 0 && y < scrollState.drawHeight) y else if (y <= 0) 0 else scrollState.drawHeight,
            editor.scrollPane.verticalScrollBar
        )
        val me = MouseEvent(
            editor.scrollPane.verticalScrollBar,
            e.id,
            e.`when`,
            e.modifiersEx,
            1,
            point.y,
            e.clickCount,
            e.isPopupTrigger
        )
        val highlighters = mutableListOf<RangeHighlighterEx>()
        collectRangeHighlighters(editor.markupModel, visualLine, highlighters)
        collectRangeHighlighters(editor.filteredDocumentMarkupModel, visualLine, highlighters)
        myEditorFragmentRenderer.show(visualLine, highlighters, createHint(me))
    }

    private fun collectRangeHighlighters(
        markupModel: MarkupModelEx,
        visualLine: Int,
        highlighters: MutableCollection<in RangeHighlighterEx>
    ) {
        val startOffset: Int = getOffset(fitLineToEditor(editor, visualLine - PREVIEW_LINES), true)
        val endOffset: Int = getOffset(fitLineToEditor(editor, visualLine + PREVIEW_LINES), false)
        markupModel.processRangeHighlightersOverlappingWith(startOffset, endOffset) { highlighter ->
            val tooltip = highlighter.errorStripeTooltip
            if (tooltip != null && !(tooltip is HighlightInfo && tooltip.type === HighlightInfoType.TODO) &&
                highlighter.startOffset < endOffset && highlighter.endOffset > startOffset &&
                highlighter.getErrorStripeMarkColor(editor.colorsScheme) != null
            ) {
                highlighters.add(highlighter)
            }
            true
        }
    }

    private fun getOffset(visualLine: Int, startLine: Boolean): Int =
        editor.visualPositionToOffset(VisualPosition(visualLine, if (startLine) 0 else Int.MAX_VALUE))

    private fun hideMyEditorPreviewHint() {
        alarm.cancelAllRequests()
        myEditorFragmentRenderer.hideHint()
        myWheelAccumulator = 0
        myLastVisualLine = 0
    }

    private inner class MouseHandler : MouseAdapter() {
        private var resizing = false
        private var resizeStart: Int = 0

        private var dragging = false
        private var dragStart: Int = 0
        private var dragStartDelta: Int = 0

        private var widthStart: Int = 0

        override fun mouseEntered(e: MouseEvent) {
            hovering = true
        }

        override fun mousePressed(e: MouseEvent) {
            if (e.button != MouseEvent.BUTTON1) return
            when {
                isInResizeGutter(e.x) -> {
                    resizing = true
                    resizeStart = e.xOnScreen
                    widthStart = glancePanel.width
                }

                isInRect(e.y) || MouseJumpEnum.NONE == config.jumpOnMouseDown -> dragMove(e.y)
                MouseJumpEnum.MOUSE_DOWN == config.jumpOnMouseDown -> jumpToLineAt(e.y) {
                    visibleRectAlpha = DEFAULT_ALPHA
                    glancePanel.cursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)
                    dragMove(e.y)
                }
            }
        }

        private fun dragMove(y: Int) {
            dragging = true
            visibleRectAlpha = DRAG_ALPHA
            dragStart = y
            dragStartDelta = vOffset
        }

        override fun mouseDragged(e: MouseEvent) {
            if (resizing) {
                val newWidth = widthStart + resizeStart - e.xOnScreen
                config.width = newWidth.coerceIn(GlancePanel.minWidth, GlancePanel.maxWidth)
                glancePanel.refreshWithWidth()
            } else if (dragging) {
                val delta = (dragStartDelta + (e.y - dragStart)).toFloat()
                val newPos = if (scrollState.documentHeight < scrollState.visibleHeight)
                // Full doc fits into minimap, use exact value
                    delta
                else scrollState.run {
                    // Who says algebra is useless?
                    // delta = newPos - ((newPos / (documentHeight - viewportHeight + 1)) * (documentHeight - visibleHeight + 1))
                    // ...Solve for newPos...
                    delta * (documentHeight - viewportHeight + 1) / (visibleHeight - viewportHeight)
                }
                editor.scrollPane.verticalScrollBar.value = (newPos / scrollState.scale).roundToInt()
            } else if (MouseJumpEnum.MOUSE_UP == config.jumpOnMouseDown) showMyEditorPreviewHint(e)
        }

        override fun mouseReleased(e: MouseEvent) {
            val action = {
                updateAlpha(e.y)
                dragging = false
                resizing = false
                hideScrollBar(e)
            }
            if (MouseJumpEnum.MOUSE_UP == config.jumpOnMouseDown && !dragging && !resizing && !e.isPopupTrigger) jumpToLineAt(
                e.y,
                action
            )
            else editor.scrollingModel.runActionOnScrollingFinished(action)
        }

        override fun mouseMoved(e: MouseEvent) {
            val isInRect = updateAlpha(e.y)
            if (isInResizeGutter(e.x)) {
                glancePanel.cursor = Cursor(Cursor.W_RESIZE_CURSOR)
            } else if (!isInRect && !resizing && !dragging && showMyEditorPreviewHint(e)) {
                return
            }
            hideMyEditorPreviewHint()
        }

        private fun showMyEditorPreviewHint(e: MouseEvent): Boolean {
            if (config.showEditorToolTip && e.x > 10 && e.y < scrollState.drawHeight) {
                if (myEditorFragmentRenderer.getEditorPreviewHint() == null) {
                    alarm.cancelAllRequests()
                    alarm.addRequest({
                        if (myEditorFragmentRenderer.getEditorPreviewHint() == null) showToolTipByMouseMove(e)
                    }, 400)
                } else showToolTipByMouseMove(e)
                return true
            }
            return false
        }

        override fun mouseExited(e: MouseEvent) {
            hovering = false
            if (!dragging) visibleRectAlpha = DEFAULT_ALPHA
            hideMyEditorPreviewHint()
            hideScrollBar(e)
        }

        override fun mouseWheelMoved(e: MouseWheelEvent) {
            if (myEditorFragmentRenderer.getEditorPreviewHint() != null) {
                val units = e.unitsToScroll
                if (units == 0) return
                if (myLastVisualLine < editor.visibleLineCount - 1 && units > 0 || myLastVisualLine > 0 && units < 0) {
                    myWheelAccumulator += units
                }
                showToolTipByMouseMove(e)
            }
        }

        private fun isInResizeGutter(x: Int): Boolean =
            if (config.locked || config.hoveringToShowScrollBar || glancePanel.fileEditorManagerEx.isInSplitter) false else x in 0..7

        private fun isInRect(y: Int): Boolean = y in vOffset..(vOffset + scrollState.viewportHeight)

        private fun updateAlpha(y: Int): Boolean {
            return when {
                isInRect(y) -> {
                    visibleRectAlpha = HOVER_ALPHA
                    glancePanel.cursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)
                    true
                }

                else -> {
                    visibleRectAlpha = DEFAULT_ALPHA
                    glancePanel.cursor =
                        if (MouseJumpEnum.NONE != config.jumpOnMouseDown && y < scrollState.drawHeight) Cursor.getPredefinedCursor(
                            Cursor.HAND_CURSOR
                        )
                        else Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)
                    false
                }
            }
        }

        private fun hideScrollBar(e: MouseEvent) = if (!dragging && !resizing && !e.isPopupTrigger)
            glancePanel.hideScrollBarListener.hideGlanceRequest() else Unit

        private fun jumpToLineAt(y: Int, action: () -> Unit) {
            hideMyEditorPreviewHint()
            val line = fitLineToEditor(editor, glancePanel.getMyRenderVisualLine(y + scrollState.visibleStart))
            editor.caretModel.moveToVisualPosition(VisualPosition(line, 0))
            editor.scrollingModel.scrollToCaret(ScrollType.CENTER)
            editor.scrollingModel.runActionOnScrollingFinished(action)
        }
    }

    companion object {
        private const val DEFAULT_ALPHA = 0.15f
        private const val HOVER_ALPHA = 0.25f
        private const val DRAG_ALPHA = 0.35f
        val PREVIEW_LINES = max(2, min(25, Integer.getInteger("preview.lines", 5)))

        @JvmStatic
        private fun createHint(me: MouseEvent): HintHint = HintHint(me)
            .setAwtTooltip(true)
            .setPreferredPosition(Balloon.Position.atLeft)
            .setBorderInsets(JBUI.insets(CustomEditorFragmentRenderer.EDITOR_FRAGMENT_POPUP_BORDER))
            .setShowImmediately(true)
            .setAnimationEnabled(false)
    }
}