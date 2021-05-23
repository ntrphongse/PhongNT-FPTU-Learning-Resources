/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 02 tháng 3 năm 2020, 19:31
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

double factorial(int n);

int main(int argc, char** argv) {
    
    int n;
    do {
        do {
            printf("Enter a positive integer (or 0 to stop): ");
            scanf("%d", &n);
        } while (n < 0);
        printf("Factorial of %d is: %.0lf .\n", n, factorial(n));
    } while (n != 0);
    return (EXIT_SUCCESS);
}

double factorial(int n)
{
    int i;
    double result;
    result = 1.00;
    for (i = 2; i <= n; i++)
    {
        result = result * i;
    }
    return result;
}