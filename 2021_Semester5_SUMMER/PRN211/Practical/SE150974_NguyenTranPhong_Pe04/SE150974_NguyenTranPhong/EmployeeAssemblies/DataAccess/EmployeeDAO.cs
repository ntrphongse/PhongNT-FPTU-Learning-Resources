using EmployeeAssemblies.BusinessObject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmployeeAssemblies.DataAccess
{
    public class EmployeeDAO
    {

        // Singleton

        private static EmployeeDAO instance;
        private static object instanceLock = new object();

        public static EmployeeDAO Instance
        {
            get
            {
                lock (instanceLock)
                {
                    if (instance == null)
                    {
                        instance = new EmployeeDAO();
                    }
                    return instance;
                }
            }
        }

        public IEnumerable<Employee> GetEmployees()
        {
            IEnumerable<Employee> employees = null;

            try
            {
                var context = new PE04Context();
                employees = context.Employees.ToList();
            } catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }

            return employees;
        }

        public void Add(Employee employee)
        {
            try
            {
                var context = new PE04Context();
                context.Employees.Add(employee);
                context.SaveChanges();
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
        }
        public void Delete(int id)
        {
            try
            {
                var context = new PE04Context();
                Employee employee = context.Employees.SingleOrDefault(e => e.EmployeeId == id);
                if (employee == null)
                {
                    throw new Exception("Employee does not exist!");
                }
                context.Remove(employee);
                context.SaveChanges();
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
        }
        public IEnumerable<Employee> Search(string name)
        {
            IEnumerable<Employee> employees = null;
            try
            {
                var context = new PE04Context();
                employees = context.Employees.Where(e => e.FullName.ToLower().Contains(name.ToLower())).ToList();
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            return employees;
        }
    }
}
