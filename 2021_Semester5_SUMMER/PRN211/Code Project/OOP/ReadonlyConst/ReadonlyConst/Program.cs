using System;

namespace ReadonlyConst
{
    public class SamplePoint
    {
        public int x;

        // Readonly
        public readonly int y = 25;
        public readonly int z;

        // Const
        public const int t = 100;

        public SamplePoint()
        {
            z = 24;
        }

        public SamplePoint(int x, int y, int z)
        {
            this.x = x;
            this.y = y;
            this.z = z;
            // this.t = t; // Error
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            SamplePoint p1 = new SamplePoint(11, 21, 32);
            Console.WriteLine($"t = {SamplePoint.t}");
            Console.WriteLine($"p1: x = {p1.x}, y = {p1.y}, z = {p1.z}");

            SamplePoint p2 = new SamplePoint();
            Console.WriteLine($"p2: x = {p2.x}, y = {p2.y}, z = {p2.z}");
            Console.ReadLine();
        }
    }
}
