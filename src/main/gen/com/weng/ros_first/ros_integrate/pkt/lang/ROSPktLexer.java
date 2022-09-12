/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package com.weng.ros_first.ros_integrate.pkt.lang;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.weng.ros_first.ros_integrate.pkt.psi.ROSPktTypes;
import com.intellij.psi.TokenType;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>ROSPkt.flex</tt>
 */
class ROSPktLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int END_TYPE = 2;
  public static final int IN_ARRAY = 4;
  public static final int END_ARRAY = 6;
  public static final int START_NAME = 8;
  public static final int END_NAME = 10;
  public static final int START_CONST = 12;
  public static final int END_INT_CONST = 14;
  public static final int END_LINE = 16;
  public static final int END_INT_TYPE = 18;
  public static final int IN_INT_ARRAY = 20;
  public static final int END_INT_ARRAY = 22;
  public static final int START_INT_NAME = 24;
  public static final int END_INT_NAME = 26;
  public static final int START_INT_CONST = 28;
  public static final int NEG_NUM = 30;
  public static final int START_CONST_FRAG = 32;
  public static final int START_INT_CONST_FRAG = 34;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6,  6,  7,  7, 
     8,  8,  9,  9, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14, 15, 15, 
    16, 16, 17, 17
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [9, 6, 6]
   * Total runtime size is 1568 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>12]|((ch>>6)&0x3f)]<<6)|(ch&0x3f)];
  }

  /* The ZZ_CMAP_Z table has 272 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\100\1\200\u010d\100");

  /* The ZZ_CMAP_Y table has 192 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\175\3\1\4\77\3");

  /* The ZZ_CMAP_A table has 320 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\4\1\2\1\1\1\5\1\3\22\0\1\7\2\0\1\11\11\0\1\14\1\45\1\0\1\12\1\22\1"+
    "\25\1\24\1\26\1\12\1\23\1\12\1\21\1\12\3\0\1\6\35\0\1\10\1\0\1\13\3\0\1\32"+
    "\1\41\1\42\1\35\1\34\1\27\1\40\1\43\1\16\2\0\1\30\1\33\1\17\1\31\2\0\1\36"+
    "\1\37\1\20\1\15\3\0\1\44\13\0\1\1\242\0\2\1\26\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\24\0\1\1\2\2\1\1\1\2\1\3\1\4\11\1"+
    "\1\5\1\6\1\7\1\10\2\11\1\12\1\13\1\14"+
    "\2\15\2\16\1\2\1\17\1\20\1\21\1\22\2\23"+
    "\1\24\1\25\2\26\1\27\1\15\1\3\1\27\1\3"+
    "\1\13\1\24\1\4\1\27\1\15\1\3\4\0\11\1"+
    "\1\0\1\15\1\0\1\27\1\30\1\15\1\0\1\27"+
    "\1\0\1\27\1\30\1\15\3\0\1\31\10\1\1\27"+
    "\1\15\1\0\1\30\1\27\1\30\1\32\3\1\1\33"+
    "\3\1\1\30\5\1";

  private static int [] zzUnpackAction() {
    int [] result = new int[128];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\46\0\114\0\162\0\230\0\276\0\344\0\u010a"+
    "\0\u0130\0\u0156\0\u017c\0\u01a2\0\u01c8\0\u01ee\0\u0214\0\u023a"+
    "\0\u0260\0\u0286\0\u02ac\0\u02d2\0\u02f8\0\u031e\0\u0344\0\u036a"+
    "\0\u0390\0\u031e\0\u03b6\0\u03dc\0\u0402\0\u0428\0\u044e\0\u0474"+
    "\0\u049a\0\u04c0\0\u04e6\0\u050c\0\u0532\0\u031e\0\u0558\0\u031e"+
    "\0\u057e\0\u05a4\0\u05ca\0\u05f0\0\u031e\0\u0616\0\u063c\0\u0662"+
    "\0\u0688\0\u05ca\0\u06ae\0\u031e\0\u06d4\0\u031e\0\u06fa\0\u0720"+
    "\0\u0746\0\u031e\0\u076c\0\u0792\0\u07b8\0\u07de\0\u0804\0\u082a"+
    "\0\u0850\0\u0876\0\u089c\0\u08c2\0\u08e8\0\u090e\0\u0934\0\u095a"+
    "\0\u0980\0\u02d2\0\u09a6\0\u09cc\0\u09f2\0\u0a18\0\u0a3e\0\u0a64"+
    "\0\u0a8a\0\u0ab0\0\u0ad6\0\u0afc\0\u0616\0\u0b22\0\u0b22\0\u0b48"+
    "\0\u0b6e\0\u0b94\0\u0bba\0\u0be0\0\u0c06\0\u0c2c\0\u0c52\0\u0c78"+
    "\0\u0c9e\0\u0980\0\u09a6\0\u02f8\0\u0cc4\0\u0cea\0\u0d10\0\u0d36"+
    "\0\u0d5c\0\u0d82\0\u0da8\0\u0dce\0\u0df4\0\u0e1a\0\u0e1a\0\u0e40"+
    "\0\u0e66\0\u0e8c\0\u02f8\0\u0eb2\0\u0ed8\0\u0efe\0\u02f8\0\u0f24"+
    "\0\u0f4a\0\u0f70\0\u0f96\0\u0fbc\0\u0fe2\0\u1008\0\u102e\0\u1054";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[128];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\2\25\1\26\1\27\2\30\1\25\1\31\1\32\1\33"+
    "\2\25\1\34\1\35\1\36\1\25\1\37\6\25\1\40"+
    "\5\25\1\41\1\25\1\42\1\25\1\43\1\44\3\25"+
    "\1\32\2\26\1\27\2\45\1\32\1\45\1\46\36\32"+
    "\2\26\1\27\2\45\1\32\1\45\2\32\1\47\1\50"+
    "\5\32\6\47\20\32\2\26\1\27\2\45\1\32\1\45"+
    "\36\32\2\51\1\26\1\27\2\52\1\32\1\53\36\51"+
    "\1\32\2\26\1\27\2\54\1\55\1\54\1\32\1\33"+
    "\34\32\2\56\1\26\1\57\2\60\1\56\1\61\1\56"+
    "\1\32\34\56\1\32\2\26\1\27\1\53\1\62\1\32"+
    "\1\53\1\32\1\33\35\32\2\26\1\27\1\53\1\62"+
    "\1\32\1\53\37\32\2\26\1\27\2\63\1\32\1\63"+
    "\1\64\36\32\2\26\1\27\2\63\1\32\1\63\2\32"+
    "\1\65\1\66\5\32\6\65\20\32\2\26\1\27\2\63"+
    "\1\32\1\63\36\32\2\67\1\26\1\27\2\70\1\32"+
    "\1\53\36\67\1\32\2\26\1\27\2\71\1\72\1\71"+
    "\1\32\1\33\34\32\2\56\1\26\1\57\2\73\1\56"+
    "\1\74\2\56\1\75\1\56\1\76\4\56\6\75\16\56"+
    "\1\77\1\32\2\26\1\27\1\53\1\62\1\32\1\53"+
    "\2\32\1\100\6\32\6\100\16\32\1\101\2\56\1\26"+
    "\1\57\2\102\1\55\1\54\1\56\1\33\36\56\1\26"+
    "\1\57\2\103\1\72\1\71\1\56\1\104\1\105\1\56"+
    "\1\106\4\56\6\105\16\56\1\107\12\0\1\110\6\0"+
    "\6\110\16\0\1\111\2\112\2\0\5\112\1\113\34\112"+
    "\2\25\2\0\3\25\2\0\35\25\50\0\1\26\43\0"+
    "\2\25\1\26\1\27\2\30\1\25\1\31\1\0\35\25"+
    "\1\0\2\26\1\27\2\31\1\0\1\31\36\0\2\33"+
    "\2\0\42\33\2\25\2\0\3\25\2\0\3\25\1\114"+
    "\33\25\2\0\3\25\2\0\5\25\1\36\31\25\2\0"+
    "\3\25\2\0\6\25\1\115\30\25\2\0\3\25\2\0"+
    "\5\25\1\116\31\25\2\0\3\25\2\0\17\25\1\117"+
    "\17\25\2\0\3\25\2\0\4\25\1\120\32\25\2\0"+
    "\3\25\2\0\7\25\1\121\27\25\2\0\3\25\2\0"+
    "\20\25\1\122\12\25\1\123\3\25\2\0\3\25\2\0"+
    "\32\25\1\124\2\25\1\0\2\26\1\27\2\45\1\0"+
    "\1\45\50\0\1\47\6\0\6\47\17\0\2\51\2\0"+
    "\2\51\2\0\40\51\1\26\1\27\2\52\1\0\1\53"+
    "\36\51\1\0\2\26\1\27\1\53\1\62\1\0\1\53"+
    "\37\0\2\26\1\27\2\54\1\0\1\54\36\0\2\56"+
    "\1\0\4\56\1\125\40\56\1\26\4\56\1\125\40\56"+
    "\1\26\1\57\2\60\1\56\1\60\36\56\1\0\2\26"+
    "\1\27\2\61\1\0\1\61\37\0\2\26\1\27\2\63"+
    "\1\0\1\63\50\0\1\65\6\0\6\65\17\0\2\67"+
    "\2\0\2\67\2\0\40\67\1\26\1\27\2\70\1\0"+
    "\1\53\36\67\1\0\2\26\1\27\2\71\1\0\1\71"+
    "\36\0\2\56\1\26\1\57\2\73\1\56\1\73\36\56"+
    "\1\0\2\26\1\27\2\74\1\0\1\74\36\0\2\56"+
    "\1\0\1\56\2\126\1\56\1\127\2\56\1\75\6\56"+
    "\6\75\16\56\1\130\2\56\1\0\4\56\1\125\2\56"+
    "\1\131\6\56\6\131\16\56\1\132\2\56\1\0\4\56"+
    "\1\125\2\56\1\130\6\56\6\130\17\56\4\0\2\133"+
    "\1\0\1\133\2\0\1\100\6\0\6\100\16\0\1\134"+
    "\12\0\1\134\6\0\6\134\17\0\2\56\1\26\1\57"+
    "\2\102\1\56\1\102\40\56\1\26\1\57\2\103\1\56"+
    "\1\103\36\56\2\104\1\0\1\56\42\104\2\56\1\0"+
    "\1\56\2\126\1\135\1\127\2\56\1\105\6\56\6\105"+
    "\16\56\1\136\2\56\1\0\3\56\1\135\1\125\2\56"+
    "\1\137\6\56\6\137\16\56\1\140\2\56\1\0\3\56"+
    "\1\141\1\125\2\56\1\136\6\56\6\136\17\56\12\0"+
    "\1\110\6\0\6\110\16\0\1\142\12\0\1\142\6\0"+
    "\6\142\17\0\2\112\2\0\2\143\1\112\1\143\1\112"+
    "\1\113\34\112\2\25\2\0\3\25\2\0\3\25\1\144"+
    "\33\25\2\0\3\25\2\0\7\25\1\145\27\25\2\0"+
    "\3\25\2\0\22\25\1\146\14\25\2\0\3\25\2\0"+
    "\20\25\1\147\16\25\2\0\3\25\2\0\25\25\1\150"+
    "\11\25\2\0\3\25\2\0\25\25\1\151\11\25\2\0"+
    "\3\25\2\0\20\25\1\152\16\25\2\0\3\25\2\0"+
    "\7\25\1\153\27\25\2\0\3\25\2\0\21\25\1\154"+
    "\13\25\2\56\1\0\1\56\2\126\1\56\1\127\1\56"+
    "\1\155\36\56\1\0\1\56\2\126\1\56\1\127\2\56"+
    "\1\130\6\56\6\130\21\56\1\0\1\56\2\156\1\56"+
    "\1\157\2\56\1\131\6\56\6\131\16\56\1\160\2\56"+
    "\1\0\4\56\1\125\2\56\1\160\6\56\6\160\17\56"+
    "\4\0\2\133\1\0\1\133\1\0\1\161\40\0\2\133"+
    "\1\0\1\133\2\0\1\134\6\0\6\134\17\0\2\56"+
    "\1\0\3\56\1\135\1\125\2\56\1\135\6\56\6\135"+
    "\16\56\1\141\2\56\1\0\1\56\2\126\1\141\1\127"+
    "\2\56\1\136\6\56\6\136\21\56\1\0\1\56\2\156"+
    "\1\135\1\157\2\56\1\137\6\56\6\137\16\56\1\162"+
    "\2\56\1\0\3\56\1\141\1\125\2\56\1\162\6\56"+
    "\6\162\21\56\1\0\3\56\1\141\1\125\2\56\1\141"+
    "\6\56\6\141\17\56\2\25\2\0\3\25\2\0\10\25"+
    "\1\163\1\164\1\165\1\166\23\25\2\0\3\25\2\0"+
    "\23\25\1\167\13\25\2\0\3\25\2\0\21\25\1\170"+
    "\15\25\2\0\3\25\2\0\21\25\1\171\15\25\2\0"+
    "\3\25\2\0\5\25\1\172\31\25\2\0\3\25\2\0"+
    "\17\25\1\163\17\25\2\0\3\25\2\0\23\25\1\163"+
    "\13\25\2\0\3\25\2\0\25\25\1\163\7\25\2\155"+
    "\1\0\1\56\42\155\2\56\1\0\1\56\2\156\1\56"+
    "\1\157\1\56\1\173\36\56\1\0\1\56\2\156\1\56"+
    "\1\157\2\56\1\160\6\56\6\160\17\56\2\161\2\0"+
    "\42\161\2\56\1\0\1\56\2\156\1\141\1\157\2\56"+
    "\1\162\6\56\6\162\17\56\2\25\2\0\3\25\2\0"+
    "\12\25\1\163\24\25\2\0\3\25\2\0\15\25\1\163"+
    "\21\25\2\0\3\25\2\0\14\25\1\163\22\25\2\0"+
    "\3\25\2\0\7\25\1\174\27\25\2\0\3\25\2\0"+
    "\7\25\1\175\27\25\2\0\3\25\2\0\6\25\1\176"+
    "\26\25\2\173\1\0\1\56\42\173\2\25\2\0\3\25"+
    "\2\0\12\25\1\165\1\166\23\25\2\0\3\25\2\0"+
    "\5\25\1\177\31\25\2\0\3\25\2\0\27\25\1\167"+
    "\7\25\2\0\3\25\2\0\20\25\1\200\16\25\2\0"+
    "\3\25\2\0\6\25\1\167\26\25";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4218];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\23\0\2\1\1\11\3\1\1\11\13\1\1\11\1\1"+
    "\1\11\4\1\1\11\6\1\1\11\1\1\1\11\3\1"+
    "\1\11\16\1\3\0\11\1\1\0\1\1\1\0\3\1"+
    "\1\0\1\1\1\0\3\1\1\0\15\1\1\0\21\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[128];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /** For the backwards DFA of general lookahead statements */
  private boolean [] zzFin = new boolean [ZZ_BUFFERSIZE+1];


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  ROSPktLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        zzDoEOF();
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { yybegin(END_TYPE); return ROSPktTypes.CUSTOM_TYPE;
            } 
            // fall through
          case 28: break;
          case 2: 
            { yybegin(YYINITIAL); return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 29: break;
          case 3: 
            { return TokenType.BAD_CHARACTER;
            } 
            // fall through
          case 30: break;
          case 4: 
            { yybegin(YYINITIAL); return ROSPktTypes.LINE_COMMENT;
            } 
            // fall through
          case 31: break;
          case 5: 
            { yybegin(START_NAME); return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 32: break;
          case 6: 
            { yybegin(IN_ARRAY); return ROSPktTypes.LBRACKET;
            } 
            // fall through
          case 33: break;
          case 7: 
            { yybegin(IN_ARRAY); return ROSPktTypes.NUMBER;
            } 
            // fall through
          case 34: break;
          case 8: 
            { yybegin(END_ARRAY); return ROSPktTypes.RBRACKET;
            } 
            // fall through
          case 35: break;
          case 9: 
            { yybegin(END_NAME); return ROSPktTypes.NAME;
            } 
            // fall through
          case 36: break;
          case 10: 
            { return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 37: break;
          case 11: 
            { yybegin(START_CONST_FRAG); return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 38: break;
          case 12: 
            { yybegin(START_CONST); return ROSPktTypes.CONST_ASSIGNER;
            } 
            // fall through
          case 39: break;
          case 13: 
            { yybegin(END_LINE); return ROSPktTypes.STRING;
            } 
            // fall through
          case 40: break;
          case 14: 
            { yybegin(START_CONST); return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 41: break;
          case 15: 
            { yybegin(START_INT_NAME); return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 42: break;
          case 16: 
            { yybegin(IN_INT_ARRAY); return ROSPktTypes.LBRACKET;
            } 
            // fall through
          case 43: break;
          case 17: 
            { yybegin(IN_INT_ARRAY); return ROSPktTypes.NUMBER;
            } 
            // fall through
          case 44: break;
          case 18: 
            { yybegin(END_INT_ARRAY); return ROSPktTypes.RBRACKET;
            } 
            // fall through
          case 45: break;
          case 19: 
            { yybegin(END_INT_NAME); return ROSPktTypes.NAME;
            } 
            // fall through
          case 46: break;
          case 20: 
            { yybegin(START_INT_CONST_FRAG); return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 47: break;
          case 21: 
            { yybegin(START_INT_CONST); return ROSPktTypes.CONST_ASSIGNER;
            } 
            // fall through
          case 48: break;
          case 22: 
            { yybegin(START_INT_CONST); return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 49: break;
          case 23: 
            // general lookahead, find correct zzMarkedPos
            { int zzFState = 18;
              int zzFPos = zzStartRead;
              if (zzFin.length <= zzBufferL.length()) { zzFin = new boolean[zzBufferL.length()+1]; }
              boolean zzFinL[] = zzFin;
              while (zzFState != -1 && zzFPos < zzMarkedPos) {
                zzFinL[zzFPos] = ((zzAttrL[zzFState] & 1) == 1);
                zzInput = Character.codePointAt(zzBufferL, zzFPos/*, zzMarkedPos*/);
                zzFPos += Character.charCount(zzInput);
                zzFState = zzTransL[ zzRowMapL[zzFState] + ZZ_CMAP(zzInput) ];
              }
              if (zzFState != -1) { zzFinL[zzFPos++] = ((zzAttrL[zzFState] & 1) == 1); } 
              while (zzFPos <= zzMarkedPos) {
                zzFinL[zzFPos++] = false;
              }

              zzFState = 19;
              zzFPos = zzMarkedPos;
              while (!zzFinL[zzFPos] || (zzAttrL[zzFState] & 1) != 1) {
                zzInput = Character.codePointBefore(zzBufferL, zzFPos/*, zzStartRead*/);
                zzFPos -= Character.charCount(zzInput);
                zzFState = zzTransL[ zzRowMapL[zzFState] + ZZ_CMAP(zzInput) ];
              };
              zzMarkedPos = zzFPos;
            }
            { yybegin(END_INT_CONST); return ROSPktTypes.NUMBER;
            } 
            // fall through
          case 50: break;
          case 24: 
            // lookahead expression with fixed base length
            zzMarkedPos = Character.offsetByCodePoints
                (zzBufferL/*, zzStartRead, zzEndRead - zzStartRead*/, zzStartRead, 1);
            { yybegin(NEG_NUM); return ROSPktTypes.NEG_OPERATOR;
            } 
            // fall through
          case 51: break;
          case 25: 
            { yybegin(END_LINE); return ROSPktTypes.SERVICE_SEPARATOR;
            } 
            // fall through
          case 52: break;
          case 26: 
            { yybegin(END_INT_TYPE); return ROSPktTypes.KEYTYPE;
            } 
            // fall through
          case 53: break;
          case 27: 
            { yybegin(END_TYPE); return ROSPktTypes.KEYTYPE;
            } 
            // fall through
          case 54: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}