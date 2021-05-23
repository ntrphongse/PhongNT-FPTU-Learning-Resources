/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 02 tháng 3 năm 2020, 20:11
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

int isFibo(int n, int *p);

int main(int argc, char** argv) {

    int n, i;
    do {
        printf("Enter an integer: ");
        scanf("%d", &n);
    } while (n < 1);
    if (isFibo(n, &i)==1)
    {
        printf("%d is the value at the %dth position of the Fibonacci sequence", n, i);
    }
    else
    {
        printf("%d is not an element of the Fibonacci sequence!", n);
    }
    return (EXIT_SUCCESS);
}

int isFibo(int n, int *p)
{
    int f = 1, i=2;
    int t1 = 1, t2 = 1;
    if (n == 1) { *p = 1; return 1;}
    else {
        while (f < n)
        {
            f = t1 + t2;
            t1 = t2;
            t2 = f;
            i++;
        }
        if (n == f)
        {
            *p = i;
            return 1;
        }
        else
        {
            return 0;
        }
    }
}