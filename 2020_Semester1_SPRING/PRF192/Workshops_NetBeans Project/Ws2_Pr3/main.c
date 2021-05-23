/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 27 tháng 2 năm 2020, 20:35
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    
    int x; long s=0;
    do {
        printf("Enter an integer (or 0 to stop): ");
        scanf("%d", &x);
        s = s + x;
    }
    while (x!=0);
    printf("Sum: %ld", s);
    return (EXIT_SUCCESS);
}

