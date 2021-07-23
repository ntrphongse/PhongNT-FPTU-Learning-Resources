using System;

namespace Lambdas
{
    static class MyClass
    {
        public static bool Check(this int n, Func<int, bool> func)
        {
            bool r = func(n);
            return r;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            int a = 2, b = 3;
            bool r;

            // Kiem tra a la so chan ?
            r = a.Check(n => n % 2 == 0);
            Console.WriteLine(r);

            // Kiem tra b la so le ?
            r = b.Check(n => n % 2 == 1);
            Console.WriteLine(r);
        }
    }
}
