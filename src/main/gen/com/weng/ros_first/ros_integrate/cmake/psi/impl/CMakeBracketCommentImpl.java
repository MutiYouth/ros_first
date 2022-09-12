// This is a generated file. Not intended for manual editing.
package com.weng.ros_first.ros_integrate.cmake.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.weng.ros_first.ros_integrate.cmake.psi.*;

public class CMakeBracketCommentImpl extends ASTWrapperPsiElement implements CMakeBracketComment {

  public CMakeBracketCommentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CMakeVisitor visitor) {
    visitor.visitBracketComment(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CMakeVisitor) accept((CMakeVisitor)visitor);
    else super.accept(visitor);
  }

}
