/*
Lab 03 - Bai 6a - Bai tap 1
Tran Phong SE150974

---------------------
Chuong trinh tao lap tuyen
*/

#include <stdio.h>
#include <pthread.h>		// Khai bao cac ham xu ly tuyen

// Ham thuc thi tuyen
void* do_loop (void* data)
{
	int i; 		// Bo dem cho tuyen
	
	// Du lieu cho ham pthread_create() truyen vao cho tuyen
	int me = (int*) data;
	
	for (i = 0; i < 5; i++)
	{
		sleep(1); // Dung
		printf(" '%d' - Got '%d' \n", me, i);
	}
	
	// Cham dut tuyen
	pthread_exit(NULL);
}

// Chuong trinh chinh

int main(int agrc, char* argv[])
{
	int thr_id;		// Dinh danh tuyen
	pthread_t p_thread;		// Cau truc luu tru cac thong tin ve tuyen
	int a = 1;		// Dinh danh cho tuyen thu nhat
	int b = 2; 		// Dinh danh cho tuyen thu hai
	
	// Tao tuyen
	thr_id = pthread_create(&p_thread, NULL, do_loop, (void*)a);
	
	// Chay do_loop trong tuyen chinh
	do_loop((void*)b);
	return 0;
}
