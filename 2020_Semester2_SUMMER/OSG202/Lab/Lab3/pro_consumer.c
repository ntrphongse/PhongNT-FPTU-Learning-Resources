/*
Lab 03 - Bai 6b - Bai tap 5
Tran Phong SE150974

---------------------
Giai quyet tranh chap tai nguyen - semaphore
*/

#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>

int product_val = 2;		// San pham ban dau trong kho
sem_t semaphore;		// Khai bao doi tuong semaphore

// Ham thuc thi tuyen
void* do_thread(void* data);

int main()
{
	int res, i;
	pthread_t a_thread;
	void* thread_result;
	
	// Khoi tao doi tuong semaphore - O day ta dat gia tri cho semaphore la 2
	res = sem_init(&semaphore, 0, 2);
	if (res != 0)
	{
		perror("Semaphore init error");
		exit(EXIT_FAILURE);
	}
	
	// Khoi tao tuyen dong vai tro nguoi tieu thu - consumer
	res = pthread_create(&a_thread, NULL, do_thread, NULL);
	
	if (res != 0)
	{
		perror("Thread create error");
		exit(EXIT_FAILURE);
	}	
	
	// Tuyen chinh dong vai tro nguoi san xuat
	for (i = 0; i < 5; i++)
	{
		product_val++;
		printf("Producer product_val = %d \n\n", product_val);
		
		// Tang gia tri semaphore - thong bao san pham da duoc dua them vao kho
		sem_post(&semaphore);
		sleep(2);
	}
	printf("All done\n");
	exit(EXIT_SUCCESS);
}

// Cai dat ham thuc thi tuyen
void* do_thread(void* data)
{
	printf("Consumer thread function is running... \n");
	while(1)
	{
		// Yeu cau semaphore cho biet co duoc phep lay san pham khoi kho hay khong
		sem_wait(&semaphore);
		product_val--;
		printf("Consumer product_val = %d \n", product_val);
		sleep(1);
	}
	pthread_exit(NULL);
}
