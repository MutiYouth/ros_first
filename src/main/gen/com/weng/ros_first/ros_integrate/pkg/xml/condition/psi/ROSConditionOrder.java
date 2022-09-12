// This is a generated file. Not intended for manual editing.
package com.weng.ros_first.ros_integrate.pkg.xml.condition.psi;

import java.util.List;
import org.jetbrains.annotations.*;

public interface ROSConditionOrder extends ROSConditionExpr {

  @NotNull
  List<ROSConditionItem> getItemList();

  @NotNull
  List<ROSConditionLogic> getLogicList();

  @NotNull
  List<ROSConditionOrder> getOrderList();

}
