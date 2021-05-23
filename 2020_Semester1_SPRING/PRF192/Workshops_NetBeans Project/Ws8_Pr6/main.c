/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on April 11, 2020, 2:42 PM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

void Files2Array(char* filename, char name[][41], char address[][51], int* mark[], int *pos)
{
    *pos = 0;
    FILE* f = fopen(filename, "r");
    while (fscanf(f, "%[^;];%[^;];%d%*c", name[*pos], address[*pos], &mark[*pos]) == 3)        
        (*pos)++;
    fclose(f);

}

void PrintDesArr(char name[][41], char address[][51], int* mark[], int pos)
{
    int i, j;
    int m;
    char t[51];
    for (i = 0; i < pos; i++)
    {
        for (j = i+1; j < pos; j++)
        {
            if (mark[j] > mark[i])
            {
                m = mark[i];
                mark[i] = mark[j];
                mark[j] = m;
                
                strcpy(t, name[i]);
                strcpy(name[i], name[j]);
                strcpy(name[j], t);
                
                strcpy(t, address[i]);
                strcpy(address[i], address[j]);
                strcpy(address[j], t);
            }
        }
        
        printf("%s; %s; %d\n", name[i], address[i], mark[i]);
    }
}

void Write2File(char* filename, char name[][41], char address[][51], int* mark[], int pos)
{
    FILE* f = fopen(filename, "w");
    for (int i = 0; i < pos; i++)
    {
        fprintf(f, "%s;%s;%d\n", name[i], address[i], mark[i]);
    }
    fclose(f);
    printf("Writing to file %s successfully!", filename);
}

int main(int argc, char** argv) {
   
    char name[50][41];
    char address[50][51];
    int mark[50];
    int pos = 0;
    char filename[] = "students.txt";
    char filename2[] = "students_2.txt";
    
    Files2Array(filename, name, address, mark, &pos);
    printf("The list in descending order: \n");
    PrintDesArr(name, address, mark, pos);
    printf("=================\n");
    Write2File(filename2, name, address, mark, pos);
    
    return (EXIT_SUCCESS);
}

