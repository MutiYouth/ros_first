package com.weng.ros_first.code_glance_pro

import com.intellij.openapi.fileEditor.FileEditorManagerListener
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener

class CodeGlancePlugin : ProjectManagerListener {
    override fun projectOpened(project: Project) {
        project.messageBus.connect().subscribe(FileEditorManagerListener.FILE_EDITOR_MANAGER, EditorPanelInjector(project))
    }
}