using EmployeeAssemblies.BusinessObject;
using EmployeeAssemblies.DataAccess;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmployeeAssemblies.Repository
{
    public class EmployeeRepository : IEmployeeRepository
    {
        public void Add(Employee employee) => EmployeeDAO.Instance.Add(employee);

        public void Delete(int id) => EmployeeDAO.Instance.Delete(id);

        public IEnumerable<Employee> GetEmployees() => EmployeeDAO.Instance.GetEmployees();

        public IEnumerable<Employee> Search(string name) => EmployeeDAO.Instance.Search(name);
    }
}
