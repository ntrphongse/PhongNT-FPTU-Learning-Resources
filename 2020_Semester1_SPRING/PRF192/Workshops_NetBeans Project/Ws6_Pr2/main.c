/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 16 tháng 3 năm 2020, 08:53
 */

#include <stdio.h>
#include <stdlib.h>
#define MAX 100
/*
 * 
 */

void AddArr(double* n, int pos);
void SearchArr(double* n, int pos);
void PrtArr(double* n, int pos);
void PrtRangeArr(double* n, int pos);
void AscArr(double* n, int pos);

int main(int argc, char** argv) {

    int sel;
    int pos=-1;
    double n[MAX];
    
    do {
        printf("Menu to select: \n");
        printf("1 - Add a value.\n");
        printf("2 - Search a value.\n");
        printf("3 - Print out the array. \n");
        printf("4 - Print out values in a range.\n");
        printf("5 - Print out the array in ascending order.\n");
        printf("6 - Quit.\n\t");
        scanf("%d", &sel);
        
        switch (sel)
        {
            case 1:
                pos += 1;
                AddArr(n, pos);
                break;
                
            case 2:
                SearchArr(n, pos);
                break;
                
            case 3:
                PrtArr(n, pos);
                break;
                
            case 4:
                PrtRangeArr(n, pos);
                break;
                
            case 5:
                AscArr(&n, pos);
                break;
        }
    } while (sel!=6);
    return (EXIT_SUCCESS);
}

void AddArr(double* n, int pos)
{
    if (pos > 99)
    {
        printf("\tThe array is now has 100 elements. You can't add anymore.\n");
    }
    else
    {
        printf("\tEnter the %dth value of the array: ", pos + 1);
        scanf("%lf", &n[pos]);
    }
}

void SearchArr(double* n, int pos)
{
    double checkVal;
    int numVal = 0;
    printf("\tEnter the value to search in the array: ");
    scanf("%lf", &checkVal);
    for (int i = 0; i<= pos; i++)
    {
        if (n[i] == checkVal)
        {
            numVal++;
        }
    }
    
    switch (numVal)
    {
        case 0:
            printf("None of the elements in the array that has the value of %lf.\n", checkVal);
            break;
            
        case 1:
            printf("There is ONE element in the array that has the value of %lf.\n", checkVal);
            break;
            
        default:
            printf("There are %d elements in the array that have the value of %lf.\n", numVal, checkVal);
    }
}

void PrtArr(double* n, int pos)
{
    printf("Array: \n");
    for (int i = 0; i <= pos; i++)
    {
        printf("\tn[%d] = %lf;\n", i, n[i]);
    }
}

void PrtRangeArr(double* n, int pos)
{
    int minVal, maxVal;
    int numVal = 0;
    printf("\tEnter the minimum value: ");
    scanf("%d", &minVal);
    printf("\tEnter the maximum value: ");
    scanf("%d", &maxVal);
    
    for (int i = 0; i <= pos; i++)
    {
        if (n[i] >= minVal && n[i] <= maxVal)
            numVal++;
    }
    
    if (numVal == 0)
    {
        printf("\n\tThere is no value in the array that are between %d and %d: \n", minVal, maxVal);
    }
    else
    {
        printf("\n\tValue(s) in array that are between %d and %d: \n", minVal, maxVal);
        for (int i = 0; i <= pos; i++)
        {
            if (n[i] >= minVal && n[i] <= maxVal)
            {
                printf("\t\tn[%d] = %lf\n", i, n[i]);
            }
        }
    }
}

void AscArr(double* n, int pos)
{
    double t;
    double m[MAX];
    
    for (int i = 0; i<= pos; i++)
    {
        m[i] = n[i];
    }
    printf("Array in ascending order: \n");
    for (int i = 0; i <= pos; i++)
    {
        for (int j = i+1; j <= pos; j++)
        {
            if (m[j] < m[i])
            {
                t = m[i];
                m[i] = m[j];
                m[j] = t;
            }
        }
        
        printf("\t%lf\n", m[i]);
    }
}