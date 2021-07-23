using System;

namespace OOPGetSet
{
    class Customer
    {
        private int Id;

        public int CustomerID
        {
            get { 
                return Id; 
            }
            set { 
                Id = value; 
            }
        }

        public String CustomerName { get; set; } = "New customer";

        public int x
        {
            get;
            init;
        }
        public int y { get;  }

        public Customer()
        {
            x = 10;
            y = 20;
        }

        public Customer(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public void Print()
        {
            Console.WriteLine($"ID: {CustomerID}, Name: {CustomerName}");
        }

    }
    class Program
    {
        static void Main(string[] args)
        {
            //Customer obj = new Customer();
            //obj.CustomerID = 1000;
            //obj.Print();
            //obj.CustomerID = 2000;
            //obj.CustomerName = "Jack";
            //obj.Print();
            //Console.ReadLine();
            Customer obj = new Customer { x = 1 };
            
        }
    }
}
