/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 01 tháng 3 năm 2020, 19:08
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

    char c1, c2;
    int d;
    char t, c;
    
    printf("Enter the two characters: ");
/*
    scanf("%c", &c1);
    scanf("%c", &c2);
*/
    scanf("%c%c", &c1, &c2);
    if (c1 > c2) {
        t = c1;
        c1 = c2;
        c2 = t;
    }
    d = c2 - c1; // c2 > c1
    printf("\nDifference: %d\n\n", d);
    printf("Characters between %c and %c\n", c1, c2);
    printf("Char\tDec\n");
    for (c = c2; c >= c1; c--)
    {
        printf("%c:\t%d\n", c, c);
    }
    
    
    
    return (EXIT_SUCCESS);
}

