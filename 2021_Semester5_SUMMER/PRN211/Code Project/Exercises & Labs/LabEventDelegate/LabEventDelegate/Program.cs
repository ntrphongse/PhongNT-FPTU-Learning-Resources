using System;
using System.Collections;

namespace LabEventDelegate
{
    class Program
    {
        static void PrintProduct(ArrayList al)
        {
            foreach (Product product in al)
            {
                Console.WriteLine("ProductID: " + product.ProductID);
                Console.WriteLine("ProductName: " + product.ProductName);
                Console.WriteLine("UnitPrice: " + product.UnitPrice);
                Console.WriteLine("Quantity: " + product.Quantity);
                Console.WriteLine("SubTotal: " + product.subtotal);
                Console.WriteLine("---------------------------***---------------------");
            }
        }
        //static void DisplayMessageForRemoveProduct (string message)
        //{
        //    Console.WriteLine(message);
        //}
        static void Main(string[] args)
        {
            Product objCaphe = new Product
            {
                ProductID = 1,
                ProductName = "caphe",
                Quantity = 12,
                UnitPrice = 3
            };

            Product objMilk = new Product
            {
                ProductID = 2,
                ProductName = "milk",
                UnitPrice = 23,
                Quantity = 4
            };

            ManageProduct mp = new ManageProduct();
            mp.RemoveProduct += (string s) =>
            {
                Console.WriteLine(s);
            };

            mp.AddNew(objCaphe);
            mp.AddNew(objMilk);
            Console.WriteLine("**********Danh sach cac mat hang**********");

            PrintProduct(mp.ProductList);

            Console.WriteLine("***************Tim mat hang theo ProductID*****************");
            Console.Write("Enter ProductID = ");
            int productID = int.Parse(Console.ReadLine());
            Product p = mp.Find(productID);
            if (p != null)
            {
                mp.Remove(p.ProductID);
                Console.WriteLine("Press Enter to review product List:");
                Console.ReadLine();
                PrintProduct(mp.ProductList);
            } else
            {
                Console.WriteLine("Product not found!!");
            }
        }
    }
}
