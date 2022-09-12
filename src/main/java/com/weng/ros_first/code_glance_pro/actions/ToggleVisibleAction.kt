package com.weng.ros_first.code_glance_pro.actions

import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.Presentation
import com.intellij.openapi.actionSystem.ex.ActionButtonLook
import com.intellij.openapi.actionSystem.ex.CustomComponentAction
import com.intellij.openapi.actionSystem.impl.ActionButton
import com.intellij.openapi.project.DumbAwareToggleAction
import com.intellij.util.ui.JBUI
import com.weng.ros_first.code_glance_pro.panel.GlancePanel
import com.weng.ros_first.code_glance_pro.util.CodeGlanceIcons
import com.weng.ros_first.code_glance_pro.util.message
import javax.swing.JComponent

class ToggleVisibleAction : DumbAwareToggleAction(), CustomComponentAction {
    override fun createCustomComponent(presentation: Presentation, place: String): JComponent =
        object : ActionButton(this, presentation, place, JBUI.emptySize()) {
            override fun getPopState(): Int = if (myRollover && isEnabled) POPPED else NORMAL
        }.also {
            it.setLook(ActionButtonLook.INPLACE_LOOK)
            it.border = JBUI.Borders.empty(1, 2)
        }

    override fun isSelected(e: AnActionEvent): Boolean {
        return e.applyToGlance { isVisible } ?: true
    }

    override fun setSelected(e: AnActionEvent, state: Boolean) {
        e.applyToGlance {
            if (!config.hoveringToShowScrollBar) {
                isVisible = state
                if (isVisible) refresh(directUpdate = true)
                changeOriginScrollBarWidth(isVisible)
            }
        }

    }

    override fun update(e: AnActionEvent) {
        super.update(e)
        val presentation = e.presentation
        if (!isSelected(e)) {
            presentation.text = message("glance.visible.show")
            presentation.icon = CodeGlanceIcons.GlanceShow
        } else {
            presentation.text = message("glance.visible.hide")
            presentation.icon = CodeGlanceIcons.GlanceHide
        }
    }

    private fun <T> AnActionEvent.applyToGlance(action: GlancePanel.() -> T) =
        getData(CommonDataKeys.EDITOR)?.getUserData(GlancePanel.CURRENT_GLANCE)?.run(action)
}