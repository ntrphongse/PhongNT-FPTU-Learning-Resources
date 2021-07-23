using System;
using System.Diagnostics;
using System.Linq;

namespace EnumeratingRunningProcesses
{
    class Program
    {
        static void Main(string[] args)
        {
            int no = 1;
            string info;

            // Get all the processes on the local machine, ordered by PId.
            var runningProcs = from proc in Process.GetProcesses(".")
                               orderby proc.Id
                               select proc;

            // Print out Pid and Name of each process.
            foreach (var p in runningProcs)
            {
                info = $"#{no++}. PID: {p.Id}\tName: {p.ProcessName}";
                Console.WriteLine(info);
            }
            Console.ReadLine();
        }
    }
}
