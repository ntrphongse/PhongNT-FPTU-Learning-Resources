using EmployeeAssemblies.BusinessObject;
using EmployeeAssemblies.Repository;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EmployeeWinForm
{
    public partial class frmEmployee : Form
    {
        BindingSource source;
        IEmployeeRepository employeeRepository;

        IEnumerable<Employee> employees;
        public frmEmployee()
        {
            employeeRepository = new EmployeeRepository();

            InitializeComponent();
        }

        private void LoadData()
        {
            try
            {
                if (employees != null)
                {
                    txtEmployeeID.DataBindings.Clear();
                    txtFullName.DataBindings.Clear();
                    numAge.DataBindings.Clear();
                    txtAddress.DataBindings.Clear();

                    txtEmployeeID.DataBindings.Add("Text", source, "EmployeeId");
                    txtFullName.DataBindings.Add("Text", source, "FullName");
                    numAge.DataBindings.Add("Text", source, "Age");
                    txtAddress.DataBindings.Add("Text", source, "Address");

                    dgvEmployee.DataSource = null;
                    dgvEmployee.DataSource = source;
                }
            } catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            
        }

        private Employee GetEmployeeInfo()
        {
            Employee employee = null;
            try
            {
                employee = new Employee()
                {
                    FullName = txtFullName.Text,
                    Age = Convert.ToInt32(numAge.Value),
                    Address = txtAddress.Text
                };

            } catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }

            return employee;
        }

        private void frmEmployee_Load(object sender, EventArgs e)
        {
            txtSearch.Enabled = false;
            btnSearch.Enabled = false;
            btnAdd.Enabled = false;
            btnDelete.Enabled = false;
        }
        private void btnLoad_Click(object sender, EventArgs e)
        {
            try
            {
                employees = employeeRepository.GetEmployees() ;
                source = new BindingSource();
                source.DataSource = employees;
                LoadData();
                txtSearch.Enabled = true;
                btnSearch.Enabled = true;
                btnAdd.Enabled = true;
                btnDelete.Enabled = true;
            } catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Load Employee", MessageBoxButtons.OK, MessageBoxIcon.Error); ;
            }
            
        }

        private void btnSearch_Click(object sender, EventArgs e)
        {
            IEnumerable<Employee> searchResult = null;
            try
            {
                string search = txtSearch.Text;
                searchResult = employeeRepository.Search(search);

                if (searchResult != null && searchResult.Any())
                {
                    employees = searchResult;
                    source = new BindingSource();
                    source.DataSource = searchResult;
                    LoadData();
                } else
                {
                    source = new BindingSource();
                    source.DataSource = new List<Employee>();
                    MessageBox.Show("No result found!!", "Search Employee", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Search Employee", MessageBoxButtons.OK, MessageBoxIcon.Error); ;
            }
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            try
            {
                if (string.IsNullOrEmpty(txtFullName.Text) || string.IsNullOrEmpty(txtAddress.Text))
                {
                    throw new Exception("All the fields cannot be empty! Please check again!");
                }
                Employee employee = GetEmployeeInfo();
                if (employee != null)
                {
                    employeeRepository.Add(employee);
                    MessageBox.Show("Add successfully!!", "Add Employee", MessageBoxButtons.OK, MessageBoxIcon.Information);

                    employees = employeeRepository.GetEmployees();
                    source = new BindingSource();
                    source.DataSource = employees;
                    LoadData();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Add Employee", MessageBoxButtons.OK, MessageBoxIcon.Error); ;
            }

        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            try
            {
                int id = int.Parse(txtEmployeeID.Text);
                employeeRepository.Delete(id);
                MessageBox.Show("Delete successfully!!", "Delete Employee", MessageBoxButtons.OK, MessageBoxIcon.Information);

                employees = employeeRepository.GetEmployees();
                source = new BindingSource();
                source.DataSource = employees;
                LoadData();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Delete Employee", MessageBoxButtons.OK, MessageBoxIcon.Error); ;
            }
        }

       
    }
}
