/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 01 tháng 3 năm 2020, 19:45
 */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/*
 * 
 */

int prime(int n);

int main(int argc, char** argv) {

    int n;
    do {
        printf("\nEnter an integer (or 0 to stop): ");
        scanf("%d", &n);
        printf("Prime number between 2 and %d: \n", n);
        for (int i = 2; i<=n; i++){
            
            if (prime(i)==1)
            {
                printf("%d\t", i);
            }
        }
    } while (n != 0);
    return (EXIT_SUCCESS);
}

int prime(int n)
{
    int m = sqrt(n);
    int i, c=1;
    if (n < 2)
    {
        c = 0;
    }

    else
    {
        for (i = 2; i <= m; i++)
        {
            if (n % i == 0)
            {
                c = 0;
                break;
            }
            else
            {
                c = 1;
            }
        }
    }
    return c;
}