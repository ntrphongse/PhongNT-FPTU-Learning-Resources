using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

#nullable disable

namespace EmployeeAssemblies.BusinessObject
{
    public partial class Employee
    {
        [Display(Name = "Employee ID")]
        public int EmployeeId { get; set; }

        [Display(Name = "Full Name")]
        public string FullName { get; set; }
        public int Age { get; set; }
        public string Address { get; set; }
    }
}
