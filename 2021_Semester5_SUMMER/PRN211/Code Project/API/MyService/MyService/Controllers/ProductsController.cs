using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using MyService.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MyService.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ProductsController : ControllerBase
    {
        private readonly MyStockContext context;

        public ProductsController(MyStockContext context) => this.context = context;

        // GET: api/Products
        [HttpGet] // Get All Products
        public ActionResult<IEnumerable<Product>> GetProducts() => context.Products.ToList();

        // POST: api/Products
        [HttpPost]
        public IActionResult PostProduct(Product product)
        {
            context.Products.Add(product);
            context.SaveChanges();
            return NoContent();
        }

        // DELETE: api/Products/5
        [HttpDelete("{id}")]
        public IActionResult DeleteProduct(int id)
        {
            var product = context.Products.Find(id);
            if (product == null)
            {
                return NotFound();
            }
            context.Products.Remove(product);
            context.SaveChanges();
            return NoContent();
        }
        
    }
}
