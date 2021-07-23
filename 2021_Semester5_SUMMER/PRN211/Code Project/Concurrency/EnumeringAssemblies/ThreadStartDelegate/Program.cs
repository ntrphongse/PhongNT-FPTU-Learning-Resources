using System;
using System.Threading;

namespace ThreadStartDelegate
{
    // Step 01
    public class Printer
    {
        public void PrintNumbers()
        {
            // Display Thread info.
            Console.WriteLine($"{Thread.CurrentThread.Name} is executing PrintNumbers()");

            // Print out Numbers
            for (int i = 1; i <= 5; i++)
            {
                Console.WriteLine($"Second thread: {i}");
                Thread.Sleep(2000);
            }
            Console.WriteLine();
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Thread primaryThread = Thread.CurrentThread;
            primaryThread.Name = "Primary";
            Console.WriteLine($"{Thread.CurrentThread.Name} is executing Main()");

            Printer p = new Printer();
            ThreadStart threadStart = new ThreadStart(p.PrintNumbers); // Step 02
            Thread backgroundThread = new Thread(threadStart); // Step 03
            backgroundThread.Name = "Secondary"; // Step 04
            backgroundThread.Start(); // Step 05

            // Do some aditional work
            for (int i = 1; i <= 5; i++)
            {
                Console.WriteLine($"Main thread: {i}");
                Thread.Sleep(1000);
            }
            Console.WriteLine("The main thread has finished.");
            Console.ReadLine();

        }
    }
}
