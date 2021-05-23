/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on April 16, 2020, 7:20 PM
 */

#include <stdio.h>
#include <stdlib.h>
#define MAX 100
#define TRUE 1
#define FALSE 0
/*
 * 
 */

int isFull(int* a, int pos);
int isEmpty(int* a, int pos);
void addArr(int a[], int pos);
void sortArrAsc(int a[], int pos);
int writeFile(int a[], int pos);
int checkOdd(int num);
int sumOdd(int* a, int pos);
void printEven(int* a, int pos);
void printOnce(int* a, int pos);
int search(int* a, int pos, int num);
void deleteOne(int* a, int pos);
void deleteAll(int* a, int *pos);

int main(int argc, char** argv) {
    int choice;
    int a[MAX];
    int pos = -1;

    do
    {
        printf("========================\n");
        printf("Choose an option: \n");
        printf("1 - Add a value.\n");
        printf("2 - Sort array in ascending order, print to the screen and write to file.\n");
        printf("3 - Output sum of all odd values.\n");
        printf("4 - Output even values.\n");
        printf("5 - List values that only appear once in the array.\n");
        printf("6 - Delete the first appearance of a value.\n");
        printf("7 - Delete all the appearances of a value.\n");
        printf("8 - Quit.\n");
        scanf("%d", &choice);
        switch (choice)
        {
            case 1:
                pos++;
                addArr(a, pos);
                break;
                
            case 2:
                sortArrAsc(a, pos);
                break;
                
            case 3:
                printf("\tSum of all odd values in the array: %d\n", sumOdd(a, pos));
                break;
                
            case 4:
                printEven(a, pos);
                break;
                
            case 5:
                printOnce(a, pos);
                break;
                
            case 6:
                deleteOne(a, pos);
                pos--;
                break;
                
            case 7:
                deleteAll(a, &pos);
                break;
                
        }
    } while (choice != 8);

    return (EXIT_SUCCESS);
}

int isFull(int* a, int pos)
{
    return pos == MAX - 1; 
}

int isEmpty(int* a, int pos)
{
    return pos == -1;
}

void addArr(int a[], int pos)
{
    if (isFull(a, pos))
        printf("\tThe array is full. You can not add value anymore!\n");
    else
    {
        printf("\tEnter the value of the %dth element of the array: ", pos+1);
        scanf("%d", &a[pos]);
        printf("\tSuccessfully added!\n");
    }
}

void sortArrAsc(int a[], int pos)
{
    int b[MAX];
    int t;
    if (isEmpty(a, pos))
        printf("\tThe array is empty!\n");
    else
    {
        printf("\tArray in ascending order: \n");
        for (int i = 0; i <= pos; i++)
        {
            b[i] = a[i];
        }
        for (int i = 0; i <= pos; i++)
        {
            for (int j = i + 1; j <= pos; j++)
            {
                if (b[i] > b[j])
                {
                    t = b[i];
                    b[i] = b[j];
                    b[j] = t;
                }
            }
            printf("\t%d;", b[i]);
        }
        printf("\n");
        writeFile(b, pos);
    }
}

int writeFile(int a[], int pos)
{
    FILE* f = fopen("array.txt", "w");
    for (int i = 0; i <= pos; i++)
        fprintf(f, "%d\n", a[i]);
    fclose(f);
    printf("\t\tWriting to file successfully!\n");
}

int checkOdd(int num)
{
    return num%2 != 0;
}

int sumOdd(int* a, int pos)
{
    int sum = 0;
    for (int i = 0; i <= pos; i++)
    {
        if (checkOdd(a[i]))
            sum += a[i];
    }
    return sum;
}

void printEven(int* a, int pos)
{
    printf("\tEven value(s) of the array: \n");
    for (int i = 0; i <= pos; i++)
        if (!checkOdd(a[i]))
            printf("\t%d;", a[i]);
    printf("\n");
}

void printOnce(int* a, int pos)
{
    printf("\tValue(s) that appear once in the array: \n");
    for (int i = 0; i <= pos; i++)
        if (search(a, pos, a[i]) == 1)
            printf("\t%d;", a[i]);
    printf("\n");
}

void deleteOne(int* a, int pos)
{
    int num;
    printf("\t\t=====================\n");
    printf("\t\tThe array: \n");
    printf("\t\t");
    for (int i = 0; i <= pos; i++)
        printf("%d;\t", a[i]);
    printf("\n");
    printf("\tEnter the value you want to delete: ");
    scanf("%d", &num);
    for (int i = 0; i <= pos; i++)
    {
        if (a[i] == num)
        {
            for (int j = i; j <= pos; j++)
                a[j] = a[j+1];
            break;
        }
    }
    printf("\t\tDelete successfully!\n");
}

void deleteAll(int* a, int *pos)
{
    int num, count;
    printf("\t\t=====================\n");
    printf("\t\tThe array: \n");
    printf("\t\t");
    for (int i = 0; i <= (*pos); i++)
        printf("%d;\t", a[i]);
    printf("\n");
    printf("\tEnter the value you want to delete: ");
    scanf("%d", &num);
    for (int i = (*pos); i >= 0; i--)
        if (a[i] == num)
        {
            for (int j = i; j <= (*pos); j++)
                a[j] = a[j+1];
            (*pos)--;
        }
    
}

int search(int* a, int pos, int num)
{
    int count = 0;
    for (int i = 0; i <= pos; i++)
        if (a[i] == num)
            count++;
    return count;
}