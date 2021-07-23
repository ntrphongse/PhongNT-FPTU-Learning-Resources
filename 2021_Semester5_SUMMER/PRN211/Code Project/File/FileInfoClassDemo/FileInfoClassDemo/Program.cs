using System;
using System.IO;

namespace FileInfoClassDemo
{
    class Program
    {
        static void Main(string[] args)
        {
            string FileName = @"MyFile.txt";
            Console.WriteLine("************Demo FileInfo Class*************\n");

            FileInfo testFile = new FileInfo(FileName);
            Console.WriteLine($"Name: {testFile.Name}");
            Console.WriteLine($"Creation Time: {testFile.CreationTime}");
            Console.WriteLine($"Last Write Time: {testFile.LastWriteTime}");
            Console.WriteLine($"Directory Name: {testFile.FullName}");

            Console.ReadLine();
        }
    }
}
