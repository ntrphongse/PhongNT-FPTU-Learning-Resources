/*
Lab 03 - Bai 4 - Bai tap 4
Tran Phong SE150974

---------------------
Tao hai tien trinh tach biet
--- producer.c ---
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
#define TEN_MEG (1024 * 1024 * 10)	// Du lieu

int main()
{
	int pipe_fd;
	int res;
	int open_mode = O_WRONLY;
	int bytes_sent = 0;
	char buffer[BUFFER_SIZE + 1];
	
	// Tao pipe neu chua co
	if (access(FIFO_NAME, F_OK) == -1)
	{
		res = mkfifo(FIFO_NAME, (S_IRUSR | S_IWUSR));
		if (res != 0)
		{
			fprintf(stderr, "FIFO object not created [%s]\n", FIFO_NAME);
			exit (EXIT_FAILURE);
		}
	}
	
	// Mo duong ong de ghi
	printf("Process %d starting to write on pipe\n", getpid());
	pipe_fd = open(FIFO_NAME, open_mode);
	if (pipe_fd != -1)
	{
		// Lien tuc do vao duong ong
		while (bytes_sent < TEN_MEG)
		{
			res = write(pipe_fd, buffer, BUFFER_SIZE);
			if (res == -1)
			{
				fprintf(stderr, "Write error on pipe\n");
				exit(EXIT_FAILURE);
			}
			bytes_sent += res;
		}
		
		// Ket thuc qua trinh ghi du lieu
		(void) close (pipe_fd);
	}
	else
	{
		exit(EXIT_FAILURE);
	}
	printf("Process %d finished, %d bytes sent\n", getpid(), bytes_sent);
	exit(EXIT_SUCCESS);
}
