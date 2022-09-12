package com.weng.ros_first.code_glance_pro.extensions.widget

import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Disposer
import com.intellij.openapi.wm.StatusBarWidget
import com.intellij.openapi.wm.impl.status.widget.StatusBarEditorBasedWidgetFactory
import com.weng.ros_first.code_glance_pro.util.message
import org.jetbrains.annotations.Nls

class GlanceVisibleWidgetFactory : StatusBarEditorBasedWidgetFactory() {
    override fun getId(): String = GlanceToggleVisibleWidgetPanel.ID

    @Nls
    override fun getDisplayName(): String = message("glance.widget")

    override fun createWidget(project: Project): StatusBarWidget = GlanceToggleVisibleWidgetPanel(project)

    override fun disposeWidget(widget: StatusBarWidget) = Disposer.dispose(widget)
}