// This is a generated file. Not intended for manual editing.
package com.weng.ros_first.ros_integrate.pkt.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.weng.ros_first.ros_integrate.pkt.psi.*;

public class ROSPktTypeFragImpl extends ROSPktTypeBaseImpl implements ROSPktTypeFrag {

  public ROSPktTypeFragImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ROSPktVisitor visitor) {
    visitor.visitTypeFrag(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ROSPktVisitor) accept((ROSPktVisitor)visitor);
    else super.accept(visitor);
  }

}
