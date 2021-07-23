using System;
using DataValidation;

namespace BusinessObject
{
    public class MemberObject
    {
        public int MemberID { get; set; }
        public string MemberName { get; set; }
        private string email;

        public string Email
        {
            get { 
                return email; 
            }
            set {
                if (Validation.IsEmail(value))
                {
                    email = value;
                } else
                {
                    throw new Exception("Wrong format for Email!!");
                }
                
            }
        }

        public string Password { get; set; }
        public string City { get; set; }
        public string Country { get; set; }

    }
}
