using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ManageCategoriesApp
{
    public partial class frmManageCategories : Form
    {
        public frmManageCategories()
        {
            InitializeComponent();
        }
        ManageCategories manageCategories = new ManageCategories();
        private void LoadCategories()
        {
            var categories = manageCategories.GetCategories();
            txtCategoryID.DataBindings.Clear();
            txtCategoryName.DataBindings.Clear();

            txtCategoryID.DataBindings.Add("Text", categories, "CategoryID");
            txtCategoryName.DataBindings.Add("Text", categories, "CategoryName");

            dgvCategories.DataSource = categories;
        }
        private void frmManageCategories_Load(object sender, EventArgs e)
        {
            LoadCategories();
        }

        private void btnInsert_Click(object sender, EventArgs e)
        {
            try
            {
                var category = new Category
                {
                    CategoryName = txtCategoryName.Text
                };
                manageCategories.InsertCategory(category);
                LoadCategories();
            } catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Insert Category");
            }
        }

        private void btnUpdate_Click(object sender, EventArgs e)
        {
            try
            {
                var category = new Category
                {
                    CategoryID = int.Parse(txtCategoryID.Text),
                    CategoryName = txtCategoryName.Text
                };
                manageCategories.UpdateCategory(category);
                LoadCategories();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Update Category");
            }
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            try
            {
                var category = new Category
                {
                    CategoryID = int.Parse(txtCategoryID.Text)
                };
                manageCategories.DeleteCategory(category);
                LoadCategories();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Delete Category");
            }
        }
    }
}
