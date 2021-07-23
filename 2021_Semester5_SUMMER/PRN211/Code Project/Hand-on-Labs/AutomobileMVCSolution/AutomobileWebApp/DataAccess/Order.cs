using System;
using System.Collections.Generic;

#nullable disable

namespace AutomobileWebApp.DataAccess
{
    public partial class Order
    {
        public Order()
        {
            OrderDetails = new HashSet<OrderDetail>();
        }

        public int OrderId { get; set; }
        public int CustomerId { get; set; }
        public string Address { get; set; }
        public float TotalPrice { get; set; }
        public int NumberOfItem { get; set; }
        public DateTime CreatedDate { get; set; }

        public virtual User Customer { get; set; }
        public virtual ICollection<OrderDetail> OrderDetails { get; set; }
    }
}
