/*
Lab 03 - Bai 4 - Bai tap 2
Tran Phong SE150974

---------------------
Chuong trinh tao duong ong, tao tien trinh con, doc ghi
*/

#include <stdio.h>	
#include <stdlib.h>
#include <unistd.h>	

// Cai dat ham dung thuc thi tien trinh con
void do_child(int data_pipes[])
{
	int c;	// Chua du lieu tu tien trinh cha
	int rc;	// Luu trang thai tra ve cua read()
	
	// Tien trinh con chi doc duong ong nen dong dau ghi do khong can
	close(data_pipes[1]);
	
	// Tien trinh con doc du lieu tu dau doc
	while ( (rc = read(data_pipes[0], &c, 1)) > 0)
	{
		putchar(c);
	}
	exit(0);
}	

// Cai dat ham xu ly cong viec cua tien trinh cha
void do_parent(int data_pipes[])
{
	int c;	// Du lieu doc duoc do nguoi dung nhap vao
	int rc;	// Luu trang thai tra ve cua write()
	
	// Tien trinh cha chi ghi duong ong nen dong dau doc do khong can
	close(data_pipes[0]);
	
	// Nhan du lieu do nguoi dung nhap vao va ghi vao duong ong
	while ( (c = getchar()) > 0)
	{
		// Ghi du lieu vao duong ong
		rc = write(data_pipes[1], &c, 1);
		if (rc == -1)
		{
			perror("Parent: pipe write error");
			close(data_pipes[1]);
			exit(1);
		}
	}
	
	// Dong duong ong phia dau ghi de thong bao cho phia cuoi duong ong du lieu da het
	close(data_pipes[1]);
	exit(0);
}


// Chuong trinh chinh - main
int main()
{
	int data_pipes[2];	// Mang chua so mo ta doc ghi cua duong ong
	int pid;			// pid cua tien trinh con
	int rc;				// Luu ma loi tra ve
	rc = pipe(data_pipes);	// Tao duong ong
	if ( rc == -1 )
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
			do_child(data_pipes);
			
		default:
			do_parent(data_pipes);
	}
	return 0;
}
