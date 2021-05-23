/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 06 tháng 3 năm 2020, 09:07
 */

#include <stdio.h>
#include <stdlib.h>
#define MAX 255
/*
 * 
 */

int getline1(char line[])
{
    int i=0;
    char c;
    while ((c=getchar()) != '\n')
    {
        if (i < MAX)
        {
            line[i] = c;
            i++;
        }
    }
    return i-1;
}

void backwards(char line[], int size)
{
    int m;
    for (m=size; m>=0; m--)
    {
        printf("%c", line[m]);
    }
}

int main(int argc, char** argv) {

    int i=0, m;
    char n[MAX];
    printf("Enter a 255-max-length string:\n");
    i = getline1(n);
    backwards(n, i);
    printf("\n%d", sizeof(n));
   
    return (EXIT_SUCCESS);
}

