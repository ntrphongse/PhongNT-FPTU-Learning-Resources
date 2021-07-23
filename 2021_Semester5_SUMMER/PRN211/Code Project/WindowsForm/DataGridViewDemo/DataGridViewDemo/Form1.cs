using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DataGridViewDemo
{
    public partial class frmDataGridView : Form
    {
        public frmDataGridView()
        {
            InitializeComponent();
        }

        private void frmMain_Load(object sender, EventArgs e)
        {

        }

        private void btnDataTable_Click(object sender, EventArgs e)
        {
            DataTable products = new DataTable();
            products.Columns.Add("ProductID", typeof(int));
            products.Columns.Add("ProductName", typeof(string));
            products.Columns.Add("UnitPrice", typeof(decimal));

            products.Rows.Add(1, "Mouse", 10.5);
            products.Rows.Add(2, "Keyboard", 20.8);
            dgvProducts.DataSource = products;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            List<dynamic> products = new List<dynamic>
            {
                new {ProductID = 3, ProductName = "Speaker", UnitPrice = 14.9},
                new {ProductID = 4, ProductName = "Monitor", UnitPrice = 50.5}
            };
            dgvProducts.DataSource = products;
        }
    }
}
