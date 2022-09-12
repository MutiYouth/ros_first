// This is a generated file. Not intended for manual editing.
package com.weng.ros_first.ros_integrate.pkt.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.weng.ros_first.ros_integrate.pkt.psi.*;

public class ROSPktTypeImpl extends ROSPktTypeBaseImpl implements ROSPktType {

  public ROSPktTypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ROSPktVisitor visitor) {
    visitor.visitType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ROSPktVisitor) accept((ROSPktVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public boolean isComplete() {
    return ROSPktPsiImplUtil.isComplete(this);
  }

}
