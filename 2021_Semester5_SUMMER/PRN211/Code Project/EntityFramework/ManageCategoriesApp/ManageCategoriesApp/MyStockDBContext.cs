using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ManageCategoriesConsole
{
    public class Category
    {
        public Category()
        {

        }
        [Key, DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int CategoryID { get; set; }
        public string CategoryName { get; set; }
    } // End Category
    public class MyStockDBContext : DbContext
    {
        // Map to tables in the database
        public DbSet<Category> Categories { get; set; }
        protected override void OnConfiguring (DbContextOptionsBuilder optionsBuilder)
        {
            var builder = new ConfigurationBuilder()
                            .SetBasePath(Directory.GetCurrentDirectory())
                            .AddJsonFile("appsettings.json", optional: true, reloadOnChange: true);
            IConfigurationRoot configuration = builder.Build();
            optionsBuilder.UseSqlServer(configuration.GetConnectionString("MyStockDB"));
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            // Fluent API instead of attributes
            // limit length
            modelBuilder.Entity<Category>()
                .Property(category => category.CategoryName)
                .IsRequired() // Not Null
                .HasMaxLength(40);

            // Insert data
            modelBuilder.Entity<Category>().HasData( new[] {
                new Category
                {
                    CategoryID = 1,
                    CategoryName = "Beverages"
                },
                new Category
                {
                    CategoryID = 2,
                    CategoryName = "Condiments"
                },
                new Category
                {
                    CategoryID = 3,
                    CategoryName = "Confestions"
                }
            });
        }
    }
}
