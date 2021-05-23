/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 28 tháng 2 năm 2020, 17:13
 */

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

/*
 * 
 */
int main(int argc, char** argv) {

    int nVo=0, nCons=0, nOth=0;
    char ch;
    printf("Enter a string: ");
    do {
        ch=getchar();
        ch = toupper(ch);
        if (ch >= 'A' && ch <= 'Z')
        {
            switch (ch)
            {
                case 'A': nVo++; break;
                case 'E': nVo++; break;
                case 'I': nVo++; break;
                case 'O': nVo++; break;
                case 'U': nVo++; break;
                default: nCons++; break;
            }    
        }
        else
        {
            nOth++;
        }
    } while (ch != '\n');
    printf("Number of vowels: %d\nNumber of Consonants: %d\nNumber of other characters: %d", nVo, nCons, nOth-1);
    return (EXIT_SUCCESS);
}

