/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 02 tháng 3 năm 2020, 08:56
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

    int i; int n;
        do
        {
            printf("Nhap mot so (hoac 0 de ngung): "); 
            scanf("%d", &n);
        } while (n<2 || n>9);
            printf("Bang cuu chuong %d\n", n);
            for (i = 1; i <=10; i++)
            {
                printf("%d x %d = %d\n", n, i, n*i);
            }
    return (EXIT_SUCCESS);
}

