/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 28 tháng 2 năm 2020, 17:05
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    
    int x, y;
    int t;
    do {
        printf("Enter first integer (or 0 to stop): ");
        scanf("%d", &x);
        printf("Enter second integer (or 0 to stop): ");
        scanf("%d", &y);
        t = x;
        x = y;
        y = t;
        printf("Swap integers!!!\n x = %d; y = %d\n", x, y);
    } while (x!=0 && y!=0);
    return (EXIT_SUCCESS);
}

