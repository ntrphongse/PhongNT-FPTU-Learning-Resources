/*
Lab 03 - Bai 6a - Bai tap 2
Tran Phong SE150974

---------------------
Cho tuyen thuc thi xong tac vu
*/

#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <pthread.h>		// Khai bao cac ham xu ly tuyen

char message[] = "Hello World";

// Ham xu ly tuyen
void* do_thread (void* data)
{
	printf("Thread function is executing... \n");
	printf("Thread data is %s\n", (char*) message);
	sleep(3);
	strcpy(message, "Bye !");
	pthread_exit("Thank you for using my thread");
}

// Chuong trinh chinh
int main()
{
	int res;
	pthread_t a_thread;
	void* thread_result;
	
	// Tao va thuc thi tuyen
	res = pthread_create (&a_thread, NULL, do_thread, (void*) message);
	
	if (res != 0)
	{
		perror("Thread created error\n");
		exit(EXIT_FAILURE);
	}
	
	// Doi tuyen ket thuc
	printf("Waiting for thread to finish...\n");
	res = pthread_join(a_thread, &thread_result);
	
	if (res != 0)
	{
		perror("Thread wait error\n");
		exit(EXIT_FAILURE);
	}
	
	// In ket qua tra ve cua tuyen
	printf("Thread completed, it returned %s \n", (char*) thread_result);
	printf("Message is now %s \n", message);
	return 0;
}
