using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PictureBoxDemo
{
    public partial class frmMain : Form
    {
        public frmMain()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            DisplayImage();
        }

        private void DisplayImage()
        {
            PictureBox imageControl = new PictureBox();
            imageControl.Width = 398;
            imageControl.Height = 223;
            imageControl.Location = new Point(100, 70);
            Bitmap image = new Bitmap("Images/Rewind2020.png");
            imageControl.SizeMode = PictureBoxSizeMode.StretchImage;
            imageControl.Image = (Image)image;
            Controls.Add(imageControl);
        }
    }
}
