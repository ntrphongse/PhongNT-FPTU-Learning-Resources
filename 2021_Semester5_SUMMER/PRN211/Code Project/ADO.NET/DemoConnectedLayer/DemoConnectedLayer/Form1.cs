using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DemoConnectedLayer
{
    public partial class frmViewProduct : Form
    {
        public frmViewProduct()
        {
            InitializeComponent();
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }
        
        private void frmViewProduct_Load(object sender, EventArgs e)
        {
            List<dynamic> products = new List<dynamic>();
            string ConnectionString = "Server=TRANPHONG\\SQLEXPRESS;uid=sa;pwd=123456;database=MyStore";
            SqlConnection connection = new SqlConnection(ConnectionString);
            SqlCommand command = new SqlCommand("SELECT ProductName, UnitPrice " +
                "FROM Products", connection);
            connection.Open();
            SqlDataReader reader = command.ExecuteReader(CommandBehavior.CloseConnection);
            if (reader.HasRows)
            {
                while (reader.Read())
                {
                    products.Add(new
                    {
                        ProductName = reader.GetString("ProductName"),
                        UnitPrice = reader.GetDecimal("UnitPrice")
                    });
                } // End While
            } // End If
            dgvData.DataSource = products;

        }
    }
}
