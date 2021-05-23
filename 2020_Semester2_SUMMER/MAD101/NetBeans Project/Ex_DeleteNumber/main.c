/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on June 15, 2020, 9:56 AM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

    printf("Enter number of people: ");
    int pp;
    scanf("%d", &pp);
    
    printf("Enter number to count to: ");
    int k;
    scanf("%d", &k);
    
    int a[pp];
    for (int i = 0; i < pp; i++)
    {
        a[i] = 1; // All people to be alive
    }
    
    int num = pp;
    int aCount = 0;
    while (num >= k)
        for (int i = 0; i < pp; i++)
            if (num >= k)
            {
                if (a[i] == 1)
                    aCount++;
                    if (aCount == k)
                    {
                        aCount = 0;
                        a[i] = 0; // Dead
                        num--;

                    }
            }
            
    printf("Position to be alive: ");
    for (int i = 0; i < pp; i++)
    {
        if (a[i] == 1)
            printf("%d; ", i+1);
    }
    return (EXIT_SUCCESS);
}

