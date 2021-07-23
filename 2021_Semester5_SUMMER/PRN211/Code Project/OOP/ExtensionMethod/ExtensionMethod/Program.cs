using System;

namespace ExtensionMethod
{
    static class Utils
    {
        public static int Add (int a, int b)
        {
            return a + b;
        }

        public static int Sub (this int a, int b)
        {
            return a - b;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            int x = 3, y = 2;
            int r = Utils.Add(x, y);
            Console.WriteLine("{0} + {1} = {2}", x, y, r);

            r = x.Sub(y);
            Console.WriteLine($"{x} - {y} = {r}");
            Console.ReadLine();
        }
    }
}
