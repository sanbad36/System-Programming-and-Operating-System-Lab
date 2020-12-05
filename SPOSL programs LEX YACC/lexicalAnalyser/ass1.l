/*

TITLE :
	Lexical analyzer for sample language using LEX.
*/

%{
	#include<stdio.h>
%}

digit [0-9]
letter [a-zA-Z]*

%%

\/\/.*			{printf("%s: comment \n ",yytext);}
"public"					{printf("%s: Access specifier \n",yytext);}		
"void"|"int"|"float"|"char"|"long char"|"long int"	{printf("%s: Data type \n ",yytext);}
"String"					{printf("%s: Inbuilt class \n ",yytext);}


"import"|"static"|"if"|"else"|"for"|"do"|"while"|"class" 	{printf("%s: Keyword \n ",yytext);}

{letter}({letter}|{digit})* 	{printf("%s: Identifier \n ",yytext);}

"+"|"-"|"*"|"/" 		{printf("%s: Arithmetic Operators \n ",yytext);}

"="				{printf("%s: Assignment Operator \n",yytext);}

"++"				{printf("%s: Incrementing Operator \n ",yytext);}

"--"				{printf("%s: Decrementing Operator \n ",yytext);}

"<="|">="|"=="			{printf("%s: Relational Operators \n ", yytext);}

[a-zA-Z]([a-zA-Z]|[0-9])*/\(.*\)	{printf("%s: Function \n ",yytext);}

{digit}*\.{digit}+		{printf("%s: Float Constant \n ",yytext);}

\'.\'				{printf("%s: Character Constant \n ",yytext);}

\[{digit}*\]			{printf("%s: Array \n ",yytext);}

\<				{printf("%s: Opening angular bracket \n ",yytext);}
\>				{printf("%s: Closing angular bracket \n ",yytext);}

\[ 				{printf("%s: Opening square bracket \n ",yytext);}
\] 				{printf("%s: Closing square bracket \n ",yytext);}

\{ 				{printf("%s: Opening curly bracket \n ",yytext);}
\} 				{printf("%s: Closing curly bracket \n ",yytext);}

\( 				{printf("%s: Opening round bracket \n ",yytext);}
\) 				{printf("%s: Closing round bracket \n ",yytext);}

\".*\" 				{printf("%s: String \n ",yytext);}

\;|\, 				{printf("%s: Delimiter \n ",yytext);}

"."				{printf("%s: dot operator \n ",yytext);}

"$" {return 0;}
%%
int yywrap()
{
	return 1;
}


int main()
{
	FILE *fp;
	fp=fopen("add.java","r");
	yyin=fp;

	yylex();

	fclose(fp);

	return 0;
}

