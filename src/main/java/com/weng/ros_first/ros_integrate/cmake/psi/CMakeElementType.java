package com.weng.ros_first.ros_integrate.cmake.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import com.weng.ros_first.ros_integrate.cmake.lang.CMakeLanguage;

/**
 * formally defines ROS packet token types. This is a template for generated token types
 * @author Noam Dori
 */
public class CMakeElementType extends IElementType {
    public CMakeElementType(@NotNull String debugName) {
        super(debugName, CMakeLanguage.INSTANCE);
    }
}
