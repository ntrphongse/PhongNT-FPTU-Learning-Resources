/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 03 tháng 3 năm 2020, 20:29
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

int printMinMaxDigit(int n);

int main(int argc, char** argv) {

    int n = -1;
    while (n < 0)
    {
        printf("Enter a positive integer: ");
        scanf("%d", &n);
    }
    printMinMaxDigit(n);
    return (EXIT_SUCCESS);
}

int printMinMaxDigit(int n)
{
    int digit;
    int min, max;
    
    digit = n % 10; // Lấy chữ số hàng đơn vị
    min = digit; max = digit;
    n = n / 10; // Bỏ đi chữ số hàng đơn vị
    
    // Làm tiếp với mấy chữ số hàng tiếp theo
    while (n >= 1)
    {
        digit = n % 10;
        if (digit > max) {max = digit; }
        if (digit < min) {min = digit; }
        n = n / 10;
    }
    printf("Maximum digit is: %d\nMinimum digit is: %d\n", max, min);
}
