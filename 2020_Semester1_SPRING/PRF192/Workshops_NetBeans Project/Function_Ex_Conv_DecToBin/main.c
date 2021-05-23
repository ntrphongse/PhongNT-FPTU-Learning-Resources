/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 28 tháng 2 năm 2020, 08:56
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

void DecToBin(int num);

int main(int argc, char** argv) {
    int dec;
    dec = 1;
    while (dec>0) {
        printf("\nEnter a decimal number (or O to stop): ");
        scanf("%d", &dec);
        printf("Binary format of %d is: ", dec);
        DecToBin(dec);
        
    } 
    
    return (EXIT_SUCCESS);
}

void DecToBin(int num)
{
    int mod[100];
    int i=0;
    do
    {
        mod[i] = num % 2;
        num = num / 2;
        i = i + 1;
    } while (num!=0);
    
    do
    {
        i--;
        printf("%d", mod[i]);
        
        
    } while (i > 0);
}
