/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 02 tháng 3 năm 2020, 19:57
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

double fibo(int n);

int main(int argc, char** argv) {

    int n;
        do {
            printf("Enter a positive integer (or 0 to stop): ");
            scanf("%d", &n);
        } while (n < 1);
        printf("The value at the %dth position in Fibonacci sequence is: %.0lf .\n", n,fibo(n));
    return (EXIT_SUCCESS);
}

double fibo(int n)
{
    int i;
    double t1 = 1, t2 = 1;
    int f;
    if (n == 1 || n == 2) { f = 1;}
    else {
        for (i=3; i<=n; i++) {
            f = t2 + t1;
            t1 = t2;
            t2 = f;
        }
    }
    return f;
}