/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on April 9, 2020, 8:38 PM
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 100
/*
 * 
 */

void addEmp(char code[][9], char name[][21], int pos);
void searchEmp(char code[][9], char name[][21], int pos);
int removeEmp(char code[][9], char name[][21], int pos);
void decEmp(char code[][9], char name[][21], int pos);

char* lTrim(char s[]);
char* rTrim(char s[]);
char* trim(char s[]);
int isFull(char s[], int pos);
int isEmpty(char s[], int pos);

int main(int argc, char** argv) {

    char code[MAX][9];
    char name[MAX][21];
    int pos = -1;
    int choice;
    do
    {
        printf("=====================\n");
        printf("Select an option: \n");
        printf("1 - Add a new employee.\n");
        printf("2 - Find data about employees.\n");
        printf("3 - Remove an employee.\n");
        printf("4 - Print employee list in descending order based on Code.\n");
        printf("5 - Quit.\n");
        scanf("%d", &choice);
        
        switch (choice)
        {
            case 1:
                pos++;
                addEmp(code, name, pos);
                break;
                
            case 2:
                searchEmp(code, name, pos);
                break;
                
            case 3:
                if (removeEmp(code, name, pos) == 1)
                {
                    printf("Remove employee successfully!\n");
                    pos--;
                }
                else
                {
                    printf("There is no such an employee to remove!\n");
                }
                break;
                
            case 4:
                decEmp(code, name, pos);
                break;
        }
    } while (choice != 5);
    return (EXIT_SUCCESS);
}

void addEmp(char code[][9], char name[][21], int pos)
{
    if (isFull(code[pos], pos))
    {
        printf("The list is full!.\n");
    }
    else
    {
        printf("\tAdd the %dth new employee: \n", pos+1);
        printf("\t\tEnter employee's code (8 characters max): ");
        fflush(stdin);
        scanf("%8[^\n]", code[pos]);
        strupr(code[pos]);
        printf("\t\tEnter employee's name (20 characters max): ");
        fflush(stdin);
        scanf("%20[^\n]", name[pos]);
        trim(name[pos]);
        strupr(name[pos]);
        printf("Add new employee with the code %s and the name %s successfully!\n", code[pos], name[pos]);
    }
}

void searchEmp(char code[][9], char name[][21], int pos)
{
    char sstr[21];
    int check = 0;
    if (isEmpty(code[pos], pos))
    {
        printf("\tThe list is empty!");
    }
    else
    {
        printf("\tEnter the name to find data: ");
        fflush(stdin);
        scanf("%20[^\n]", sstr);
        strupr(sstr);
        printf("\t\tSEARCH RESULT\n");
        printf("\t\tCode\t\tName\n");
        for (int i = 0; i <= pos; i++)
        {
            if (strstr(name[i], sstr) != NULL)
            {
                printf("\t\t%s\t\t%s\n", code[i], name[i]);
                check = 1;
            }
        }
        if (check == 0)
            printf("No results found!");
    }
}

int removeEmp(char code[][9], char name[][21], int pos)
{
    char codeRem[9];
    int check = 0;
    int idCheck = -1, i;
    if (isEmpty(code[pos], pos))
    {
        printf("The list is empty!\n");
    }
    else
    {
        printf("\t======================\n");
        printf("\tThe list of employees:\n");
        printf("\t\tCode\t\tName\n");
        for (i = 0; i <= pos; i++)
        {
            printf("\t\t%s\t\t%s\n", code[i], name[i]);
        }
        printf("Enter employee's code to remove: ");
        fflush(stdin);
        scanf("%8[^\n]", codeRem);
        strupr(codeRem);
        for (i = 0; i <= pos; i++)
        {
            if (strcmp(codeRem, code[i]) == 0)
            {
                check = 1;
                idCheck = i;
                break;
            }
        }
        if ((check == 1))
        {
            // remove
            for (i = idCheck; i < pos; i++)
            {
                strcpy(&code[i], &code[i+1]);
                strcpy(&name[i], &name[i+1]);
            }
        }
        return check;
    }
}



void decEmp(char code[][9], char name[][21], int pos)
{
    char cCode[MAX][9];
    char cName[MAX][21];
    char tC[9];
    char tN[21];
    int i, j;
    if (isEmpty(code[pos], pos))
    {
        printf("The list is empty!");
    }
    else
    {
        for (i = 0; i <= pos; i++)
        {
            strcpy(&cCode[i], &code[i]);
            strcpy(&cName[i], &name[i]);
        }
        printf("\t\tList in descending order based on CODE\n");
        printf("\t\t\tCode\t\tName\n");
        for (i = 0; i <= pos; i++)
        {
            for (j = i + 1; j <= pos; j++)
            {
                if (strcmp(cCode[j], cCode[i]) > 0)
                {
                    strcpy(&tC, &cCode[j]);
                    strcpy(&cCode[j], &cCode[i]);
                    strcpy(&cCode[i], &tC);
                    
                    strcpy(&tN, &cName[j]);
                    strcpy(&cName[j], &cName[i]);
                    strcpy(&cName[i], &tN);
                }
            }
            printf("\t\t\t%s\t\t%s\n", cCode[i], cName[i]);
        }
    }
}

char* lTrim (char s[])
{
    int i = 0;
    while (s[i] == ' ')
        i++;
    if ( i > 0)
        strcpy(&s[0], &s[i]);
    return s;
}

char *rTrim (char s[])
{
    int i = strlen(s) - 1;
    while (s[i] == ' ')
        i--;
    s[i+1] = '\0';
    return s;
}

char* trim (char s[])
{
    rTrim(lTrim(s));
    char *ptr = strstr(s, "  ");
    while (ptr != NULL)
    {
        strcpy(ptr, ptr+1);
        ptr = strstr(s, "  ");
    }
    return s;
}

int isFull  (char s[], int pos)
{
    return pos == MAX - 1;
}

int isEmpty (char s[], int pos)
{
    return pos == -1;
}