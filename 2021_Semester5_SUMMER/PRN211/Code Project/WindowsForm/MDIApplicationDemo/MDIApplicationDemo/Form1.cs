using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MDIApplicationDemo
{
    public partial class frmMain : Form
    {
        public frmMain()
        {
            InitializeComponent();
        }
        int counter = 1;

        private void Form1_Load(object sender, EventArgs e)
        {
            CreateMyMainMenu();
        }

        private void CreateMyMainMenu()
        {
            MenuStrip mainMenu = new MenuStrip();
            this.Controls.Add(mainMenu);
            this.MainMenuStrip = mainMenu;

            ToolStripMenuItem mnuFile = new ToolStripMenuItem("&File");
            ToolStripMenuItem mnuOpen = new ToolStripMenuItem("&Open");
            ToolStripSeparator separator = new ToolStripSeparator();
            ToolStripMenuItem mnuExit = new ToolStripMenuItem("&Exit");
            ToolStripMenuItem mnuWindow = new ToolStripMenuItem("&Window");

            // main Menu
            mainMenu.Items.AddRange(new ToolStripItem[]
            {
                mnuFile,
                mnuWindow
            });
            mainMenu.MdiWindowListItem = mnuWindow;

            // menu File
            mnuFile.DropDownItems.AddRange(new ToolStripItem[]
            {
                mnuOpen,
                separator,
                mnuExit
            });

            // menu Open
            mnuOpen.ShortcutKeys = (Keys)((Keys.Control) | Keys.O);
            mnuOpen.Click += new EventHandler(mnuOpen_Click);
            // menu Exit
            mnuExit.ShortcutKeys = (Keys)((Keys.Alt) | Keys.X);
            mnuExit.Click += new EventHandler(mnuExit_Click);

        }

        private void mnuOpen_Click(object sender, EventArgs e)
        {
            frmChildForm childForm = new frmChildForm();
            childForm.Text = $"ChildForm {counter++:D2}";
            childForm.MdiParent = this;
            childForm.Show();
        }
        private void mnuExit_Click (object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
