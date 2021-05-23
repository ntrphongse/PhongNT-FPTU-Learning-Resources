/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 15 tháng 3 năm 2020, 20:44
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

int checkISBN(int n)
{
    int re = 0;
    int m[11], c[11];
    int k[9]={10,9,8,7,6,5,4,3,2};
    int i;
    int sumn;
    if (n > 1000000)
    {
        for (i=10; i>0; i--)
        {
            m[i] = n%10;
            n = n/10;
        }
        sumn=0;
        sumn = sumn+m[10];
        for (i=1; i<10; i++)
        {
            c[i]=k[i-1]*m[i];
            sumn = sumn+c[i];
        }
        if (sumn%11 ==0) re=1;
    }
    return re;
}

int main(int argc, char** argv) {

    int n;
    do {
        printf("Enter a number (10 digits) (or O to stop): ");
        scanf("%d", &n);
        if (checkISBN(n) == 1) printf("\t%d is an ISBN\n", n);
        else printf("\t%d is not an ISBN\n", n);
        
    } while (n != 0);


    return (EXIT_SUCCESS);
}

