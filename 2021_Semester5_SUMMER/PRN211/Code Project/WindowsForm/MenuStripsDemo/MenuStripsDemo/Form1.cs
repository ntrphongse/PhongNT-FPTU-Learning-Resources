using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MenuStripsDemo
{
    public partial class frmMain : Form
    {
        public frmMain()
        {
            InitializeComponent();
        }

        private void frmMain_Load(object sender, EventArgs e)
        {
            CreateMyMainMenu();
        }


        private void CreateMyMainMenu()
        {
            MenuStrip mainMenu = new MenuStrip();
            this.Controls.Add(mainMenu);
            this.MainMenuStrip = mainMenu;

            ToolStripMenuItem mnuFile = new ToolStripMenuItem("&File");
            ToolStripMenuItem mnuNew = new ToolStripMenuItem("&New");
            ToolStripMenuItem mnuOpen = new ToolStripMenuItem("&Open");
            ToolStripSeparator separator = new ToolStripSeparator();
            ToolStripMenuItem mnuExit = new ToolStripMenuItem("&Exit");
            ToolStripMenuItem mnuAbout = new ToolStripMenuItem("&About");
            ToolStripMenuItem mnuViewAbout = new ToolStripMenuItem("&View Abour");

            // main Menu
            mainMenu.Items.AddRange(new ToolStripItem[]
            {
                mnuFile,
                mnuAbout
            });

            // menu File
            mnuFile.DropDownItems.AddRange(new ToolStripItem[]
            {
                mnuNew,
                mnuOpen,
                separator,
                mnuExit
            });

            // menu About
            mnuAbout.DropDownItems.AddRange(new ToolStripItem[]
            {
                mnuViewAbout
            });

            // menu New
            mnuNew.ShortcutKeys = (Keys)((Keys.Control) | Keys.N);
            // menu Open
            mnuOpen.ShortcutKeys = (Keys)((Keys.Control) | Keys.O);
            // menu Exit
            mnuExit.ShortcutKeys = (Keys)((Keys.Alt) | Keys.X);
            mnuExit.Click += new EventHandler(mnuExit_Click);

            // menu ViewAbout
            mnuViewAbout.ShortcutKeys = Keys.F1;
            mnuViewAbout.Click += new EventHandler(mnuViewDetail_Click);
        }

        private void mnuViewDetail_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Welcome to Windows Forms Application with .NET","About");
        }

        private void mnuExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
