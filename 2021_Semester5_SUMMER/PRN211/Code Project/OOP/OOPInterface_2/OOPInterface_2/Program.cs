using System;

namespace OOPInterface_2
{
    public interface ICar
    {
        void Drive();
    }
    public interface IUnderwaterCar
    {
        void Dive();
    }

    public interface IJamesBondCar : ICar, IUnderwaterCar
    {
        void TurboBoost();
    }

    public class MyClass : IJamesBondCar
    {
        public void Dive()
        {
            //
        }

        public void Drive()
        {
            //
        }

        public void TurboBoost()
        {
            //
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
        }
    }
}
