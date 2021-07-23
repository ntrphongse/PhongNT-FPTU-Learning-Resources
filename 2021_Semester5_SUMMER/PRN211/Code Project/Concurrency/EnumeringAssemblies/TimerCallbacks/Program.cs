using System;
using System.Threading;

namespace TimerCallbacks
{
    class Program
    {
        static void PrintTime(object state)
        {
            Console.WriteLine("Time is: {0}. Param is {1}",
                DateTime.Now.ToLongTimeString(), state.ToString());
        }
        static void Main(string[] args)
        {
            Console.WriteLine("******Working with Timer type*******");

            // Create the delegate for the Timer type
            TimerCallback timeCB = new TimerCallback(PrintTime);

            // Establish timer settings
            var _ = new Timer(
                timeCB,                 // The TimerCallBack delegate object
                "Hello from Main",      // Any info to pass into the called method
                0,                      // Amount of time to wait before starting (in milliseconds)
                1000);                   // Interval of time between calls (in milliseconds)
            Console.ReadLine();
        }
    }
}
