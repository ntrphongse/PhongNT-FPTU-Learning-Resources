using System;
using System.Threading;

namespace ThreadLock
{
    public class Printer
    {
        // Lock token
        private object threadLock = new object();
        public void PrintNumbers()
        {
            // user Lock token
            //lock (threadLock)
            Monitor.Enter(threadLock); // Or Using Monitor
            try
                {
                    Console.WriteLine("{0} is executing PrintNumbers()", Thread.CurrentThread.Name);

                    // Print out numbers
                    for (int i = 1; i <= 5; i++)
                    {
                        Random r = new Random();
                        Thread.Sleep(500 * r.Next(5));
                        Console.Write($"{i,3}{(i == 5 ? "" : ",")}");
                    }
                    Console.WriteLine();
                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }
                finally
                {
                Monitor.Exit(threadLock); // or Using Monitor
            }
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("********Demo Synchronizing Threads*********\n");

            Printer p = new Printer();

            // Make 05 threads that are all pointing to the same
            // method on the same object
            Thread[] threads = new Thread[5];
            for (int i = 0; i < 5; i++)
            {
                threads[i] = new Thread(new ThreadStart(p.PrintNumbers))
                {
                    Name = $"Worker thread #{i + 1:D2}"
                };
            }

            // Now start each one
            foreach (Thread t in threads)
            {
                t.Start();
            }
            Console.ReadLine();
        }
    }
}
