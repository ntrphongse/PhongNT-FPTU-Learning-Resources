using System;
using System.Data.SqlClient;

namespace TestConsole
{
    public delegate void SimpleDelegateHandler(int x);
    class Program
    {
        int s = 0;
        public event SimpleDelegateHandler myEvent;
        public void run(int n)
        {
            myEvent += delegate (int x) {
                s = x * x;
            };
            myEvent += delegate {
                Console.WriteLine("{0}", s);
            };
            myEvent(n);
        }
        static void Main(string[] args)
        {
            new Program().run(3);
            Console.ReadLine();
        }
    }
}
