// This is a generated file. Not intended for manual editing.
package com.weng.ros_first.ros_integrate.pkg.xml.condition.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.weng.ros_first.ros_integrate.pkg.xml.condition.psi.*;

public class ROSConditionLogicImpl extends ASTWrapperPsiElement implements ROSConditionLogic {

  public ROSConditionLogicImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ROSConditionVisitor visitor) {
    visitor.visitLogic(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ROSConditionVisitor) accept((ROSConditionVisitor)visitor);
    else super.accept(visitor);
  }

}
