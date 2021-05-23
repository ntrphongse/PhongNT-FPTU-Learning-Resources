/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 03 tháng 3 năm 2020, 20:06
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

double mDouble(double ipart, double fraction);

int main(int argc, char** argv) {

    int ipart, fraction = -1;
    double value;
    printf("Enter the integral part: ");
    scanf("%d", &ipart);
    while (fraction < 0)
    {
        printf("Enter its positive fraction: ");
        scanf("%d", &fraction);
    } 
    value = mDouble(ipart, fraction);
    printf("The real number is: %lf", value);
    return (EXIT_SUCCESS);
}

double mDouble(double ipart, double fraction)
{
    double result;
    while (fraction >= 1)
    {
        fraction = fraction / 10; // 123 -> 12.3 -> 1.23 -> 0.123
    }
    if (ipart >= 0)
    {
        result = ipart + fraction; // 5 & 0.123 -> 5.123
    }
    else
    {
        result = ipart - fraction; // -5 & 0.123 -> -5.123
    }
    return result;
}