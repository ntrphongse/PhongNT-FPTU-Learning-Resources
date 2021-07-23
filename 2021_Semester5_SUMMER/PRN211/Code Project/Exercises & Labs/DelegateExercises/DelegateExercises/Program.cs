using System;

namespace DelegateExercises
{
    public delegate int NhapDele();
    public delegate int IntDele(int num);
    public delegate float FloatDele(int num);
    class Program
    {
        static int NhapSo()
        {
            int n;
            do
            {
                Console.Write("Enter n (0 < n < 100): ");
                n = Convert.ToInt32(Console.ReadLine());
            } while (n >= 100 || n <= 0);

            return n;
        }

        static int BinhPhuong(int a) => a * a;

        static float CanBac2(int a) => (float) Math.Sqrt(a);
        static void Main(string[] args)
        {
            //--------------------------------------------------
            //NhapDele nhapDele = NhapSo;
            //int n = nhapDele.Invoke();

            //IntDele intDele = BinhPhuong;
            //Console.WriteLine(intDele.Invoke(n));

            //FloatDele floatDele = CanBac2;
            //Console.WriteLine(floatDele.Invoke(n));

            //--------------------------------------------------
            // Anonymous Method
            //NhapDele nhapDele = delegate ()
            //{
            //    int n;
            //    do
            //    {
            //        Console.Write("Enter n (0 < n < 100): ");
            //        n = Convert.ToInt32(Console.ReadLine());
            //    } while (n >= 100 || n <= 0);

            //    return n;
            //};

            //IntDele intDele = delegate (int n)
            //{
            //    return n * n;
            //};

            //FloatDele floatDele = delegate (int n)
            //{
            //    return (float) Math.Sqrt(n);
            //};

            //int n = nhapDele();
            //Console.WriteLine(intDele(n));
            //Console.WriteLine(floatDele(n));

            //--------------------------------------------------
            // Lambda Expression
            //NhapDele nhapDele = () =>
            //{
            //    int n;
            //    do
            //    {
            //        Console.Write("Enter n (0 < n < 100): ");
            //        n = Convert.ToInt32(Console.ReadLine());
            //    } while (n >= 100 || n <= 0);

            //    return n;
            //};

            //IntDele intDele = (int n) =>
            //{
            //    return n * n;
            //};

            //FloatDele floatDele = (int n) =>
            //{
            //    return (float)Math.Sqrt(n);
            //};

            //int n = nhapDele();
            //Console.WriteLine(intDele(n));
            //Console.WriteLine(floatDele(n));

            //--------------------------------------------------
            // Function delegate & Lambda Expression
            Func<int> nhapDele = (() =>
             {
                 int n;
                 do
                 {
                     Console.Write("Enter n (0 < n < 100): ");
                     n = Convert.ToInt32(Console.ReadLine());
                 } while (n >= 100 || n <= 0);

                 return n;
             });

            Func<int, int> intDele = ((n) => n*n);

            Func<int, float> floatDele = ((n) => (float)Math.Sqrt(n));

            int n = nhapDele();
            Console.WriteLine(intDele(n));
            Console.WriteLine(floatDele(n));
        }
    }
}
