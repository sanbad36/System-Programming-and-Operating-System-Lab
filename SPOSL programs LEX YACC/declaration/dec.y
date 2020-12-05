%{
	#include<stdio.h>
  	#include<string.h>
	void yyerror(char *);
	int yylex(void);
	void enter(char *,char *);
	void addQ(char *);

	struct SYMTAB
	{
		char symbol[10];
		char type[10];
	}sym[10];
	int sym_ptr=0;
	int j;
	int Qsize=0;	
	char Q[10][10];

%}
%union	
{
	char val[10];
}

%token <val> ID
%token <val> INT FLOAT DOUBLE BOOLEAN
%type <val> D
%type <val> Decl
%type <val> T
%type <val> L

%%

Decl:Decl'\n'D
    |D
    ;

D:T L';'	{ for(j=0;j<Qsize;j++)
			enter($1,Q[j]);	
		  Qsize=0; 
		}
 ;

T:INT		{strcpy($$,"int");}
 |FLOAT		{strcpy($$,"float");}
 |DOUBLE	{strcpy($$,"double");}
 |BOOLEAN	{strcpy($$,"boolean");}
 ;

L:L','ID 	{addQ($3);}
 |ID		{addQ($1);}
 ;

%%

void print_symtab()
{
        int i;	
	printf("\n SYMBOL\t DATATYPE\n");
	for(i=0;i<sym_ptr;i++)	
	{
		printf("\n %s \t %s",sym[i].symbol,sym[i].type);
	}
	printf("\n");
}

void addQ(char csym[10])
{
	strcpy(Q[Qsize],csym);
 	Qsize++;
}

void yyerror(char *msg)
{
	printf("\n Error: %s\n",msg);
}

void enter(char dtype[5],char dsym[5])
{
		strcpy(sym[sym_ptr].type,dtype);
		strcpy(sym[sym_ptr].symbol,dsym);
		sym_ptr++;
}
int main()
{
        printf("\n Enter declartive Statements. Each stmt should be on new line. Press $ to stop:\n ");
	yyparse();
	print_symtab();
	return 0;
}


