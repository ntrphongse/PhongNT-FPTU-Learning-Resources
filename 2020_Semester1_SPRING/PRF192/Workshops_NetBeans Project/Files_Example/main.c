/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 09 tháng 3 năm 2020, 09:08
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
 * 
 */
int main(int argc, char** argv) {

    FILE *fp;
    
    char file_name[25];
    char s[255];
    char t[255];
    printf("Enter the 25 max length filename: ");
    gets(file_name);
    fp = fopen(file_name, "r"); //r: read; w: write; a: write continuously
    fgets(s, 255,fp);
    fgets(t, 255,fp);
    fclose(fp);
    printf("%s\t%s",s, t);
    return (EXIT_SUCCESS);
}

