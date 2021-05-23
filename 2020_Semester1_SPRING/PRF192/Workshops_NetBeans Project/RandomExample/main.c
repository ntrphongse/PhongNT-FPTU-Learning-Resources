/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 27 tháng 3 năm 2020, 09:54
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
 
int main(int argc, char** argv){
    int r;
    srand((int)time(0));
    for(int i = 0; i < 5; ++i){
        r = rand();
        printf("Rand %d is %d\n",i, r);
    }    
    return (EXIT_SUCCESS);
}
