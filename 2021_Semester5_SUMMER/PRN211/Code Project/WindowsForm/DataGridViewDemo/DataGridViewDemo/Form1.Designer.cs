
namespace DataGridViewDemo
{
    partial class frmDataGridView
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnDataTable = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.dgvProducts = new System.Windows.Forms.DataGridView();
            ((System.ComponentModel.ISupportInitialize)(this.dgvProducts)).BeginInit();
            this.SuspendLayout();
            // 
            // btnDataTable
            // 
            this.btnDataTable.Location = new System.Drawing.Point(106, 374);
            this.btnDataTable.Name = "btnDataTable";
            this.btnDataTable.Size = new System.Drawing.Size(141, 33);
            this.btnDataTable.TabIndex = 0;
            this.btnDataTable.Text = "Binding with DataTable";
            this.btnDataTable.UseVisualStyleBackColor = true;
            this.btnDataTable.Click += new System.EventHandler(this.btnDataTable_Click);
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(354, 374);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(141, 33);
            this.button2.TabIndex = 0;
            this.button2.Text = "Binding with List";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // dgvProducts
            // 
            this.dgvProducts.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvProducts.Location = new System.Drawing.Point(12, 53);
            this.dgvProducts.Name = "dgvProducts";
            this.dgvProducts.RowTemplate.Height = 25;
            this.dgvProducts.Size = new System.Drawing.Size(667, 264);
            this.dgvProducts.TabIndex = 1;
            // 
            // frmDataGridView
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 452);
            this.Controls.Add(this.dgvProducts);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.btnDataTable);
            this.Name = "frmDataGridView";
            this.Text = "Using DataGridView Control";
            this.Load += new System.EventHandler(this.frmMain_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dgvProducts)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnDataTable;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.DataGridView dgvProducts;
    }
}

