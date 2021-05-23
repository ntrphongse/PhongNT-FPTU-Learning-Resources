/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on April 11, 2020, 10:17 AM
 */

#include <stdio.h>
#include <stdlib.h>
#define TRUE 1
#define FALSE 0

/*
 * 
 */

int isExist(char* filename)
{
    int existed = 0;
    FILE* f = fopen(filename, "r");
    if (f != NULL)
        existed = TRUE;
    return existed;
}

int writeFile(char* filename)
{
    char c[201];
    int length = 0;
    if (isExist(filename) == 1)
    {
        printf("The file %s exists. Do you want to overwrite? Y/N: ", filename);
        fflush(stdin);
        if (toupper(getchar()) == 'N')
            return FALSE;
    }
    FILE* f = fopen(filename, "w");
    printf("Enter strings to write into file: ");
    fflush(stdin);
    do
    {
        gets(c);
        length = strlen(c);
        if (length > 0)
            fprintf(f, "%s\n", c);  // Viết vào file f chuỗi c
    } while (length > 0);
    fclose(f);
    return TRUE;
}

int printFile(char* filename)
{
    char c[201];
    if (isExist(filename) == FALSE)
    {
        printf("The file does not existed!\n");
        return FALSE;
    }
    FILE* f = fopen(filename, "r");
    while (fscanf(f, "%[^\n]%*c", c) > 0)  // Đọc file tới khi gặp kí tự xuống dòng & bỏ đi kí tự xuống dòng trong string xuất ra
        puts(c);
    fclose(f);
    return TRUE;
}

int main(int argc, char** argv) {

    char filename[100];
    printf("Enter the file name: ");
    scanf("%s[^\n]", filename);
    printf("\t=========================\n\tWriting to file %s:\n", filename);
    int check = writeFile(filename);
    if (check == TRUE)
    {
        printf("\tWriting to file %s successfully!\n", filename);
        printf("\t=========================\n\tData in file %s: \n", filename);
        int checkp = printFile(filename);
        if (checkp == FALSE)
            printf("File error!\n");
    }
    else
        printf("\tWriting to file %s: failed!\n", filename);
    return (EXIT_SUCCESS);
}

