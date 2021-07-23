using System;
using System.Collections.Generic;

#nullable disable

namespace MyStockApp.Models
{
    public partial class Car
    {
        public int CarId { get; set; }
        public string CarName { get; set; }
        public string Manufacturer { get; set; }
        public decimal Price { get; set; }
        public int ReleasedYear { get; set; }
    }
}
