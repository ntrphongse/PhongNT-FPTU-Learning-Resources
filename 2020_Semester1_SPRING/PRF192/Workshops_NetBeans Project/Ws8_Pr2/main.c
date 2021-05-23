/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on April 11, 2020, 9:44 AM
 */

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#define TRUE 1
#define FALSE 0

/*
 * 
 */

int isExist(char* filename)
{
    int existed = FALSE;
    FILE* f = fopen(filename, "r");
    if (f != NULL)
        existed = TRUE;
    fclose(f);
    return existed;
}

int writeFile(char* filename)
{
    char c[201];
    int length = 0;  // Kiểm tra độ dài chuỗi
    if (isExist(filename) == TRUE)
    {
        printf("The file %s exists. Do you want to overwrite? Y/N: ", filename);
        fflush(stdin);
        if (toupper(getchar()) == 'N')
            return FALSE;
    }
    FILE* f = fopen(filename, "w");
    fflush(stdin);
    printf("Enter strings you want to write to file (Enter 2 times to stop): ");
    do
    {
        gets(c);  // Nhấn Enter 2 lần => length = 0 ==> Dừng
        length = strlen(c);
        if (length > 0)
        {
            fputs(c, f);  // Ghi chuỗi c vào
            fputs("\n", f);  // Kí tự xuống dòng
        }
    } while (length > 0);
    fclose(f);
    return TRUE;
        
}

int printFile(char* filename)
{
    char c;
    if (isExist(filename) == FALSE)
    {
        printf("The file %s does not exist!", filename);
        return FALSE;
    }
    FILE* f = fopen(filename, "r");
    while ( (c = fgetc(f)) != EOF)
        putchar(c);  // In từng kí tự
    fclose(f);
    return TRUE;
}

int main(int argc, char** argv) {

    char filename[100];
    printf("Enter the filename: ");
    scanf("%s[^\n]", filename);
    printf("\t============\n\tWriting into file %s:\n", filename);
    int check = writeFile(filename);
    if (check == TRUE)
    {
        printf("\tWriting to file %s: succesfully!\n", filename);
        printf("\t============\n\tData in file %s:\n", filename);
        int pcheck = printFile(filename);
        if (pcheck == FALSE)
            printf("File error!\n");
    }
    else
        printf("\tWriting to file %s: failed", filename);
    
    return (EXIT_SUCCESS);
}

