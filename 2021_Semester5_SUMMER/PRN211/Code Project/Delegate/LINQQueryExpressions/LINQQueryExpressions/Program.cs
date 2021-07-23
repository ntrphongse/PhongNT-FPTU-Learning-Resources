using System;
using System.Linq;

namespace LINQQueryExpressions
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] names =
            {
                "David",
                "Jane",
                "Peter",
                "John",
                "Mark"
            };

            var items = from word in names
                        where word.Contains("a")
                        select word;

            foreach (string s in items)
            {
                Console.WriteLine(s);
            }
        }
    }
}
