using Microsoft.AspNetCore.Mvc;
using MyWebApp.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MyWebApp.Controllers
{
    public class ProductController : Controller
    {
        public IActionResult Index()
        {
            ViewBag.Message = "Welcome to ASP.NET Core";
            ViewBag.Product = new ProductModel
            {
                ProductID = 1,
                Name = "Samsung Galaxy Note",
                Brand = "Samsung",
                Price = 19000
            };
            return View();
        }
    }
}
