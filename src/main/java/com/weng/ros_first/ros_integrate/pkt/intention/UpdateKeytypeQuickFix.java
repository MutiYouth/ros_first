package com.weng.ros_first.ros_integrate.pkt.intention;

import com.intellij.codeInspection.LocalQuickFix;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import com.weng.ros_first.ros_integrate.pkt.psi.ROSPktElementFactory;
import com.weng.ros_first.ros_integrate.pkt.psi.ROSPktType;
import com.weng.ros_first.ros_integrate.pkt.psi.ROSPktTypeBase;

/**
 * an intention that converts deprecated field types to current ones:
 * <ul>
 *     <li>char -> uint8</li>
 *     <li>byte -> int8</li>
 * </ul>
 * @author Noam Dori
 */
public class UpdateKeytypeQuickFix implements LocalQuickFix {

    @Nls(capitalization = Nls.Capitalization.Sentence)
    @NotNull
    @Override
    public String getFamilyName() {
        return "Update type";
    }

    @Override
    public void applyFix(@NotNull Project project, @NotNull ProblemDescriptor descriptor) {
        String newName = descriptor.getPsiElement().getText().equals("char") ? "uint8" : "int8";
        ROSPktTypeBase typeToUpdate = (ROSPktTypeBase) descriptor.getPsiElement();
        ROSPktType newType = ROSPktElementFactory.createType(typeToUpdate.getProject(),newName);
        typeToUpdate.raw().replace(newType.raw());
    }
}
