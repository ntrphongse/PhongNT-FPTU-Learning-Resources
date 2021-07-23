using System;

namespace FirstEvents
{
    public delegate void PrintDetails(string msg);
    class Program
    {
        // Declaring an event
        event PrintDetails Print;

        void Show(String msg) => Console.WriteLine(msg.ToUpper());
        static void Main(string[] args)
        {
            Program p = new Program();

            // Register with an event
            p.Print += new PrintDetails(p.Show);

            // Raise "Print" event
            p.Print("Hello World");
        }
    }
}
