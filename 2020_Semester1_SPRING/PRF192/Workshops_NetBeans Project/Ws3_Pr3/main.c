/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 02 tháng 3 năm 2020, 19:11
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

int checkPos(double x, double y, double r);

int main(int argc, char** argv) {

    double x, y, r;
    int result;
    printf("Enter the x: ");
    scanf("%lf", &x);
    printf("Enter the y: ");
    scanf("%lf", &y);
    while (x == 0 && y == 0)
    {
        printf("The point given is the center of the circle !!!\n");
        printf("Enter the x: ");
        scanf("%lf", &x);
        printf("Enter the y: ");
        scanf("%lf", &y);
    } 
    do 
    {
        printf("Enter the radius r > 0: ");
        scanf("%lf", &r);
    } while (r <= 0);

        result = checkPos(x, y, r);
        if (result == 1)
        {
            printf("The point (%.2lf; %.2lf) is IN the circle whose center is O(0; 0) and radius is r = %.2lf", x, y, r);
        }
        else if (result == 0)
        {
            printf("The point (%.2lf; %.2lf) is ON the circle whose center is O(0; 0) and radius is r = %.2lf", x, y, r);
        }
        else
        {
            printf("The point (%.2lf; %.2lf) is OUT OF the circle whose center is O(0; 0) and radius is r = %.2lf", x, y, r);
        }
    return (EXIT_SUCCESS);
}

int checkPos(double x, double y, double r)
{
    double d, rr;
    d = x*x + y*y;
    rr = r*r;
    if (d < rr) {
        return 1;
    }
    else if (d == rr) {
        return 0;
    }
    else {
        return -1;
    }
}