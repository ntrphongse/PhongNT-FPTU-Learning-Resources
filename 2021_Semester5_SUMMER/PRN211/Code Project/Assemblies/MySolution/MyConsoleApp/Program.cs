using System;
using MyLibrary;

namespace MyConsoleApp
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = 50, b = 25;
            int result;
            Console.WriteLine("*******Demo Consuming Assemblies*********");

            // Invoke Add method
            result = a.Add(b);
            Console.WriteLine($"{a} + {b} = {result}");

            // Invoke Sub method
            result = a.Sub(b);
            Console.WriteLine($"{a} - {b} = {result}");

            Console.ReadLine();
        }
    }
}
