package com.weng.ros_first.ros_integrate.cmake.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import com.weng.ros_first.ros_integrate.cmake.lang.CMakeFileType;
import com.weng.ros_first.ros_integrate.cmake.lang.CMakeLanguage;

public class CMakeFile extends PsiFileBase {
    public CMakeFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, CMakeLanguage.INSTANCE);
    }

    @Override
    public @NotNull FileType getFileType() {
        return CMakeFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "CMake File";
    }
}
