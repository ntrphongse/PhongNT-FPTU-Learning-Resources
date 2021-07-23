using System;

namespace LocalFunction
{
    class Program
    {
        static void Main(string[] args)
        {
            void AreaOfCircle(double a)
            {
                double ar;
                Console.WriteLine("Radius of the circle: " + a);
                ar = 3.14 * a * a;
                Console.WriteLine("Area of circle: " + ar);
                Circumference(a);
                static void Circumference(double radii)
                {
                    double ar;
                    ar = 2 * 3.14 * radii;
                    Console.WriteLine($"Circumference of the circle is: {ar:N2}");
                }
            }
            AreaOfCircle(10);
            Console.ReadLine();
        }
    }
}
