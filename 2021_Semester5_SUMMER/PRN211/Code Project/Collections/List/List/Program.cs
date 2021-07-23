using System;
using System.Collections.Generic;

namespace List
{
    public class Person
    {
        public int Age { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public override string ToString()
        {
            return $"Name: {FirstName} {LastName}, Age: {Age}";
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            List<Person> people = new List<Person>()
            {
                new Person {FirstName = "David", LastName = "Simpson", Age = 50},
                new Person {FirstName = "Marge", LastName = "Simpson", Age = 45},
                new Person {FirstName = "Lisa", LastName = "Simpson", Age = 19},
                new Person {FirstName = "Jack", LastName = "Simpson", Age = 16}
            };

            Console.WriteLine("Items in list: {0}", people.Count);

            foreach (Person p in people)
            {
                Console.WriteLine(p);
            }
        }
    }
}
