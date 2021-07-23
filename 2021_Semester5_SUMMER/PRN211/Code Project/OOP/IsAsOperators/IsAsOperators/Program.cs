using System;

namespace IsAsOperators
{
    interface ICalculate
    {
        double Area();
    }
    
    class Rectangle : ICalculate
    {
        float length;
        float width;

        public Rectangle(float length, float width)
        {
            this.length = length;
            this.width = width;
        }

        public double Area()
        {
            return length * width;
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            Rectangle objRectangle = new Rectangle(10.2F, 20.3F);
            ICalculate calculate;
            if (objRectangle is ICalculate)
            {
                //calculate = objRectangle as ICalculate;
                //Console.WriteLine("Area: {0:F2}", calculate.Area());
                Console.WriteLine("Area: {0:F2}", objRectangle.Area());
            } else
            {
                Console.WriteLine("Interface method not implemented");
            }
        }
    }
}
