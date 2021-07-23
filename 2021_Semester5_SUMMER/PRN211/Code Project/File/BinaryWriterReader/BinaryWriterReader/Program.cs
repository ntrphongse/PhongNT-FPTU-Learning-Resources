using System;
using System.IO;

namespace BinaryWriterReader
{
    class Program
    {
        static void Main(string[] args)
        {
            string fileName = "MyFile.bin";
            Console.WriteLine("*******Demo Binary Writer and Binary Reader********\n");

            // Open a Binary writer for a file
            FileInfo f = new FileInfo(fileName);
            using BinaryWriter bw = new BinaryWriter(f.OpenWrite());

            // Print out the type of Basestream
            Console.WriteLine("Base stream is: {0}", bw.BaseStream);

            // Create some data to save in the file
            double aDouble = 9183.68;
            int anInt = 98321;
            string aString = "A, B, C";

            bw.Write(aDouble);
            bw.Write(anInt);
            bw.Write(aString);

            bw.Close();

            Console.WriteLine("File was created.");
            Console.WriteLine("Read the binary data from the stream");

            using BinaryReader br = new BinaryReader(f.OpenRead());
            Console.WriteLine(br.ReadDouble());
            Console.WriteLine(br.ReadInt32());
            Console.WriteLine(br.ReadString());
            Console.ReadLine();
        }
    }
}
