using System;
using System.Linq;

namespace LambdaStandardQuery
{
    class Program
    {
        static void Main(string[] args)
        {

            // Declare and initialize an array of strings
            string[] names =
            {
                "David",
                "Jane",
                "Peter",
                "John",
                "Mark"
            };
            foreach (string item in names.OrderBy(s => s))
            {
                Console.WriteLine(item);
            }
        }
    }
}
