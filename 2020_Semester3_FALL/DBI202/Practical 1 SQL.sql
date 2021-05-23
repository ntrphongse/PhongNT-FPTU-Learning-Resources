-- Đề 3

--Câu 1
select empSSN, empName, empSalary from tblEmployee 
where empSalary > (select avg(empSalary) as 'AvgSalary'
					from tblEmployee, tblDepartment
					where tblDepartment.depNum = tblEmployee.depNum and tblDepartment.depName=N'Phòng Phần mềm nước ngoài'
					group by tblEmployee.depNum) -- depNum = 2 --> 94800
		and
	depNum = (select depNum from tblDepartment where depName = N'Phòng Phần mềm trong nước') -- 1


--Câu 2
select tblEmployee.empSSN, empName, [Sum work hours]
from tblEmployee, (select tblWorksOn.empSSN, sum(workHours) as 'Sum work hours' 
					from tblWorksOn
					group by tblWorkson.empSSN) wh
where tblEmployee.empSSN=wh.empSSN


--Câu 3
select empSSN, empName, 
		convert(VARCHAR(10),empStartdate,103) as 'Start date', 
		(YEAR(GETDATE()) - YEAR(empStartdate)) as 'Thâm niên'  
from tblEmployee
where (YEAR(GETDATE()) - YEAR(empStartdate)) >= 5


--Câu 4
select empSSN, empName, empAddress, empSex 
from tblEmployee 
where empAddress = N'TP. Hà Nội' and empSex = N'F'


--Câu 5
select proNum, proName, depName from tblProject, tblDepartment
where tblProject.depNum = tblDepartment.depNum and tblDepartment.depName = N'Phòng Dịch vụ chăm sóc khách hàng'


--Đếm tổng số nhân viên nam, nữ
select count(empSex) as 'Nữ', (select count(empSex) from tblEmployee where empSex = 'M') as 'Nam'
from tblEmployee
where empSex = 'F'

--Số nhân viên nam, nữ của từng phòng
select c.depName, a.Nam, b.Nữ
from tblDepartment c,
	(select depNum, count(empSex) as 'Nam' from tblEmployee where empSex = 'M' group by all depNum) a,
	(select depNum, count(empSex) as 'Nữ' from tblEmployee where empSex = 'F' group by all depNum) b
where a.depNum=b.depNum and b.depNum=c.depNum