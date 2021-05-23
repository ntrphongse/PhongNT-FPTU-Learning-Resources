/*
Lab 03 - Bai 4 - Bai tap 3
Tran Phong SE150974

---------------------
Chuong trinh tao 2 duong ong, tao tien trinh con, doc ghi, chuyen thanh ki tu hoa
*/

#include <stdio.h>	
#include <stdlib.h>
#include <unistd.h>	
#include <string.h>

// Ham thuc thi cua tien trinh con
void do_child(int write_pipe[], int read_pipe[])
{
	char c;
	int rc;
	// Dong chieu doc cua duong ong ghi
	close(write_pipe[0]);
	// Dong chieu ghi cua duong ong doc
	close(read_pipe[1]);
	
	// Tien trinh con doc du lieu tu dau doc -> Chuyen thanh chu hoa
	while ( (rc = read(read_pipe[0], &c, 1)) > 0)
	{
		
		c = toupper(c);
		
		// Ghi vao duong ong thu 2
		write(write_pipe[1], &c, 1);
	}
	close(write_pipe[1]);
	close(read_pipe[0]);
}

// Ham thuc thi cua tien trinh cha
void do_parent(int write_pipe[], int read_pipe[])
{
	char c;
	int rc;
	// Dong chieu doc cua duong ong ghi
	close(write_pipe[0]);
	// Dong chieu ghi cua duong ong doc
	close(read_pipe[1]);
	
	// Doc du lieu tu ban phim
	while ( (c = getchar()) > 0)
	{
		// Ghi du lieu vao duong ong
		rc = write(write_pipe[1], &c, 1);
		if (rc == -1)
		{
			perror("Parent: pipe write error");
			close(write_pipe[1]);
			exit(1);
		}
		
		// Doc du lieu tu duong ong thu 2 va hien thi len man hinh
		read(read_pipe[0], &c, 1);
		printf("%c",c);
	}
	
	// Dong duong ong phia dau ghi de thong bao cho phia cuoi duong ong du lieu da het

	close(write_pipe[1]);
	close(read_pipe[0]);
}

// Main
int main()
{
	int read_pipe[2];	// Mang chua so mo ta doc ghi cua duong ong
	int write_pipe[2];
	int pid;			// pid cua tien trinh con
	int rc1, rc2;				// Luu ma loi tra ve
	rc1 = pipe(read_pipe);	// Tao duong ong
	rc2 = pipe(write_pipe);
	if ( rc1 == -1 || rc2 == -1 )
	{
		perror("Error: pipe not created");
		exit(1);
	}
	
	// Tao tien trinh con
	pid = fork();
	switch (pid)
	{
		case -1:		// Khong tao duoc tien trinh con
			perror("Child process not create");
			exit(1);
			
		case 0:
			do_child(write_pipe, read_pipe);
			
		default:
			do_parent(read_pipe, write_pipe);
	}
	return 0;
}
