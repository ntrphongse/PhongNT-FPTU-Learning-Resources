/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 28 tháng 2 năm 2020, 20:14
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

    int code;
    printf("ASCII Table\n");
    printf("Dec\tChar\tHex\tOct\n");
    for (code = 0; code <= 255; code ++)
    {
        printf("%d\t%c\t%x\t%o\n", code, code, code, code);
        if (code != 0 && code %20==0) getchar();
    }
    return (EXIT_SUCCESS);
}

