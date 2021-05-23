/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on April 11, 2020, 10:46 AM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

void fileArray(char* filename, int* a, int *n)
{
    FILE* f = fopen(filename, "r");
    fscanf(f, "%d", n); 
    /* Đọc phần tử của mảng */
    for (int i = 0; i < *n; i++)
    {
        fscanf(f, "%d", &a[i]);  // Đọc các số tiếp theo
    }
    fclose(f);
    
}

void asc_sort(int *a, int n)
{
    int i, j, t;
    for (i = 0; i < n; i++)
    {
        for (j = i+1; j < n; j++)
        {
            if (a[j] < a[i])
            {
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        printf("%d ", a[i]);
    }
}

int printFile(char* filename, int *a, int n)
{
    FILE* f = fopen(filename, "w");
    fprintf(f, "%d ", n);
    for (int i = 0; i < n; i++)
    {
        fprintf(f, "%d ", a[i]);
    }
    fclose(f);
    printf("\nWritten into file %s successfully!\n", filename);
}

int main(int argc, char** argv) {

    char filename1[] = "array1.txt";
    char filename2[] = "array2.txt";
    int a[200];
    int n = 0;
    fileArray(filename1, a, &n);
    printf("Array in ascending order: \n");
    asc_sort(a, n);
    printFile(filename2, a, n);

    return (EXIT_SUCCESS);
}

