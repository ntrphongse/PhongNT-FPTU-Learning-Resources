using System;
using System.Reflection;

namespace EnumeringAssemblies
{
    class Program
    {
        static void Main(string[] args)
        {
            // Get access to the AppDomain for the current thread
            AppDomain defaultAD = AppDomain.CurrentDomain;

            // Get all loaded assemblies in the default AppDomain
            Assembly[] loadedAssemblies = defaultAD.GetAssemblies();
            Console.WriteLine("The assemblies loaded in {0}", defaultAD.FriendlyName);
            foreach (Assembly a in loadedAssemblies)
            {
                Console.WriteLine($"--Name, Version: {a.GetName().Name}:{a.GetName().Version}");

            }
            Console.ReadLine();
        }
    }
}
