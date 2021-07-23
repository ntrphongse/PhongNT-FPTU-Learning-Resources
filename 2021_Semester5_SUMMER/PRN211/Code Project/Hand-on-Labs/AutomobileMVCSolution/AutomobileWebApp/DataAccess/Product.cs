using System;
using System.Collections.Generic;

#nullable disable

namespace AutomobileWebApp.DataAccess
{
    public partial class Product
    {
        public Product()
        {
            OrderDetails = new HashSet<OrderDetail>();
        }

        public int Productd { get; set; }
        public string ProductName { get; set; }
        public int CategoryId { get; set; }
        public float Price { get; set; }
        public int Quantity { get; set; }
        public string Image { get; set; }
        public bool Status { get; set; }

        public virtual Category Category { get; set; }
        public virtual ICollection<OrderDetail> OrderDetails { get; set; }
    }
}
