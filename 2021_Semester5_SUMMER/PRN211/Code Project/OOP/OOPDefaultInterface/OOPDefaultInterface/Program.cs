using System;

namespace OOPDefaultInterface
{
    public interface ISample
    {
        static void Print()
        {
            Console.WriteLine("Welcome to .NET");
        }
        string GetString(string s)
        {
            return "Hello " + s;
        }
        void Display();
    }

    public class MySample : ISample
    {
        public void Display()
        {
            Console.WriteLine(" Hi ! ");
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            string str;
            MySample obj = new MySample();

            obj.Display();

            // obj.Print(); // Error
            // Default Implement Method
            ISample.Print();
            ISample sample = obj;
            str = sample.GetString("Jack");
            Console.WriteLine(str);
            Console.ReadLine();
        }
    }
}
