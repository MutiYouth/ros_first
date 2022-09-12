// This is a generated file. Not intended for manual editing.
package com.weng.ros_first.ros_integrate.pkt.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.weng.ros_first.ros_integrate.pkt.psi.*;

public class ROSPktLabelImpl extends ROSPktIdentifierImpl implements ROSPktLabel {

  public ROSPktLabelImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ROSPktVisitor visitor) {
    visitor.visitLabel(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ROSPktVisitor) accept((ROSPktVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement set(String newName) {
    return ROSPktPsiImplUtil.set(this, newName);
  }

  @Override
  public String getName() {
    return ROSPktPsiImplUtil.getName(this);
  }

}
