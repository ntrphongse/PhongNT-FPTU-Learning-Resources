/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on April 11, 2020, 8:50 AM
 */

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#define FALSE 0
#define TRUE 1

/*
 * 
 */

int isExist(char* filename)
{
    int existed = FALSE;
    
    
    FILE* f = fopen(filename, "r");
    if (f != NULL)
    {
        existed = TRUE;
        fclose(f);
    }
    return existed;
    
}

int writeFile(char* filename)
{
    char c;
    int CtrlZ = -1;
    int check;
    if (isExist(filename))
    {
        printf("The file %s exists. Overwrite it Y/N? : ", filename);
        if (toupper(getchar()) == 'N')
            return FALSE;
    }
    FILE* f = fopen(filename, "w");
    printf("Enter what you want to write (Ctrl + Z to stop): ");
    fflush(stdin);
    do
    {
        c = getchar();
        if (c != CtrlZ)
            fputc(c, f);
    } while (c != CtrlZ);

    fclose(f);  // Đóng file
    return TRUE;
}

int main(int argc, char** argv) {
    if (argc != 2)
        printf("Syntax: Ws8_Pr1 filename\n");
    else 
        if (writeFile(argv[1]) == TRUE)
            printf("Writing the file %s: done.\n", argv[1]);
        else
            printf("Can not write the file %s!\n", argv[1]);
        
    return (EXIT_SUCCESS);
}

