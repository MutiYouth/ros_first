// This is a generated file. Not intended for manual editing.
package com.weng.ros_first.ros_integrate.pkt.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.weng.ros_first.ros_integrate.pkt.psi.impl.*;

public interface ROSPktTypes {

  IElementType COMMENT = new ROSPktElementType("COMMENT");
  IElementType CONST = new ROSPktElementType("CONST");
  IElementType FIELD = new ROSPktElementType("FIELD");
  IElementType FIELD_FRAG = new ROSPktElementType("FIELD_FRAG");
  IElementType LABEL = new ROSPktElementType("LABEL");
  IElementType SECTION = new ROSPktElementType("SECTION");
  IElementType SEPARATOR = new ROSPktElementType("SEPARATOR");
  IElementType TYPE = new ROSPktElementType("TYPE");
  IElementType TYPE_FRAG = new ROSPktElementType("TYPE_FRAG");

  IElementType CONST_ASSIGNER = new ROSPktTokenType("CONST_ASSIGNER");
  IElementType CRLF = new ROSPktTokenType("CRLF");
  IElementType CUSTOM_TYPE = new ROSPktTokenType("CUSTOM_TYPE");
  IElementType KEYTYPE = new ROSPktTokenType("KEYTYPE");
  IElementType LBRACKET = new ROSPktTokenType("LBRACKET");
  IElementType LINE_COMMENT = new ROSPktTokenType("LINE_COMMENT");
  IElementType NAME = new ROSPktTokenType("NAME");
  IElementType NEG_OPERATOR = new ROSPktTokenType("NEG_OPERATOR");
  IElementType NUMBER = new ROSPktTokenType("NUMBER");
  IElementType RBRACKET = new ROSPktTokenType("RBRACKET");
  IElementType SERVICE_SEPARATOR = new ROSPktTokenType("SERVICE_SEPARATOR");
  IElementType STRING = new ROSPktTokenType("STRING");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == COMMENT) {
        return new ROSPktCommentImpl(node);
      }
      else if (type == CONST) {
        return new ROSPktConstImpl(node);
      }
      else if (type == FIELD) {
        return new ROSPktFieldImpl(node);
      }
      else if (type == FIELD_FRAG) {
        return new ROSPktFieldFragImpl(node);
      }
      else if (type == LABEL) {
        return new ROSPktLabelImpl(node);
      }
      else if (type == SECTION) {
        return new ROSPktSectionImpl(node);
      }
      else if (type == SEPARATOR) {
        return new ROSPktSeparatorImpl(node);
      }
      else if (type == TYPE) {
        return new ROSPktTypeImpl(node);
      }
      else if (type == TYPE_FRAG) {
        return new ROSPktTypeFragImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
