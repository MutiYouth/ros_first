package com.weng.ros_first.code_glance_pro.extensions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.DefaultActionGroup
import com.intellij.openapi.actionSystem.ex.ActionManagerEx
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.markup.InspectionWidgetActionProvider
import com.weng.ros_first.code_glance_pro.panel.GlancePanel.Companion.CURRENT_GLANCE

private class GlanceVisibleActionProvider : InspectionWidgetActionProvider {
    override fun createAction(editor: Editor): AnAction {
        return object : DefaultActionGroup(ActionManagerEx.getInstance().getAction("CodeGlance.toggle")) {
            override fun update(e: AnActionEvent) {
                e.presentation.isEnabledAndVisible = editor.getUserData(CURRENT_GLANCE)?.run {
                    config.singleFileVisibleButton()
                } ?: false
            }
        }
    }
}