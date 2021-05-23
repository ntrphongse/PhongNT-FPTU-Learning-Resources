/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 03 tháng 3 năm 2020, 20:18
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

int gcd(int a, int b);
int lcm(int a, int b);

int main(int argc, char** argv) {

    int a=-1, b=-1, c, d;
    while (a<= 0 || b<=0)
    {
        printf("Enter positive integer a: ");
        scanf("%d", &a);
        printf("Enter positive integer b: ");
        scanf("%d", &b);
    }
    c = gcd(a,b); // UCLN
    d = lcm(a,b); // BCNN
    printf("GCD(%d, %d) = %d\n", a, b, c);
    printf("LCM(%d, %d) = %d\n", a, b, d);
    return (EXIT_SUCCESS);
}

int gcd(int a, int b)
{
    while (a != b)
    {
        if (a > b) { a = a- b; }
        else {b = b- a; }
    }
    return a;
}

int lcm(int a, int b)
{
    return (a*b)/gcd(a,b);
}