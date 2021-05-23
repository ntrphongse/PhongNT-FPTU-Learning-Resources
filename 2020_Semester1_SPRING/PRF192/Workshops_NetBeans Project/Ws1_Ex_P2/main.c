/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 27 tháng 2 năm 2020, 18:15
 */

#include <stdio.h>
#include <stdlib.h>

int n=2500;
double x=63.5;
char c1='V';

int main(int argc, char** argv) {
    
    int m=-52;
    short s=256;
    long L=1000000;
    float y=-125.54;
    printf("Code of main: %p\n",&main);
    printf("Variable n, address: %p, memory size: %d\n", &n, sizeof(n));
    printf("Variable x, address: %p, memory size: %d\n", &x, sizeof(x));
    printf("Variable c1, address: %p, memory size: %d\n", &c1, sizeof(c1));
    printf("Variable m, address: %p, memory size: %d\n", &m, sizeof(m));
    printf("Variable s, address: %p, memory size: %d\n", &s, sizeof(s));
    printf("Variable L, address: %p, memory size: %d\n", &L, sizeof(L));
    printf("Variable y, address: %p, memory size: %d\n",&y, sizeof(y));
    
    return (EXIT_SUCCESS);
}

