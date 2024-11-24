package lang.ast; // The generated scanner will belong to the package lang.ast

import lang.ast.LangParser.Terminals; // The terminals are implicitly defined in the parser
import lang.ast.LangParser.SyntaxError;

%%

// define the signature for the generated scanner
%public
%final
%class LangScanner
%extends beaver.Scanner

// the interface between the scanner and the parser is the nextToken() method
%type beaver.Symbol 
%function nextToken 

// store line and column information in the tokens
%line
%column

// this code will be inlined in the body of the generated scanner class
%{
  private beaver.Symbol sym(short id) {
    return new beaver.Symbol(id, yyline + 1, yycolumn + 1, yylength(), yytext());
  }
%}

// macros
WhiteSpace = [ ] | \t | \f | \n | \r
ID = [a-zA-Z] [a-zA-Z0-9]*
Numeral = [0-9]+
Comment = "//".*

%%

// discard whitespace information
{WhiteSpace}  { }
{Comment}  { }

// token definitions
"int"         { return sym(Terminals.INT); }
"="           { return sym(Terminals.ASSIGN); }
"{"           { return sym(Terminals.LEFTBRAK); }
"}"           { return sym(Terminals.RIGHTBRAK); }
"("           { return sym(Terminals.LEFTPAR); }
")"           { return sym(Terminals.RIGHTPAR); }
";"           { return sym(Terminals.END); }
","           { return sym(Terminals.SEPERATOR); }
"while"       { return sym(Terminals.WHILE); }
"return"       { return sym(Terminals.RETURN); }
"if"          { return sym(Terminals.IF); }
"else"          { return sym(Terminals.ELSE); }
"=="          { return sym(Terminals.EQUAL); }
"!="          { return sym(Terminals.NOTEQUAL); }
"<"           { return sym(Terminals.LESSTHAN); }
">"           { return sym(Terminals.GREATERTHAN); }
"<="           { return sym(Terminals.LESSOREQUALTHAN); }
">="           { return sym(Terminals.GREATEROREQUALTHAN); }
"+"           { return sym(Terminals.ADD); }
"-"           { return sym(Terminals.SUB); }
"*"           { return sym(Terminals.MUL); }
"/"           { return sym(Terminals.DIV); }
"%"           { return sym(Terminals.MOD); }
{Numeral}     { return sym(Terminals.NUMERAL); }
{ID}          { return sym(Terminals.ID); }

<<EOF>>       { return sym(Terminals.EOF); }

/* error fallback */
[^]           { throw new SyntaxError("Illegal character <"+yytext()+">"); }
