using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace FirstWebApp
{
    public class DefautController : Controller
    {
        public string Index(string id)
        {
            if (string.IsNullOrEmpty(id))
            {
                return "Welcome to ASP.NET Core MVC";
            } else
            {
                return $"Hello, {id}! Welcome to ASP.NET Core MVC";
            }
        }
    }
}
