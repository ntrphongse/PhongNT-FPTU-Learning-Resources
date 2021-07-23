using System;
using System.IO;

namespace DirectoryInfoClassDemo
{
    class Program
    {
        static void Main(string[] args)
        {
            DirectoryInfo di = new DirectoryInfo(@"E:\Project\HOV");
            Console.WriteLine("Search pattern [HOV]* returns:");
            foreach (var fi in di.GetDirectories("[HOV]*"))
            {
                Console.WriteLine(fi.Name);
            }
            Console.WriteLine();
            Console.WriteLine("Search pattern TopDirectoryOnly returns: ");
            foreach (var fi in di.GetFiles("*.*", SearchOption.TopDirectoryOnly))
            {
                Console.WriteLine(fi.Name);
            }
            Console.ReadLine();
        }
    }
}
