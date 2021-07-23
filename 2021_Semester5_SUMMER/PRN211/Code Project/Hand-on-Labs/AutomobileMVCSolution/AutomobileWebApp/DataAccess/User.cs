using System;
using System.Collections.Generic;

#nullable disable

namespace AutomobileWebApp.DataAccess
{
    public partial class User
    {
        public User()
        {
            Orders = new HashSet<Order>();
        }

        public int UserId { get; set; }
        public string FullName { get; set; }
        public string PhoneNumber { get; set; }
        public string Email { get; set; }
        public string Address { get; set; }
        public string Password { get; set; }
        public bool? Gender { get; set; }
        public DateTime? Birthday { get; set; }
        public int Role { get; set; }
        public bool Status { get; set; }

        public virtual Role RoleNavigation { get; set; }
        public virtual ICollection<Order> Orders { get; set; }
    }
}
