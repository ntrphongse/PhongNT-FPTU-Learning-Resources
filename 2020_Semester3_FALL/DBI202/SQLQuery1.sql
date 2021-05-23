-- Xuất thông tin (mã tên) của những phòng có địa chỉ ở HN thực hiện dự án ở Cần Thơ
SELECT tblDepartment.depNum AS 'Mã', tblDepartment.depName AS 'Tên'
FROM (((tblDepartment INNER JOIN tblDepLocation
		ON tblDepartment.depNum = tblDepLocation.depNum)
	INNER JOIN tblLocation
		ON tblDepLocation.locNum = tblLocation.locNum)
	INNER JOIN tblProject
		ON tblProject.depNum = tblDepartment.depNum)
WHERE locName = 'TP Hà Nội' and tblDepLocation.locNum = '1'