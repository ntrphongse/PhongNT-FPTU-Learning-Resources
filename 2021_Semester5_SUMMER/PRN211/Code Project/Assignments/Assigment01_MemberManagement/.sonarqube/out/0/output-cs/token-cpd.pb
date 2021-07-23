Î
—E:\FPTU\PhongNT-FPTU-Learning-Resources\2021_Semester5_SUMMER\PRN211\Code Project\Assignments\Assigment01_MemberManagement\DataValidation\Validation.cs
	namespace 	
DataValidation
 
{ 
public 

static 
class 

Validation "
{ 
public 
static 
bool 
IsEmail "
(" #
string# )
Email* /
)/ 0
{		 	
bool

 
result

 
=

 
false

 
;

  
var 

CheckEmail 
= 
new  !
EmailAddressAttribute! 6
(6 7
)7 8
;8 9
result 
= 

CheckEmail 
.  
IsValid  '
(' (
Email( -
)- .
;. /
return 
result 
; 
} 	
} 
} 