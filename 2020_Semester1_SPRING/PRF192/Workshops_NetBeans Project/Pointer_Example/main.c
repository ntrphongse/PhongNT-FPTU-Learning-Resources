/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 29 tháng 2 năm 2020, 08:57
 */

#include <stdio.h>
#include <stdlib.h>
#define r 3.14

/*
 * 
 */

void hoanvi(int *a, int *b)
{
    int temp;
    printf("a = %d; b = %d\n", *a, *b);
    temp = *a;
    *a = *b;
    *b = temp;
    printf("a = %d; b = %d\n", *a, *b);
}

int main(int argc, char** argv) {
    int x=2, y=9;
    
    printf("x = %d; y = %d\n", x, y);
    hoanvi(&x, &y);
    printf("x = %d; y = %d\n", x, y);
    return (EXIT_SUCCESS);
}

