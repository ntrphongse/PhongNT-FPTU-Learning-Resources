using ManageCategoriesConsole;
using ManageCategoriesConsole.BusinessObjects;
using Microsoft.EntityFrameworkCore;
using System;
using System.Linq;

namespace ManageCategoriesConsole
{
    class Program
    {
        static void FilteredIncludes()
        {
            using var db = new MyStoreContext();
            Console.Write("Enter a minimum for units in stock: ");
            string unitsInStock = Console.ReadLine();
            int stock = int.Parse(unitsInStock);
            IQueryable<Category> cats = db.Categories
                .Include(c => c.Products.Where(p => p.UnitsInStock >= stock));
            foreach (Category category in cats)
            {
                Console.WriteLine($"{category.CategoryName} has {category.Products.Count} products");
                foreach (Product product in category.Products)
                {
                    Console.WriteLine($"------> {product.ProductName} has {product.UnitsInStock} units in stock");
                }

            }
        }
        static void Main(string[] args)
        {
            FilteredIncludes();
            Console.ReadLine();
        }
    }
}
