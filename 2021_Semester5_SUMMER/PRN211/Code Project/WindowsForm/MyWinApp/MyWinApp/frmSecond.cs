using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MyWinApp
{
    record Product(int id, string name);

    public partial class frmSecond : Form
    {
        public frmSecond()
        {
            InitializeComponent();
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            this.Close();
            //Application.Exit();
        }

        private void frmSecond_Load(object sender, EventArgs e)
        {
            this.FormClosing += FrmSecond_FormClosing;

            // Create ProductList
            List<Product> products = new List<Product>
            {
                new Product(1, "Caphe"),
                new Product(2, "Coca"),
                new Product(3, "Pepsi")
            };
            lstProductList.DataSource = products;
            lstProductList.DisplayMember = "name";
            //lstProductList.ValueMember = "id";
        }
        private void FrmSecond_FormClosing(object sender, FormClosingEventArgs e)
        {
            DialogResult result = MessageBox.Show
                ("Do you want to close this form?", 
                "Close Form", 
                MessageBoxButtons.YesNo);
            
            if (result == DialogResult.No)
            {
                e.Cancel = true;
            }
        }

        private void lstProductList_SelectedIndexChanged(object sender, EventArgs e)
        {
            var p = (Product)lstProductList.SelectedItem;
            int id = p.id;
            this.Text = id.ToString();
            //this.Text = lstProductList.SelectedValue.ToString();
        }
    }
}
