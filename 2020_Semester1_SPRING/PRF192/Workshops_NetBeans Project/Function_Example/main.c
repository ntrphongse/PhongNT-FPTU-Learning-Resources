/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 24 tháng 2 năm 2020, 08:55
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
double tk (double tv, double lai, int year);

int main(int argc, char** argv) {
    double von, ls;
    int tg;
    double tien;
    
    printf("Nhap so tien von (VND) (Nhap 0 de dung):"); scanf("%lf", &von);
    while (von < 0) {
        printf("Nhap so tien von (VND) (Nhap 0 de dung):"); scanf("%lf", &von);
 
    }
    while (von != 0){

            printf("Nhap lai suat hang nam (%%/nam):"); scanf("%lf", &ls);

            printf("Nhap thoi gian gui (nam):"); scanf("%d", &tg);
            if (von > 0 && ls > 0 && tg > 0)
            {
        tien = tk(von,ls,tg);
        printf("Gui tiet kiem %.0lf VND voi lai suat %.2lf %%/nam trong thoi gian %d nam.", von, ls, tg);
        printf("\nTong tien nhan duoc la: %.2lf", tien);
        printf("\nTien lai nhan duoc: %.2lf", tien-von);
            }
        printf("\nNhap so tien von (VND) (Nhap 0 de dung):"); scanf("%lf", &von);
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