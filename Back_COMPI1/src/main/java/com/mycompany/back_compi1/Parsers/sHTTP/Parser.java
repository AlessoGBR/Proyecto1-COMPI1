
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Thu Apr 03 20:33:04 CST 2025
//----------------------------------------------------

package com.mycompany.back_compi1.Parsers.sHTTP;

import java_cup.runtime.*;
import com.mycompany.back_compi1.Parsers.SHTTPRequest;
import java.util.ArrayList;
import java.util.List;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Thu Apr 03 20:33:04 CST 2025
  */
public class Parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\020\000\002\002\004\000\002\002\006\000\002\003" +
    "\003\000\002\003\003\000\002\003\003\000\002\003\003" +
    "\000\002\003\002\000\002\004\003\000\002\004\003\000" +
    "\002\006\004\000\002\006\003\000\002\007\003\000\002" +
    "\007\003\000\002\007\003\000\002\005\003\000\002\005" +
    "\002" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\023\000\016\006\004\007\007\010\011\011\006\012" +
    "\ufffb\013\ufffb\001\002\000\006\012\uffff\013\uffff\001\002" +
    "\000\004\002\025\001\002\000\006\012\ufffd\013\ufffd\001" +
    "\002\000\006\012\ufffe\013\ufffe\001\002\000\006\012\014" +
    "\013\012\001\002\000\006\012\ufffc\013\ufffc\001\002\000" +
    "\010\005\ufff9\012\ufff9\013\ufff9\001\002\000\010\005\016" +
    "\012\020\013\015\001\002\000\010\005\ufffa\012\ufffa\013" +
    "\ufffa\001\002\000\014\002\ufff4\004\ufff4\005\ufff4\012\ufff4" +
    "\013\ufff4\001\002\000\014\002\ufff6\004\ufff6\005\ufff6\012" +
    "\ufff6\013\ufff6\001\002\000\006\002\ufff2\004\024\001\002" +
    "\000\014\002\ufff5\004\ufff5\005\ufff5\012\ufff5\013\ufff5\001" +
    "\002\000\014\002\ufff7\004\ufff7\005\016\012\020\013\015" +
    "\001\002\000\006\002\ufff8\004\ufff8\001\002\000\004\002" +
    "\000\001\002\000\004\002\ufff3\001\002\000\004\002\001" +
    "\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\023\000\006\002\004\003\007\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\004\012\001\001\000\002\001\001\000\002\001" +
    "\001\000\006\006\016\007\020\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\005\022\001" +
    "\001\000\002\001\001\000\006\006\021\007\020\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    private SHTTPRequest request;

    public SHTTPRequest getRequest() {
            return request;
    }

    public void syntax_error(Symbol token) {
        System.out.println("Syntax error: " + token.value + " at line " + token.left);
    }

    public void unrecovered_syntax_error(Symbol token) {

    }


}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // body ::= 
            {
              String RESULT =null;
		 RESULT = "";
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("body",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // body ::= BODY 
            {
              String RESULT =null;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = b;    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("body",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // scl_part ::= PAGINA 
            {
              String RESULT =null;
		 RESULT = "pagina"; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("scl_part",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // scl_part ::= SITIO 
            {
              String RESULT =null;
		 RESULT = "sitio"; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("scl_part",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // scl_part ::= SCL_TEXT 
            {
              String RESULT =null;
		int textleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int textright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String text = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = text; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("scl_part",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // scl_instruction ::= scl_part 
            {
              String RESULT =null;
		int partleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int partright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String part = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = part; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("scl_instruction",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // scl_instruction ::= scl_part scl_instruction 
            {
              String RESULT =null;
		int partleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int partright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String part = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int restleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int restright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String rest = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = part + " " + rest; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("scl_instruction",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // target ::= PAGINA 
            {
              String RESULT =null;
		int pagleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int pagright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object pag = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = "PAGINA";   
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("target",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // target ::= SITIO 
            {
              String RESULT =null;
		int sitleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int sitright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object sit = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = "SITIO";   
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("target",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // method ::= 
            {
              String RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("method",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // method ::= PATCH 
            {
              String RESULT =null;
		 RESULT = "PATCH";   
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("method",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // method ::= DELETE 
            {
              String RESULT =null;
		 RESULT = "DELETE";   
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("method",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // method ::= POST 
            {
              String RESULT =null;
		 RESULT = "POST";   
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("method",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // method ::= GET 
            {
              String RESULT =null;
		 RESULT = "GET";   
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("method",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // shttp_request ::= method target scl_instruction body 
            {
              SHTTPRequest RESULT =null;
		int mleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int mright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String m = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String t = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String s = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
        RESULT = new SHTTPRequest(m, t, s, (b != null ? b : ""));
    
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("shttp_request",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= shttp_request EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		SHTTPRequest start_val = (SHTTPRequest)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

