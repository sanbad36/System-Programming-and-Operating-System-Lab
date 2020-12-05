%{
#include"y.tab.h"
#include"stdlib.h"
#include"math.h"
%}
digit [0-9]*

%%
"+"	{return '+';}
"-"	{return '-';}
"*"	{return '*';}
"/"	{return '/';}
"^"	{return '^';}
{digit}	{yylval.val=atoi(yytext);
	return NUM;}
\n	{return '\n';}
"&"	{ return UMINUS; }
sin     { return(SIN);  };
cos     { return(COS);    };
tan     { return(TAN);    };
sqrt    { return(ROOT);   };
fact 		{return FACT;}
ln 		{return LN;}
%%

int yywrap()
{
return 1;
}
