using System;

namespace Prototype
{
    public abstract class Car
    {
        protected int basePrice = 0, onRoadPrice = 0;
        public string ModelName { get; set; }

        public int BasePrice
        {
            get { return basePrice; }
            set { basePrice = value; }
        }

        public int OnRoadPrice
        {
            get { return onRoadPrice; }
            set { onRoadPrice = value; }
        }

        public static int SetAdditionalPrice()
        {
            Random radom = new Random();
            int additionalPrice = radom.Next(200_000, 500_000);
            return additionalPrice;
        }

        public abstract Car Clone();

    } // End Car

    public class Mustang : Car
    {
        public Mustang(string model) => (ModelName, BasePrice) = (model, 200_000);

        // Creating a shallow copy and returning it.
        public override Car Clone() => this.MemberwiseClone() as Mustang;
    } // End Mustang

    public class Bentley : Car
    {
        public Bentley(string model) => (ModelName, BasePrice) = (model, 300_000);

        // Creating a shallow copy and returning it.
        public override Car Clone() => this.MemberwiseClone() as Bentley;
    } // End Bentley

    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("***Prototype Pattern Demo***\n");

            // Base or Original Copy
            Car mustang = new Mustang("Mustang EcoBoost");
            Car bentley = new Bentley("Continental GT Mulliner");

            Console.WriteLine("Before Clone");
            Console.WriteLine($"Car is: {mustang.ModelName}, and its base price is Rs. {mustang.BasePrice}" );
            Console.WriteLine($"Car is: {bentley.ModelName}, and its base price is Rs. {bentley.BasePrice}");

            Car Car;
            Car = mustang.Clone();

            // Working on cloned copy
            Car.OnRoadPrice = Car.BasePrice + Car.SetAdditionalPrice();
            Console.WriteLine($"Car is: {Car.ModelName}, and its price is Rs. {Car.OnRoadPrice}");

            Car = bentley.Clone();

            Car.OnRoadPrice = Car.BasePrice + Car.SetAdditionalPrice();
            Console.WriteLine($"Car is: {Car.ModelName}, and its price is Rs. {Car.OnRoadPrice}");
        }
    }
}
