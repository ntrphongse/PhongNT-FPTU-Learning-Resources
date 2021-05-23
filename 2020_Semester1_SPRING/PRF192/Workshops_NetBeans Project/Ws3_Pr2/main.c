/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 01 tháng 3 năm 2020, 20:16
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

int valid(int d, int m, int y);
int leapyear(int y);

int main(int argc, char** argv) {

    int d, m, y;
    int t;
    do {
        printf("Enter the day: "); scanf("%d", &d);
        printf("Enter the month: "); scanf("%d", &m);
        printf("Enter the year: "); scanf("%d", &y);
        if (valid(d, m, y)==1) 
        {
            printf("The date of %d/%d/%d is a valid date!\n", d, m ,y);
        }
        else
        {
            printf("The date of %d/%d/%d is not a valid date!\n", d, m ,y);
        }
        printf("Continue(0 to stop, 1 to continue)? ");
        scanf("%d", &t);
    } while (t!=0);
    return (EXIT_SUCCESS);
}

int valid(int d, int m, int y)
{
    int c;
    int dmax;
    if (d < 1 || d > 31 || m < 1 || m > 12)
    {
        c = 0;
    }
    else
    {
        // set day max;
        if (m == 4 || m == 6 || m == 9 || m == 11)
        {
            dmax = 30;
        }
        else if (m == 2)
        {
            if (leapyear(y)==1)
            {
                dmax = 29;
            }
            else
            {
                dmax = 28;
            }
        }
        else
        {
            dmax = 31;
        }
        
        // checking;
        if (d > dmax)
        {
            c = 0;
        }
        else
        {
            c = 1;
        }
    }
    return c;
}

int leapyear(int y)
{
    if ((y%400 == 0) || ( (y%4 == 0) && (y%100 != 0))) 
    {
        return 1;
    }
    else
    {
        return 0;
    }
}