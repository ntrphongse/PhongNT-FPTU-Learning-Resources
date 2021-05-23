/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 26 tháng 2 năm 2020, 09:22
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

double tk (double tv, double lai, int year);

int nhapdl(int c, double *var);

int main(int argc, char** argv) {
    
    double percent;
    double tv, lsmin, lsmax;
    double tg;
    nhapdl(1, &tv);
    nhapdl(2, &lsmin);
    nhapdl(3, &lsmax);
    nhapdl(4, &tg);
    printf("Comparison of %.0lf-year returns at different rates\n", tg);
    printf("   Rate       Profit (per Thousand VND)\n");
    printf("   ----       -------------------------\n");
    for (percent = lsmin; percent < lsmax; percent = percent + 0.5)
    {
        printf("   %.2lf                %.2lf\n", percent, tk(tv, percent, tg) - tv);
        
    }
    return (EXIT_SUCCESS);
}

double tk (double tv, double lai, int year)
{
    int i = 1;
    while (i <= year)
    {
        tv = tv*(1+lai/100);
        i=i+1;
    }
    return tv;
}

int nhapdl(int c, double *var)
{
    double rep;
    switch (c)
    {
        case 1:
            printf("Nhap so tien von ban dau (nghin dong): ");
            scanf("%lf", &rep);
            while (rep <= 0)
            {
                printf("Nhap so tien von ban dau (nghin dong): ");
                scanf("%lf", &rep);
            }
            
        case 2:
            printf("Nhap so lai suat 1 (%%/nam): "); 
            scanf("%lf", &rep);
            while (rep <= 0)
            {
                printf("Nhap so lai suat 1 (%%/nam): "); 
                scanf("%lf", &rep);
            }
            
        case 3:
            printf("Nhap so lai suat 2 (%%/nam): "); 
            scanf("%lf", &rep);
            while (rep <= 0)
            {
                printf("Nhap so lai suat 2 (%%/nam): "); 
                scanf("%lf", &rep);
            }
            
        case 4:
            printf("Nhap thoi gian gui (nam): "); 
            scanf("%lf", &rep);
            while (rep <= 0)
            {
                printf("Nhap thoi gian gui (nam): "); 
                scanf("%lf", &rep);    
            }
    }
    
    *var = rep;
}