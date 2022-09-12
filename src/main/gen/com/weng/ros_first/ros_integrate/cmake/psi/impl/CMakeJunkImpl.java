// This is a generated file. Not intended for manual editing.
package com.weng.ros_first.ros_integrate.cmake.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.weng.ros_first.ros_integrate.cmake.psi.*;

public class CMakeJunkImpl extends ASTWrapperPsiElement implements CMakeJunk {

  public CMakeJunkImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CMakeVisitor visitor) {
    visitor.visitJunk(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CMakeVisitor) accept((CMakeVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<CMakeBracketComment> getBracketCommentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CMakeBracketComment.class);
  }

}
