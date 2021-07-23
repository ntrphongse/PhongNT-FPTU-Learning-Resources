using System;
using System.Collections.Generic;

#nullable disable

namespace ManageCategoriesConsole.BusinessObjects
{
    public partial class Product
    {
        public int ProductId { get; set; }
        public string ProductName { get; set; }
        public decimal UnitPrice { get; set; }
        public short UnitsInStock { get; set; }
        public int CategoryId { get; set; }

        public virtual Category Category { get; set; }
    }
}
