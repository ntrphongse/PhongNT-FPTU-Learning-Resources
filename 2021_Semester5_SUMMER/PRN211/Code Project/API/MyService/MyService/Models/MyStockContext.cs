using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MyService.Models
{
    public class MyStockContext : DbContext
    {
        public MyStockContext(DbContextOptions<MyStockContext> options) : base(options)
        {

        }
        public virtual DbSet<Product> Products { get; set; }
    }
}
