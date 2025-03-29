
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Sat Mar 29 07:28:33 CST 2025
//----------------------------------------------------

package com.mycompany.back_compi1.Parsers.sCL;

import java_cup.runtime.*;
import com.mycompany.back_compi1.Parsers.SCLRequest;
import java.util.ArrayList;
import java.util.List;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Sat Mar 29 07:28:33 CST 2025
  */
public class ParserScl extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public ParserScl() {super();}

  /** Constructor which sets the default scanner. */
  public ParserScl(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public ParserScl(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\012\000\002\002\004\000\002\002\005\000\002\003" +
    "\003\000\002\003\003\000\002\003\003\000\002\003\003" +
    "\000\002\004\003\000\002\004\003\000\002\005\004\000" +
    "\002\005\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\016\000\012\005\006\006\007\007\010\010\011\001" +
    "\002\000\004\002\020\001\002\000\006\011\014\012\013" +
    "\001\002\000\006\011\uffff\012\uffff\001\002\000\006\011" +
    "\ufffe\012\ufffe\001\002\000\006\011\ufffd\012\ufffd\001\002" +
    "\000\006\011\ufffc\012\ufffc\001\002\000\004\004\015\001" +
    "\002\000\004\004\ufffa\001\002\000\004\004\ufffb\001\002" +
    "\000\006\002\ufff8\004\015\001\002\000\004\002\000\001" +
    "\002\000\004\002\ufff9\001\002\000\004\002\001\001\002" +
    "" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\016\000\006\002\003\003\004\001\001\000\002\001" +
    "\001\000\004\004\011\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\005" +
    "\015\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\005\016\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$ParserScl$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$ParserScl$actions(this);
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
    return action_obj.CUP$ParserScl$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    private SCLRequest request;

    public SCLRequest getRequest() {
            return request;
    }

    public void syntax_error(Symbol token) {
        System.out.println("Syntax error: " + token.value + " at line " + token.left);
    }

    public void unrecovered_syntax_error(Symbol token) {

    }


}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$ParserScl$actions {
  private final ParserScl parser;

  /** Constructor */
  CUP$ParserScl$actions(ParserScl parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$ParserScl$do_action(
    int                        CUP$ParserScl$act_num,
    java_cup.runtime.lr_parser CUP$ParserScl$parser,
    java.util.Stack            CUP$ParserScl$stack,
    int                        CUP$ParserScl$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$ParserScl$result;

      /* select the action based on the action number */
      switch (CUP$ParserScl$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // params ::= ID 
            {
              ArrayList<String> RESULT =null;
		int pleft = ((java_cup.runtime.Symbol)CUP$ParserScl$stack.peek()).left;
		int pright = ((java_cup.runtime.Symbol)CUP$ParserScl$stack.peek()).right;
		String p = (String)((java_cup.runtime.Symbol) CUP$ParserScl$stack.peek()).value;
		 RESULT = new ArrayList<String>(); RESULT.add(p); 
              CUP$ParserScl$result = parser.getSymbolFactory().newSymbol("params",3, ((java_cup.runtime.Symbol)CUP$ParserScl$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScl$stack.peek()), RESULT);
            }
          return CUP$ParserScl$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // params ::= ID params 
            {
              ArrayList<String> RESULT =null;
		int pleft = ((java_cup.runtime.Symbol)CUP$ParserScl$stack.elementAt(CUP$ParserScl$top-1)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$ParserScl$stack.elementAt(CUP$ParserScl$top-1)).right;
		String p = (String)((java_cup.runtime.Symbol) CUP$ParserScl$stack.elementAt(CUP$ParserScl$top-1)).value;
		int psleft = ((java_cup.runtime.Symbol)CUP$ParserScl$stack.peek()).left;
		int psright = ((java_cup.runtime.Symbol)CUP$ParserScl$stack.peek()).right;
		ArrayList<String> ps = (ArrayList<String>)((java_cup.runtime.Symbol) CUP$ParserScl$stack.peek()).value;
		 ps.add(0, p); RESULT = ps; 
              CUP$ParserScl$result = parser.getSymbolFactory().newSymbol("params",3, ((java_cup.runtime.Symbol)CUP$ParserScl$stack.elementAt(CUP$ParserScl$top-1)), ((java_cup.runtime.Symbol)CUP$ParserScl$stack.peek()), RESULT);
            }
          return CUP$ParserScl$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // objetivo ::= PAGINA 
            {
              String RESULT =null;
		 RESULT = "pagina"; 
              CUP$ParserScl$result = parser.getSymbolFactory().newSymbol("objetivo",2, ((java_cup.runtime.Symbol)CUP$ParserScl$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScl$stack.peek()), RESULT);
            }
          return CUP$ParserScl$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // objetivo ::= SITIO 
            {
              String RESULT =null;
		 RESULT = "sitio";  
              CUP$ParserScl$result = parser.getSymbolFactory().newSymbol("objetivo",2, ((java_cup.runtime.Symbol)CUP$ParserScl$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScl$stack.peek()), RESULT);
            }
          return CUP$ParserScl$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // accion ::= MODIFICAR 
            {
              String RESULT =null;
		 RESULT = "modificar"; 
              CUP$ParserScl$result = parser.getSymbolFactory().newSymbol("accion",1, ((java_cup.runtime.Symbol)CUP$ParserScl$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScl$stack.peek()), RESULT);
            }
          return CUP$ParserScl$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // accion ::= ELIMINAR 
            {
              String RESULT =null;
		 RESULT = "eliminar";  
              CUP$ParserScl$result = parser.getSymbolFactory().newSymbol("accion",1, ((java_cup.runtime.Symbol)CUP$ParserScl$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScl$stack.peek()), RESULT);
            }
          return CUP$ParserScl$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // accion ::= AGREGAR 
            {
              String RESULT =null;
		 RESULT = "agregar";   
              CUP$ParserScl$result = parser.getSymbolFactory().newSymbol("accion",1, ((java_cup.runtime.Symbol)CUP$ParserScl$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScl$stack.peek()), RESULT);
            }
          return CUP$ParserScl$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // accion ::= CREAR 
            {
              String RESULT =null;
		 RESULT = "crear";     
              CUP$ParserScl$result = parser.getSymbolFactory().newSymbol("accion",1, ((java_cup.runtime.Symbol)CUP$ParserScl$stack.peek()), ((java_cup.runtime.Symbol)CUP$ParserScl$stack.peek()), RESULT);
            }
          return CUP$ParserScl$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // scl_command ::= accion objetivo params 
            {
              SCLRequest RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$ParserScl$stack.elementAt(CUP$ParserScl$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$ParserScl$stack.elementAt(CUP$ParserScl$top-2)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$ParserScl$stack.elementAt(CUP$ParserScl$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$ParserScl$stack.elementAt(CUP$ParserScl$top-1)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$ParserScl$stack.elementAt(CUP$ParserScl$top-1)).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$ParserScl$stack.elementAt(CUP$ParserScl$top-1)).value;
		int pleft = ((java_cup.runtime.Symbol)CUP$ParserScl$stack.peek()).left;
		int pright = ((java_cup.runtime.Symbol)CUP$ParserScl$stack.peek()).right;
		ArrayList<String> p = (ArrayList<String>)((java_cup.runtime.Symbol) CUP$ParserScl$stack.peek()).value;
		
        RESULT = new SCLRequest( a , b , p);
    
              CUP$ParserScl$result = parser.getSymbolFactory().newSymbol("scl_command",0, ((java_cup.runtime.Symbol)CUP$ParserScl$stack.elementAt(CUP$ParserScl$top-2)), ((java_cup.runtime.Symbol)CUP$ParserScl$stack.peek()), RESULT);
            }
          return CUP$ParserScl$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= scl_command EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$ParserScl$stack.elementAt(CUP$ParserScl$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$ParserScl$stack.elementAt(CUP$ParserScl$top-1)).right;
		SCLRequest start_val = (SCLRequest)((java_cup.runtime.Symbol) CUP$ParserScl$stack.elementAt(CUP$ParserScl$top-1)).value;
		RESULT = start_val;
              CUP$ParserScl$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$ParserScl$stack.elementAt(CUP$ParserScl$top-1)), ((java_cup.runtime.Symbol)CUP$ParserScl$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$ParserScl$parser.done_parsing();
          return CUP$ParserScl$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

