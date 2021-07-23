using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DemoCommonControls
{
    public partial class frmEmployeeDetails : Form
    {
        public frmEmployeeDetails()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            string EmployeeID = txtEmployeeID.Text;
            string EmployeeName = txtEmployeeName.Text;
            string Phone = mtxtPhone.Text;
            string Gender = rdFemale.Checked ? "Female" : "Male";
            string Degree = cboDegree.Text;

            StringBuilder builder = new StringBuilder();
            builder.Append($"EmployeeID: {EmployeeID}\n");
            builder.Append($"EmployeeName: {EmployeeName}\n");
            builder.Append($"Phone: {Phone}\n");
            builder.Append($"Gender: {Gender}\n");
            builder.Append($"Degree: {Degree}\n");

            MessageBox.Show(builder.ToString(), "Employee Details");

        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
