/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 08 tháng 4 năm 2020, 19:02
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    
    int choice;
    
    do 
    {
        printf("\n==================\n");
        printf("Select an option: \n");
        printf("1 - Add a value\n");
        printf("2 - Search a value\n");
        printf("3 - Remove the first existence of a value\n");
        printf("4 - Remove all existences of a value\n");
        printf("5 - Print out the array\n");
        printf("6 - Print out the array in ascending order\n");
        printf("7 - Print ouf the array in descending order\n");
        printf("Others - Quit\n\t");
    } while (choice < 1 & choice > 7)

    return (EXIT_SUCCESS);
}

