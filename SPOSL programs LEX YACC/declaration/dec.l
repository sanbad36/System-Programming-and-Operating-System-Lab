%{
	#include "y.tab.h"
	#include<string.h>
%}

%%

";"		{       return ';';             }
\n		{       return '\n';             }
","		{       return ',';             }
"int"		{       return INT;             }
"float"		{       return FLOAT;             }
"double"	{       return DOUBLE;             }
"boolean"	{       return BOOLEAN;             }
[a-zA-Z]+	{	strcpy(yylval.val,yytext); return ID;}
"$"		{	return 0;	}

%%

