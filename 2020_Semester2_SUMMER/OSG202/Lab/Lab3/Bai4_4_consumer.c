/*
Lab 03 - Bai 4 - Bai tap 4
Tran Phong SE150974

---------------------
Tao hai tien trinh tach biet
--- consumer.c ---
*/

#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <limits.h>
#include <sys/types.h>
#include <sys/stat.h>
#define FIFO_NAME "my_fifo"			// Tao duong ong
#define BUFFER_SIZE PIPE_BUF		// Vung dem dung cho duong ong

int main()
{
	int pipe_fd;
	int res;
	int open_mode = O_RDONLY;
	int bytes_read = 0;
	char buffer[BUFFER_SIZE + 1];
	
	// Mo duong ong de doc
	printf("Process %d starting to read on pipe\n", getpid());
	pipe_fd = open(FIFO_NAME, open_mode);
	if (pipe_fd != -1)
	{
		do
		{
			res = read(pipe_fd, buffer, BUFFER_SIZE);
			bytes_read += res;
		} while (res > 0);
		(void) close (pipe_fd);		// Ket thuc doc
	}
	else
	{
		exit(EXIT_FAILURE);
	}
	printf("Process %d finished, %d bytes read\n", getpid(), bytes_read);
	exit(EXIT_SUCCESS);
}
