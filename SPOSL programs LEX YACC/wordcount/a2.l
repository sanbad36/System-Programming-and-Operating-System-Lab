%{

	/* count no. of char, words and lines */

	#include<stdio.h>

	#include<stdlib.h>

	int word_cnt=0;

	int space_cnt=0;

	int num_cnt=0;

	int char_cnt=0;

	int lines=0;

	int digit_cnt=0;

	int tab_cnt=0;

%}

%%

[a-zA-Z]+ {word_cnt++;char_cnt+=yyleng;}

[0-9]+ {num_cnt++; digit_cnt+=yyleng; char_cnt+=yyleng;}

\n {lines++;}

" " {space_cnt++; char_cnt++;}

\t {tab_cnt++;}

%%

int main()

{

	FILE *fp;

	fp=fopen("aa.txt","r");

	yyin=fp;
	
	yylex();

	printf("\n no of word=%d",word_cnt);

	printf("\n no of numb=%d", num_cnt);

	printf("\n no of digit=%d", digit_cnt);

	printf("\n no of line=%d", lines);

	printf("\n no of char=%d", char_cnt);

	printf("\n no of space=%d", space_cnt);

	printf("\n no of tab=%d", tab_cnt);

	return 0;
}
