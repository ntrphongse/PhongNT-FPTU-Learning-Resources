/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 14 tháng 3 năm 2020, 11:13
 */

#include <stdio.h>
#include <stdlib.h>

/*
 *
 */

void isDate(int day, int month, int year);
void chardata();

int main(int argc, char** argv) {

    int m;
    int day, month, year;
    char c1, c2;
    do
    {
        printf("Menu to choose: \n");
        printf("1 - Processing date data.\n");
        printf("2 - Character data.\n");
        printf("3 - Quit.\n");
        scanf("%d", &m);
            switch (m) {
                case 1:
                    printf("\tEnter the day: ");
                    scanf("%d", &day);
                    printf("\tEnter the month: ");
                    scanf("%d", &month);
                    printf("\tEnter the year: ");
                    scanf("%d", &year);
                    isDate(day, month, year);
                    break;

                case 2:
                    chardata();

                    break;
            }
    } while (m > 0 && m < 3);
 


    return (EXIT_SUCCESS);
}

void isDate(int day, int month, int year) {
    int re, daymax;
    if (day <= 0 || month <= 0 || year <= 0 || month > 12) {
        re = 0;
    } else {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            daymax = 31;
        } else if (month == 2) {
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                daymax = 29;
            } else {
                daymax = 28;
            }
        } else {
            daymax = 30;
        }
        re = day <= daymax ? 1 : 0;


    }
    switch (re) {
        case 0:
            printf("The date of %d/%d/%d is not a valid date!\n", day, month, year);
            break;
        case 1:
            printf("The date of %d/%d/%d is a valid date!\n", day, month, year);
            break;
    }
}

void chardata() {
    char c1, c2, i1, t1;
    int i=0;
    printf("\tEnter the first characters: ");
    fflush(stdin);
    c1= getchar();
    
    printf("\tEnter the two characters: ");
    fflush(stdin);
    c2= getchar();
      
    if (c1 > c2) {
        t1 = c1;
        c1 = c2;
        c2 = t1;
    }
    printf("Char\tDec\tHex\n");
    for (i1 = c1; i1 <=c2; i1++) {
        printf("%c: \t%d\t%x\n", i1, i1, i1);
    }
}