using System;
using System.Collections.Generic;

namespace Dictionary
{
    class Program
    {
        static void Main(string[] args)
        {
            IDictionary<int, string> numberNames = new Dictionary<int, string>();

            numberNames.Add(1, "One");
            numberNames.Add(2, "Two");
            numberNames.Add(3, "Three");

            foreach (KeyValuePair<int, string> kvp in numberNames)
            {
                Console.WriteLine($"Key: {kvp.Key}, Value: {kvp.Value}");
            }

            dynamic myDictionary = new Dictionary<string, string>()
            {
                {"UK", "London, Manchester, Birmingham" },
                {"USA", "Chicago, New York, Washington" },
                {"India", "Mumbai, New Delhi, Pune" }
            };

            foreach (KeyValuePair<string, string> kvp in myDictionary)
            {
                Console.WriteLine($"Key: {kvp.Key}, Value: {kvp.Value}");
            }
        }
    }
}
