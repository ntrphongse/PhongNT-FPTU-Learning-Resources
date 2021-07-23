using System;
using System.Collections.Generic;

namespace SortedSet
{
    public class Person : IComparable
    {
        public int Age { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }

        public int CompareTo(object obj)
        {
            return FirstName.CompareTo(obj);
        }

        public override string ToString()
        {
            return $"Name: {FirstName} {LastName}, Age: {Age}";
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            SortedSet<Person> mySet = new SortedSet<Person>() {
                new Person() {FirstName = "Phong", LastName = "Tran", Age=18},
                new Person() {FirstName = "ABC", LastName="BCD", Age=20}
            };

            foreach (var item in mySet)
            {
                Console.WriteLine(item);
            }
        }
    }
}
