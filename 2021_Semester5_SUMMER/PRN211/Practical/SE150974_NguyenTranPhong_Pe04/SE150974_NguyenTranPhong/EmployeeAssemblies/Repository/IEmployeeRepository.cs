using EmployeeAssemblies.BusinessObject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmployeeAssemblies.Repository
{
    public interface IEmployeeRepository
    {
        public IEnumerable<Employee> GetEmployees();
        public void Add(Employee employee);
        public void Delete(int id);
        public IEnumerable<Employee> Search(string name);
    }
}
