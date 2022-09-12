// This is a generated file. Not intended for manual editing.
package com.weng.ros_first.ros_integrate.pkt.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.weng.ros_first.ros_integrate.pkt.psi.*;

public class ROSPktFieldFragImpl extends ROSPktFieldBaseImpl implements ROSPktFieldFrag {

  public ROSPktFieldFragImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ROSPktVisitor visitor) {
    visitor.visitFieldFrag(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ROSPktVisitor) accept((ROSPktVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ROSPktConst getConst() {
    return findChildByClass(ROSPktConst.class);
  }

  @Override
  @Nullable
  public ROSPktLabel getLabel() {
    return findChildByClass(ROSPktLabel.class);
  }

  @Override
  @Nullable
  public ROSPktType getType() {
    return findChildByClass(ROSPktType.class);
  }

  @Override
  @Nullable
  public ROSPktTypeFrag getTypeFrag() {
    return findChildByClass(ROSPktTypeFrag.class);
  }

  @Override
  @NotNull
  public ROSPktTypeBase getTypeBase() {
    return ROSPktPsiImplUtil.getTypeBase(this);
  }

}
