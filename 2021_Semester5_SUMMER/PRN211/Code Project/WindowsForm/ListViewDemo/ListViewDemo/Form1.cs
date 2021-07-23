using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ListViewDemo
{
    public partial class frmListView : Form
    {
        public frmListView()
        {
            InitializeComponent();
        }

        private void frmListView_Load(object sender, EventArgs e)
        {
            CreateMyListView();
        }

        private void CreateMyListView()
        {
            // Create a new ListView Control
            ListView listView1 = new ListView();
            listView1.Bounds = new Rectangle(
                new Point(10, 10), new Size(450, 200));

            listView1.View = View.LargeIcon;
            listView1.LabelEdit = true;
            listView1.AllowColumnReorder = true;
            //listView1.CheckBoxes = true;
            listView1.FullRowSelect = true;
            listView1.GridLines = true;
            listView1.Sorting = SortOrder.Ascending;

            ListViewItem item1 = new ListViewItem("item1", 0);
            item1.Checked = true;
            item1.SubItems.Add("1");
            item1.SubItems.Add("2");
            item1.SubItems.Add("3");

            ListViewItem item2 = new ListViewItem("item2", 1);
            item2.SubItems.Add("4");
            item2.SubItems.Add("5");
            item2.SubItems.Add("6");

            ListViewItem item3 = new ListViewItem("item3", 0);
            item3.Checked = true;
            item3.SubItems.Add("7");
            item3.SubItems.Add("8");
            item3.SubItems.Add("9");

            listView1.Columns.Add("Item Column", -2, HorizontalAlignment.Left);
            listView1.Columns.Add("Column 2", -2, HorizontalAlignment.Left);
            listView1.Columns.Add("Column 3", -2, HorizontalAlignment.Left);
            listView1.Columns.Add("Column 4", -2, HorizontalAlignment.Center);

            listView1.Items.AddRange(new ListViewItem[]
            {
                item1,
                item2,
                item3
            });

            ImageList imageListSmall = new ImageList();
            ImageList imageListLarge = new ImageList();

            imageListSmall.Images.Add(Bitmap.FromFile("Images/MyImage1.jpg"));
            imageListSmall.Images.Add(Bitmap.FromFile("Images/MyImage2.png"));
            imageListLarge.Images.Add(Bitmap.FromFile("Images/MyImage1.jpg"));
            imageListLarge.Images.Add(Bitmap.FromFile("Images/MyImage2.png"));

            listView1.LargeImageList = imageListLarge;
            listView1.SmallImageList = imageListSmall;

            this.Controls.Add(listView1);
        }
    }
}
