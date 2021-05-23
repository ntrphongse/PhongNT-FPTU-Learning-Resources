/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Hp
 *
 * Created on Ngày 05 tháng 3 năm 2020, 20:03
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

void clear_input(void);
int get_an_int(void);
double get_a_double(void);

int main(int argc, char** argv) {
    
    int qty, counter = 0;
    double price, total = 0;
    do
    {
        printf("Enter quantity (0 to stop): ");
        qty = get_an_int();
        if (qty != 0)
        {
            printf("Enter unit price: ");
            price = get_a_double();
            total += qty*price;
            counter += qty;
        }
    } while (qty != 0);
    printf("The total is %.2lf\n", total);
    if (counter != 0)
        printf(" for %d items at an average price of %.2lf\n",
                counter, total/counter);

    return (EXIT_SUCCESS);
}

void clear_input(void)
{
    char junk;
    do
    {
        scanf("%c", &junk);
    } while (junk != '\n');
}

int get_an_int(void)
{
    int n;
    while (0 == scanf("%d", &n))
    {
        clear_input();
        printf("  Error! Please enter an integer: ");
    }
    clear_input();
    return n;
}

double get_a_double(void)
{
    double n;
    while (0 == scanf("%lf", &n))
    {
        clear_input();
        printf("  Error! Please enter a number: ");
    }
    clear_input();
    return n;
}