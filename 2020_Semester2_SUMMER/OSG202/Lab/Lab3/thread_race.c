/*
Lab 03 - Bai 6a - Bai tap 4
Tran Phong SE150974

---------------------
Tao hai tuyen - su dung mutex
*/

#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <pthread.h>

// Bien du lieu toan cuc co the truy xuat boi ca hai tuyen
int global_var;

pthread_mutex_t a_mutex; 	// Khai bao bien mutex toan cuc

// Khai bao cac ham dung thuc thi tuyen
void* do_thread1(void* data);
void* do_thread2(void* data);

// Chuong trinh chinh
int main()
{
	int res;
	int i;
	pthread_t p_thread1;
	pthread_t p_thread2;
	
	// Khoi tao mutex
	res = pthread_mutex_init (&a_mutex, NULL);
	
	/*
	Cach khac:
	a_mutex = PTHREAD_MUTEX_INITIALIZER;
	*/
	
	if (res != 0)
	{
		perror("Mutex create error");
		exit(EXIT_FAILURE);
	}
	
	// Tao tuyen thu nhat
	res = pthread_create(&p_thread1, NULL, do_thread1, NULL);
	if (res != 0)
	{
		perror("Thread create error");
		exit(EXIT_FAILURE);
	}
	
	// Tao tuyen thu hai
	res = pthread_create(&p_thread2, NULL, do_thread2, NULL);
	if (res != 0)
	{
		perror("Thread create error");
		exit(EXIT_FAILURE);
	}
	
	// Tuyen chinh cua chuong trinh
	for (i = 1; i < 20; i++)
	{
		printf("Main thread waiting %d second... \n", i);
		sleep(1);
	}
	return 0;
}

// Cai dat ham thuc thi tuyen thu nhat
void* do_thread1(void* data)
{
	int i;
	pthread_mutex_lock(&a_mutex); 	// Khoa mutex
	
	for (i = 1; i <= 5; i++)
	{
		printf("Thread 1 count: %d with global value %d \n", i, global_var++);
		sleep(1);
	}
	pthread_mutex_unlock(&a_mutex);		// Thao khoa mutex
	
	printf("Thread 1 completed !");
}

void* do_thread2(void* data)
{
	int i;
	pthread_mutex_lock(&a_mutex); 	// Khoa mutex
	
	for (i = 1; i <= 5; i++)
	{
		printf("Thread 2 count: %d with global value %d \n", i, global_var++);
		sleep(1);
	}
	pthread_mutex_unlock(&a_mutex);		// Thao khoa mutex
	
	printf("Thread 2 completed !");
}
