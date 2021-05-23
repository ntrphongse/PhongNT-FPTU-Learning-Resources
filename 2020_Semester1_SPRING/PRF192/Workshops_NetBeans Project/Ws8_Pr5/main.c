/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on April 11, 2020, 11:22 AM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    char filename[] = "array3.txt";
    double a[200];
    int i = 0;
    double sum = 0;
    
    FILE* f = fopen(filename, "r");
    
    while (fscanf(f, "%lf", &a[i]) > 0)  // Đọc tới khi không thể truyền giá trị cho tham số được nữa
        i++;
    fclose(f);
    
    for (int j = 0; j < i; j++)
    {
        sum += a[j];
    }
    
    printf("Number of values in the file: %d\n", i);
    printf("Average of values in the file: %lf\n", sum/i);
    return (EXIT_SUCCESS);
}

