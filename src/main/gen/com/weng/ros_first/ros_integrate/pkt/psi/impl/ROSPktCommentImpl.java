// This is a generated file. Not intended for manual editing.
package com.weng.ros_first.ros_integrate.pkt.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.weng.ros_first.ros_integrate.pkt.psi.*;

public class ROSPktCommentImpl extends ASTWrapperPsiElement implements ROSPktComment {

  public ROSPktCommentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ROSPktVisitor visitor) {
    visitor.visitComment(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ROSPktVisitor) accept((ROSPktVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public String getAnnotationIds() {
    return ROSPktPsiImplUtil.getAnnotationIds(this);
  }

}
