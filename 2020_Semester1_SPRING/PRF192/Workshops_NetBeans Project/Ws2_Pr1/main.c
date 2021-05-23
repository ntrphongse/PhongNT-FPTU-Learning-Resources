/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 23 tháng 2 năm 2020, 20:50
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    double num1, num2;
    char op;
    double result;
    int true;
    
    printf("Nhap vao phep tinh (VD: 6*4): ");
    scanf("%lf%c%lf", &num1, &op, &num2);
    
    switch (op) {
        case '+':
            result = num1 + num2;
            printf("\n%lf", result);
            break;
        case '-':
            result = num1 - num2;
            printf("\n%lf", result);
            break;
        case '*':
            result = num1*num2;
            printf("\n%lf", result);
            break;
        case '/':
            if (num2==0) { printf("So chia bang 0!!!"); }
            else {
                result = num1/num2;
                printf("\n%lf", result);
            }
            break;
        default: printf("Phep tinh khong ho tro!!!");
    }
    return (EXIT_SUCCESS);
}

