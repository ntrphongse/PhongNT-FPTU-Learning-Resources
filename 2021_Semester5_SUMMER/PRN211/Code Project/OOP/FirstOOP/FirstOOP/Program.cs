using System;

namespace FirstOOP
{
    public class Car
    {
        public string Make;
        public string Model;

        public void Starting()
        {
            Console.WriteLine($"{Model} is starting.");
        }
        public void Accelerating()
        {
            Console.WriteLine($"{Model} is accelerating.");
        }
        public void Braking()
        {
            Console.WriteLine($"{Model} is braking.");
        }
        public override string ToString()
        {
            return $"Make={Make}, Model={Model}";
        }

    }
    class Program
    {
        static void Main(string[] args)
        {
            Car wwPolo = new Car();
            wwPolo.Make = "2050";
            wwPolo.Model = "Volkswagen Polo";
            wwPolo.Accelerating();
            wwPolo.Braking();
            wwPolo.Starting();
            Console.WriteLine(wwPolo.ToString());
            Console.ReadLine();
        }
    }
}
