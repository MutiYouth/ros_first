// This is a generated file. Not intended for manual editing.
package com.weng.ros_first.ros_integrate.pkg.xml.condition.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.weng.ros_first.ros_integrate.pkg.xml.condition.psi.*;

public class ROSConditionItemImpl extends ROSConditionExprImpl implements ROSConditionItem {

  public ROSConditionItemImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ROSConditionVisitor visitor) {
    visitor.visitItem(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ROSConditionVisitor) accept((ROSConditionVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public boolean checkValid() {
    return ROSConditionImplUtil.checkValid(this);
  }

  @NotNull
  @Override
  public String evaluate() {
    return ROSConditionImplUtil.evaluate(this);
  }

}
