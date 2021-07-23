using System;
using System.ComponentModel.DataAnnotations;

namespace DataValidation
{
    public static class Validation
    {
        public static bool IsEmail(string Email)
        {
            bool result = false;

            var CheckEmail = new EmailAddressAttribute();
            result = CheckEmail.IsValid(Email);

            return result;
        }
    }
}
