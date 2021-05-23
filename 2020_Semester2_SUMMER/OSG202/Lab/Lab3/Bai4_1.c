/*
Lab 03 - Bai 4 - Bai tap 1
Tran Phong SE150974

---------------------
Chuong trinh dat bay tin hieu INT
*/

#include <stdio.h>		//Ham nhap xuat chuan
#include <unistd.h>		//Cac ham chuan cua UNIX nhu getpid()
#include <signal.h>		//Cac ham xu ly tin hieu

// Cai dat ham xu ly tin hieu
void catch_int(int sig_num)
{
	signal(SIGINT, catch_int);
	
	// Thuc hien cong viec cua ban o day
	printf("Do not press Ctrl+C\n");
}

// Chuong trinh chinh - main
int main()
{
	int count = 0;
	
	// Thiet lap ham xu ly cho tin hieu INT(Ctrl+C)
	signal(SIGINT, catch_int);		// Dat bay tin hieu INT
	while (1)
	{
		printf("Counting - %d\n", count++);
		sleep(1);
	}
}


