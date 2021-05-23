/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 04 tháng 3 năm 2020, 09:15
 */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/*
 * 
 */

int prime(int n);
void minmax(int n);

int main(int argc, char** argv) {

    int select, n=-1;
    do {
        printf("Select one of these functions: \n");
        printf("1 - Process primes\n");
        printf("2 - Print min, max digit in an integer\n");
        printf("3 - Quit\n");
        scanf("%d", &select);
        switch (select)
        {
            case 1:
                do 
                {
                    printf("\tEnter a positive integer: ");
                    scanf("%d", &n);
                } while (n <= 1);
                if (prime(n)==1) {
                    printf("%d is a prime!\n", n);                
                }
                else
                {
                    printf("%d is not a prime!\n", n);
                }
                break;
            case 2:
                do 
                {
                    printf("\tEnter a positive integer: ");
                    scanf("%d", &n);
                } while (n <= 0);
                minmax(n);
                break;
        }
    } while (select > 0 && select < 3);
    return (EXIT_SUCCESS);
}

int prime(int n)
{
    int i, re=1;
    int nn = sqrt(n);
    for (i=2; i <= nn; i++)
    {
        if (n%i == 0)
        {
            re = 0;
            break;
        }
        else
        {
            re = 1;
        }
    }
    return re;
}

void minmax(int n)
{
    int min, max, digit;
    digit = n%10;
    min = digit;
    max = digit;
    n = n/10;
    
    while (n>0)
    {
        digit = n%10;
        if (digit < min) {min = digit; }
        if (digit > max) {max = digit; }
        n = n/10;
    }
    printf("Max digit is: %d\n", max);
    printf("Min digit is: %d\n", min);
}