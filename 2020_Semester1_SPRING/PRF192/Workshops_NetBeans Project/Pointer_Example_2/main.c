/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 30 tháng 3 năm 2020, 09:38
 */

#include <stdio.h>
#include <stdlib.h>

int main()
{  int n2= 10;
   int n1= 6;
   int n0= 5;
   printf("n2=%d, n1=%d, n0=%d\n", n2, n1, n0);
   printf("n2=%u, n1=%u, n0=%u\n", &n2, &n1, &n0);
   int* p = &n1;
   *p=9;
   p++;
   *p=15;
   p--;
   p--;
   *p=-3;
   printf("n2=%d, n1=%d, n0=%d\n", n2, n1, n0);
   return (EXIT_SUCCESS);
}


