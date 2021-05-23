/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Tran Phong
 *
 * Created on April 17, 2020, 8:38 AM
 */

#include <stdio.h>
#include <stdlib.h>
#define MAX 100

/*
 * 
 */

int isFull(int* a, int pos);
int isEmpty(int* a, int pos);

void addArr(int* a, int* pos);
int searchCount(int* a, int pos, int num);
void searchPrt(int* a, int pos);
void printArr(int* a, int pos);
void desArr(int* a, int pos);
void deleteOnce(int* a, int* pos);
void deleteAll(int* a, int* pos);

int main(int argc, char** argv) {
    int choice;
    int a[MAX];
    int pos = -1;
    do
    {
        printf("====================\n");
        printf("Choose an option (1 to 7): \n");
        printf("1 - Add a value.\n");
        printf("2 - Search a value.\n");
        printf("3 - Print out the array.\n");
        printf("4 - Print out the array in descending order.\n");
        printf("5 - Remove the first existence of a value.\n");
        printf("6 - Remove all existences of a value.\n");
        printf("7 - Quit.\n");
        scanf("%d", &choice);
        switch (choice)
        {
            case 1:
                addArr(a, &pos);
                break;
                
            case 2:
                searchPrt(a, pos);
                break;
                
            case 3:
                printArr(a, pos);
                break;
                
            case 4:
                desArr(a, pos);
                break;
                
            case 5:
                deleteOnce(a, &pos);
                break;
                
            case 6:
                deleteAll(a, &pos);
                break;
                
        }
    } while (choice != 7);
    
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

void addArr(int* a, int* pos)
{
    if (isFull(a, *pos))
        printf("\tThe array is full to add value!\n");
    else
    {
        (*pos)++;
        printf("\tEnter the %dth element of the array: ", *pos+1);
        scanf("%d", &a[*pos]);
        printf("\t\tAdded successfully!\n");
    }
}

int searchCount(int* a, int pos, int num)
{
    int count = 0;
    if (isEmpty(a, pos))
        printf("\tThe array is empty!\n");
    else
        for (int i = 0; i <= pos; i++)
            if (a[i] == num)
                count++;
        return count;
}

void searchPrt(int* a, int pos)
{
    int num;
    int count;
    if (isEmpty(a, pos))
        printf("\tThe array is empty!\n");
    else
    {
        printf("\tEnter the value to search: ");
        scanf("%d", &num);
        count = searchCount(a, pos, num);
        if (count == 0)
            printf("\tThere is NO element of the array to have the value of %d!\n", num);
        else
        {
            printf("\tSearch results: \n");
            for (int i = 0; i <= pos; i++)
                if (a[i] == num)
                {
                    printf("\t\ta[%d] = %d;\n", i, a[i]);
                }
        } 
    }
    
}

void printArr(int* a, int pos)
{
    if (isEmpty(a, pos))
        printf("\tThe array is empty!\n");
    else
    {
        printf("\tArray: \n");
        for (int i = 0; i <= pos; i++)
            printf("\ta[%d] = %d;\n", i, a[i]);
    }
            
}

void desArr(int* a, int pos)
{
    if (isEmpty(a, pos))
        printf("\tThe array is empty!\n");
    else
    {
        int b[MAX];
        int i, j;
        int t;
        for (i = 0; i <= pos; i++)
            b[i] = a[i];
        printf("\tArray in descending order: \n");
        for (i = 0; i <= pos; i++)
        {
            for (j = i+1; j <= pos; j++)
                if (b[j] > b[i])
                {
                    t = b[i];
                    b[i] = b[j];
                    b[j] = t;
                }
            printf("\t%d;", b[i]);
        }
        printf("\n");
    }
}

void deleteOnce(int* a, int* pos)
{
    int num;
    int count;
    if (isEmpty(a, *pos))
        printf("\tThe array is empty!\n");
    else
    {
        printArr(a, *pos);
        printf("\n\tEnter the value you want to remove: ");
        scanf("%d", &num);
        count = searchCount(a, *pos, num);
        if (count == 0)
            printf("\t\tThere is no element to remove!\n");
        else
        {
            for (int i = 0; i <= *pos; i++)
                if (a[i] == num)
                {
                    for (int j = i; j <= *pos; j++)
                        a[j] = a[j+1];
                    (*pos)--;
                    break;
                }
            printf("\t\tRemove successfully!\n");
        }
    }
}

void deleteAll(int* a, int* pos)
{
    int num;
    int count;
    if (isEmpty(a, *pos))
        printf("\tThe array is empty!\n");
    else
    {
        printArr(a, *pos);
        printf("\n\tEnter the value you want to remove: ");
        scanf("%d", &num);
        count = searchCount(a, *pos, num);
        if (count == 0)
            printf("\t\tThere is no element to remove!\n");
        else
        {
            for (int i = *pos; i >= 0; i--)
                if (a[i] == num)
                {
                    for (int j = i; j <= *pos; j++)
                        a[j] = a[j+1];
                    (*pos)--;
                }
            printf("\t\tRemove %d elements successfully!\n", count);
        }
    }
}