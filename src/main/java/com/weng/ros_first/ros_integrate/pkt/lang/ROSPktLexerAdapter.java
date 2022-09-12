package com.weng.ros_first.ros_integrate.pkt.lang;

import com.intellij.lexer.FlexAdapter;

/**
 * an adapter for the packet language lexer. Used in the complete parser and in custom syntax highlighting
 * @author Noam Dori
 */
public class ROSPktLexerAdapter extends FlexAdapter {
    public ROSPktLexerAdapter() {
        super(new ROSPktLexer(null));
    }
}
