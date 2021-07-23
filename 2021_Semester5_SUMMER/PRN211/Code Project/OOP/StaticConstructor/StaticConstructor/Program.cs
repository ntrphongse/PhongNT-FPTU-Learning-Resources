using System;

namespace StaticConstructor
{
    class MyClass
    {
        public static int x = 1;
        static MyClass()
        {
            x = 2;
            Console.WriteLine("Static Constructor: x = {0}", x);
        }
        public MyClass()
        {
            x++;
            Console.WriteLine("Object Constructor: x = {0}", x);
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            MyClass m1 = new MyClass();
            MyClass.x = 4;
            MyClass m2 = new MyClass();

        }
    }
}
