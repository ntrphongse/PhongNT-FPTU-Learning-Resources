/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Tran Phong
 *
 * Created on April 9, 2020, 7:16 PM
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 100
/*
 * 
 */

void addstu(char stu[][MAX+1], int pos);
void removestu(char stu[][MAX+1], int pos);
void searchstu(char stu[][MAX+1], int pos);
void printasc(char stu[][MAX+1], int pos);

// Hàm Loại bỏ khoảng trắng và NameStr
char* lTrim(char s[]);
char* rTrim(char s[]);
char* trim(char s[]);

// Kiểm tra danh sách
int isFull(char s[], int pos);
int isEmpty(char s[], int pos);


int main(int argc, char** argv) {

    char stu[MAX][MAX+1];
    int choice;
    int pos = -1;
    
    do
    {
        printf("=================\n");
        printf("Choose an option: \n");
        printf("1 - Add a student.\n");
        printf("2 - Remove a student.\n");
        printf("3 - Search a student.\n");
        printf("4 - Print the list in ascending order.\n");
        printf("5 - Quit.\n");
        scanf("%d", &choice);
        switch (choice)
        {
            case 1:
                pos++;
                addstu(stu, pos);
                break;
                
            case 2:
                removestu(stu, pos);
                pos--;
                break;
                
            case 3:
                searchstu(stu, pos);
                break;
                
            case 4:
                printasc(stu, pos);
                break;
        }
    } while (choice != 5);

    return (EXIT_SUCCESS);
}

void addstu(char stu[][MAX+1], int pos)
{
    if (isFull(stu[pos], pos))
    {
        printf("\tThere are 100 students already!\n");
    }
    else
    {
        printf("\tEnter %dth Student name (maximum 100 characters): ", pos+1);
        fflush(stdin);
        scanf("%100[^\n]", stu[pos]);
        trim(stu[pos]);
        strupr(stu[pos]);
        printf("Add student: %s successfully.\n", stu[pos]);
    }
}

void removestu(char stu[][MAX+1], int pos)
{
    int remPos;
    if (isEmpty(stu[pos], pos))
    {
        printf("\tThe list is empty. Please enter some students!\n");
    }
    else
    {
        printf("====================\n\t\tThe list of students:\n");
        printf("\t\t\tID\tName\n");
        for (int i = 0; i <= pos; i++)
        {
            printf("\t\t\t%d\t", i);
            puts(stu[i]);
            printf("\n");
        }
        do
        {
            printf("\tEnter the ID of student you want to remove: ");
            scanf("%d", &remPos);
        } while (remPos < 0 || remPos > pos);
        
        // remove
        for (int i = remPos; i < pos; i++)
            strcpy(&stu[i], &stu[i+1]);
        printf("Remove student successfully!\n");
    }
}

void searchstu(char stu[][MAX+1], int pos)
{
    char s[MAX+1];
    int check = 0;
    if (isEmpty(stu[pos], pos))
    {
        printf("\tThe list is empty. Please enter some students!\n");
    }
    else
    {
        printf("\tEnter student to search: ");
        fflush(stdin);
        scanf("%100[^\n]", s);
        strupr(s);
        printf("\t\t\tSEARCH RESULT:\n");
        printf("\t\t\tID\tName\n");
        for (int i = 0; i <= pos; i++)
        {
            if ((strstr(stu[i], s)) != NULL)
            {
                check = 1;
                printf("\t\t\t%d\t", i);
                puts(stu[i]);
                printf("\n");
            }
        }
    }
    if (check == 0)
        printf("No results found!");
}

void printasc(char stu[][MAX+1], int pos)
{
    if (isEmpty(stu[pos], pos))
    {
        printf("\tThe list is empty. Please enter some students!\n");
    }
    else
    {
        char nstu[MAX][MAX+1];
        int i, j;
        char t[MAX+1];
        printf("\t\tSTUDENTS IN ASCENDING ORDER\n");
        for (i = 0; i <= pos; i++)
        {
            strcpy(nstu[i], stu[i]);
        }
        for (i = 0; i <= pos; i++)
        {
            for (j = i+1; j <= pos; j++)
            {
                if (strcmp(nstu[j], nstu[i]) < 0)
                {
                    strcpy(t, nstu[j]);
                    strcpy(nstu[j], nstu[i]);
                    strcpy(nstu[i], t);
                }
            }
            printf("\t\t\t");
            puts(nstu[i]);
            printf("\n");
        }
    }
}

// Loại khoảng trắng bên trái sring
char* lTrim(char s[])
{
    int i = 0;
    while (s[i] == ' ') 
        i++;
    if (i > 0)
        strcpy(&s[0], &s[i]);
    return s;
}

// Loại khoảng trắng bên phải sring
char* rTrim(char s[])
{
    int i = strlen(s) - 1;
    while (s[i] == ' ')
        i--;
    s[i+1] = '\0';
    return s;
}

// Loại từ 2 khoảng trắng trở lên (khoảng trắng thừa)
char* trim(char s[])
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

// Mảng đầy
int isFull(char s[], int pos)
{
    return pos == MAX - 1;
}

// Mảng rỗng
int isEmpty(char s[], int pos)
{
    return pos == -1;
}