using DemoDatabaseFirst.Models;
using System.Linq;
using System;
using Microsoft.EntityFrameworkCore;

namespace DemoDatabaseFirst
{
    class Program
    {
        static void Main(string[] args)
        {
            // Create a DbContext object
            MyStoreContext myStore = new MyStoreContext();

            // Print all products
            var products = from p in myStore.Products
                           select new { p.ProductName, p.CategoryId };
            foreach (var p in products)
            {
                Console.WriteLine($"ProductName: {p.ProductName}, CategoryID: {p.CategoryId}");
            }
            Console.WriteLine("------------------------------------------");

            // A query to get all Categories and their related Products
            IQueryable<Category> cats = myStore.Categories.Include(c => c.Products);
            foreach (Category c in cats)
            {
                Console.WriteLine($"CategoryID: {c.CategoryId} has {c.Products.Count} products");
            }
            Console.ReadLine();
        }
    }
}
