/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 02 tháng 3 năm 2020, 20:30
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

int SumDigit(int n);

int main(int argc, char** argv) {

    int n, S;
    do {
        printf("Enter a positive integer (0 to stop): ");
        scanf("%d", &n);
        if (n > 0)
        {
            S = SumDigit(n);
            printf("Sum of the digits of %d is: %d\n", n, S);
        }
    } while (n != 0);
    return (EXIT_SUCCESS);
}

int SumDigit(int n)
{
    int i, S=0;
    while (n > 0)
    {
        i = n % 10; // lấy phần dư của n (hàng đơn vị của n)
        S+=i;
        n = n / 10; // lấy mấy số còn lại
    }
    return S;
}