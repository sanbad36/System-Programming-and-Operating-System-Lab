%{
#include<stdio.h>
#include<math.h>
int yyerror(char *);
int i,j;
%}

%union
{
float val;
int j;
}

%token<val>NUM
%token UMINUS RECI EXP MOD CUBE
%type<val>E

%left '+' '-'
%left '*' '/'
%right '^'
%left COS EXP SIN ROOT TAN FACT LN LOG
%nonassoc UMINUS

%%
S:E '\n'	{printf("res: %f\n",$1); return 0;}
  
E:E'+'E		{$$=$1+$3;}
  |E'-'E	{$$=$1-$3;}
  |E'*'E	{$$=$1*$3;}
  |E'/'E	{$$=$1/$3;}
  |E'^'E 	{ $$ = pow($1,$3); }
  |UMINUS E     {$$=-$2;}
  |NUM	
  |SIN E 	{$$ = sin($2*3.141/180);}
  |COS E 	{$$ = cos($2*3.141/180);}
  |TAN E 	{$$ = tan($2*3.141/180);}
  |ROOT E 	{$$ = sqrt($2);}
  |FACT E 	{ 
		$$=1;
		for(j=1;j<=$2;j++)
		$$=$$*j;
		}
  
  |LN E 		{ $$=log($2);
				printf("LOG with base 2 is");
				}	
   ;
%%
int yyerror(char *msg) {
printf("error=%s\n", msg);

}
int main()
{
yyparse();

}

