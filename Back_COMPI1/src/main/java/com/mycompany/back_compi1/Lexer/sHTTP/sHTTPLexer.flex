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

CREAR = "crear"
AGREGAR = "agregar"
ELIMINAR = "eliminar"
MODIFICAR = "modificar"

ID = [a-zA-Z_][a-zA-Z0-9_]*
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
%}

%eofval{
	return new Symbol(ParserSym.EOF);
%eofval}

%%
{GET}     { return  symbol(ParserSym.GET, yytext()); }
{POST}    { return  symbol(ParserSym.POST, yytext()); }
{PATCH}   { return  symbol(ParserSym.PATCH, yytext()); }
{DELETE}  { return  symbol(ParserSym.DELETE, yytext()); }
{SITIO}   { return  symbol(ParserSym.SITIO, yytext().toUpperCase()); }
{PAGINA}  { return  symbol(ParserSym.PAGINA, yytext().toUpperCase()); }
{CREAR}    { return  symbol(ParserSym.CREAR, yytext()); }
{ELIMINAR} { return  symbol(ParserSym.ELIMINAR, yytext()); }
{AGREGAR}  { return  symbol(ParserSym.AGREGAR, yytext()); }
{MODIFICAR} { return  symbol(ParserSym.MODIFICAR, yytext()); }
{BODY} { return  symbol(ParserSym.BODY, yytext()); }
{ID}       { return  symbol(ParserSym.ID, yytext()); }
{WHITESPACE} { /* Ignorar espacios */ }
.         { addError("Carácter no reconocido: " + yytext()); }