using MyWinApp.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MyWinApp
{
    public partial class frmViewProducts : Form
    {
        private readonly HttpClient client = null;
        private string ProductApiUrl = "http://localhost:5000/api/products";
        public frmViewProducts()
        {
            InitializeComponent();

            client = new HttpClient();
            var contentType = new MediaTypeWithQualityHeaderValue("application/json");
            client.DefaultRequestHeaders.Accept.Add(contentType);
        }

        public async void LoadProducts()
        {
            HttpResponseMessage response = await client.GetAsync(ProductApiUrl);
            string stringData = await response.Content.ReadAsStringAsync();
            var options = new JsonSerializerOptions
            {
                PropertyNameCaseInsensitive = true
            };
            List<Product> listProducts = JsonSerializer.Deserialize<List<Product>>(stringData, options);

            txtProductID.DataBindings.Clear();
            txtProductName.DataBindings.Clear();
            txtUnitPrice.DataBindings.Clear();

            txtProductID.DataBindings.Add("Text", listProducts, "ProductID");
            txtProductName.DataBindings.Add("Text", listProducts, "ProductName");
            txtUnitPrice.DataBindings.Add("Text", listProducts, "UnitPrice");

            //foreach (DataGridViewColumn col in dgvProductList.Columns)
            //{
            //    col.SortMode = DataGridViewColumnSortMode.Automatic;
            //}

            dgvProductList.DataSource = listProducts;
        }

        private void btnLoad_Click(object sender, EventArgs e)
        {
            LoadProducts();
        }

        private void frmViewProducts_Load(object sender, EventArgs e)
        {
            //foreach (DataGridViewColumn col in dgvProductList.Columns)
            //{
            //    col.SortMode = DataGridViewColumnSortMode.NotSortable;
            //}
        }
    }
}
