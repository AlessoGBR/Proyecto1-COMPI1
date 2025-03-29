package com.mycompany.back_compi1.Lexer.sCL;

import java_cup.runtime.*;
import com.mycompany.back_compi1.Parsers.sCL.ParserSym;
%%
%class sCLLexer
%unicode
%line
%column
%caseless
%cup
%public

SITIO = "sitio"
PAGINA = "pagina"

CREAR = "crear"
AGREGAR = "agregar"
ELIMINAR = "eliminar"
MODIFICAR = "modificar"

ID = [a-zA-Z_][a-zA-Z0-9_]*
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
%}

%eofval{
	return new Symbol(ParserSym.EOF);
%eofval}

%%
{SITIO}   { return  symbol(ParserSym.SITIO, yytext().toUpperCase()); }
{PAGINA}  { return  symbol(ParserSym.PAGINA, yytext().toUpperCase()); }
{CREAR}    { return  symbol(ParserSym.CREAR, yytext()); }
{ELIMINAR} { return  symbol(ParserSym.ELIMINAR, yytext()); }
{AGREGAR}  { return  symbol(ParserSym.AGREGAR, yytext()); }
{MODIFICAR} { return  symbol(ParserSym.MODIFICAR, yytext()); }
{ID}       { return  symbol(ParserSym.ID, yytext()); }
{WHITESPACE} { /* Ignorar espacios */ }
.         { addError("Carácter no reconocido: " + yytext()); }