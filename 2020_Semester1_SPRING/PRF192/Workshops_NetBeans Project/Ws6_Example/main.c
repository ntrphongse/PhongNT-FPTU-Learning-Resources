/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 15 tháng 3 năm 2020, 20:35
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

int checkCanadianSIN(int n)
{
    int m[10], c[13];
    int t1, t2, t3, total;
    int i, result=0;
    if (n > 0)
    {
        for (i=9; i>0; i--)
        {
            m[i] = n%10;
            n = n/10;
        }
        
        c[1]=c[5]=m[2];
        c[2]=c[6]=m[4];
        c[3]=c[7]=m[6];
        c[4]=c[8]=m[8];
        c[9]=2*c[1];
        c[10]=2*c[2];
        c[11]=2*c[3];
        c[12]=2*c[4];
        
        t1 = c[9]/10 + c[9]%10 + c[10]/10 + c[10]%10 +
                c[11]/10 + c[11]%10 + c[12]/10 + c[12]%10;
        t2 = m[1]+m[3]+m[5]+m[7];
        total = t1 + t2;
        t3 = ((total/10)+1)*10;
        
        if (t3 - total == m[9]) result =1;
        
        
    }
    return result;
}

int main(int argc, char** argv) {

    int n = 193456787;
    if (checkCanadianSIN(n)==1)
        printf("valid");
    else
        printf("Invalid");
    return (EXIT_SUCCESS);
}

