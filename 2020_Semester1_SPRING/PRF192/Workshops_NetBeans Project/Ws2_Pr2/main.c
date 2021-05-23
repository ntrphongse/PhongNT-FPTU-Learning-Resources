/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 27 tháng 2 năm 2020, 20:12
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */


#define pa 9000000
#define pd 3600000

int main(int argc, char** argv) {

    double inc, tax, tf, ti, inctax;
    int n;
    do
    {
        printf("Enter your income of this year (VND): ");
        scanf("%lf", &inc);
    } while (inc <= 0);
    do
    {
        printf("Enter number of dependent (people): ");
        scanf("%d", &n);
    } while (n < 0);
    if (inc <= 5000000)
    {
        tax = 0.05;
    }
    else if (inc <= 10000000)
    {
        tax = 0.1;
    }
    else if (inc <= 18000000)
    {
        tax = 0.15;
    }
    else 
    {
        tax = 0.2;
    }
    tf = 12*(pa + n*pd);
    ti = inc - tf;
    if (ti <= 0)
    {
        inctax = 0;
        ti=0;
    }
    else
    {
        inctax = ti * tax;
    }
    printf("Tax-free income: %.2lf\n", tf);
    printf("Taxable income: %.2lf\n", ti);
    printf("Income tax: %.2lf\n", inctax);
    
    return (EXIT_SUCCESS);
}

