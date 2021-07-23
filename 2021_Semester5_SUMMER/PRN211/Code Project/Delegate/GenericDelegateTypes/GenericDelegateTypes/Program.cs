using System;

namespace GenericDelegateTypes
{
    class Program
    {
        static int Sum(int x, int y) => x + y;
        static void Print(string msg) => Console.WriteLine(msg.ToUpper());
        static void Main(string[] args)
        {
            int a = 15, b = 25, s;

            string strResult;

            // Func delegate takes two input parameters of int type
            // and returns a value of int type
            Func<int, int, int> sumFunc = Sum;

            // Invoke Sum method by Func delegate
            s = sumFunc(a, b);
            strResult = $"{a} + {b} = {s}";
            Console.WriteLine("***Invoke Print method by Action delegate***");
            Action<string> action = Print;
            action(strResult);
        }
    }
}
