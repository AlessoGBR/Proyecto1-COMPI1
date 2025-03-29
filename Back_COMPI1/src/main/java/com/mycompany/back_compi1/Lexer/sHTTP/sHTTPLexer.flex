package com.mycompany.back_compi1.Lexer.sHTTP;

import java_cup.runtime.*;
import com.mycompany.back_compi1.Parsers.sHTTP.ParserSym;

%%
%class sHTTPLexer
%unicode
%line
%column
%caseless
%cup
%public

GET = "GET"
POST = "POST"
DELETE = "DELETE"
PATCH = "PATCH"

SITIO = "SITIO"
PAGINA = "PAGINA"

SCL_TEXT = [a-zA-Z0-9_]+( [a-zA-Z0-9_]+)*
BODY = \"[^\"]*\"
WHITESPACE = [ \t\r\n]+

%{
    StringBuffer sb = new StringBuffer();

    private Symbol symbol(int type) {
        return new Symbol(type, yyline+1, yycolumn+1);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }

    private void addError(String message) {
        System.err.println("Error léxico en línea " + (yyline+1) + ", columna " + (yycolumn+1) + ": " + message);
    }

    private void debugToken(String tokenType, String value) {
            System.out.println("[LEXER] Token reconocido: " + tokenType + " -> '" + value + "'");
        }
%}

%eofval{
	return new Symbol(ParserSym.EOF);
%eofval}

%%
{GET}     { debugToken("GET", yytext()); return symbol(ParserSym.GET, yytext()); }
{POST}    { debugToken("POST", yytext()); return symbol(ParserSym.POST, yytext()); }
{PATCH}   { debugToken("PATCH", yytext()); return symbol(ParserSym.PATCH, yytext()); }
{DELETE}  { debugToken("DELETE", yytext()); return symbol(ParserSym.DELETE, yytext()); }
{SITIO}   { debugToken("SITIO", yytext()); return symbol(ParserSym.SITIO, yytext().toUpperCase()); }
{PAGINA}  { debugToken("PAGINA", yytext()); return symbol(ParserSym.PAGINA, yytext().toUpperCase()); }
{SCL_TEXT} { debugToken("SCL_TEXT", yytext()); return symbol(ParserSym.SCL_TEXT, yytext()); }
{BODY}    { debugToken("BODY", yytext()); return symbol(ParserSym.BODY, yytext()); }
{WHITESPACE} { /* Ignorar espacios */ }
.         { addError("Carácter no reconocido: " + yytext()); }