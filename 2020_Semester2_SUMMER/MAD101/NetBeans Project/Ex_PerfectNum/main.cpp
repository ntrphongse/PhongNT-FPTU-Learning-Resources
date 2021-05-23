/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Hp
 *
 * Created on June 10, 2020, 1:45 PM
 */

#include <cstdlib>
#include <stdio.h>
using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {

    int sum = 0;
    int i, j;
    printf("Perfect number <= 3000: \n");
    for (i = 1; i <= 3000; i++)
    {
        for (j = 1; j < i; j++)
        {
            if (i%j == 0)
                sum = sum + j;
        }
        if (sum == i)
            printf("%d\n", i);
        sum = 0;
    }
    return 0;
}

