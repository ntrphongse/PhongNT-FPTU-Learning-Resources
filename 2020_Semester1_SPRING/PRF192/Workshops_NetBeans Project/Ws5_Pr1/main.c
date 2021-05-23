/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 27 tháng 3 năm 2020, 09:37
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
/*
 * 
 */

int main(int argc, char** argv) {
    srand(time(NULL));
    int n;
    int x, y;
    int count = 0;
    do
    {
        printf("Enter n (between 2 and 12): ");
        scanf("%d", &n);
    } while (n < 2 || n > 12);
    
    do
    {
        count++;
        
        x = rand()%6 + 1;
        y = rand()%6 + 1;
        printf("Result of throw %d: %d + %d \n", count, x, y);
    } while ((x+y)!=n);
    printf("\nYou got your total in %d throws!", count);
    return (EXIT_SUCCESS);
}