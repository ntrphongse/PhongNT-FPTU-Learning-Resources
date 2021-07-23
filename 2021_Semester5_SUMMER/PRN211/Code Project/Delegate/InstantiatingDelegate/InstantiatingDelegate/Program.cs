using System;

namespace InstantiatingDelegate
{
    // #1. Declare a delegate
    public delegate int MyDelegate(int numOne, int numTwo);

    class Program
    {
        static int Add(int numOne, int numTwo) => numOne + numTwo;
        static int Subtract(int numOne, int numTwo) => numOne - numTwo;

        static void Main(string[] args)
        {
            int n1 = 25;
            int n2 = 15;
            int result;

            // #2. Set target method
            MyDelegate obj1 = new MyDelegate(Add);

            // #3. Invoke method
            result = obj1(n1, n2);
            Console.WriteLine($"{n1} + {n2} = {result}");

            // Set target method
            MyDelegate obj2 = Subtract;

            // Invoke method
            result = obj2.Invoke(n1, n2);
            Console.WriteLine($"{n1} - {n2} = {result}");
            
        }
    }
}
