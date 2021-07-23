using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using MyWebApp.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text.Json;
using System.Threading.Tasks;

namespace MyWebApp.Controllers
{
    public class ProductManagerController : Controller
    {

        private readonly HttpClient client = null;
        private string ProductApiUrl = "";

        public ProductManagerController()
        {
            client = new HttpClient();
            var contentType = new MediaTypeWithQualityHeaderValue("application/json");
            client.DefaultRequestHeaders.Accept.Add(contentType);
            ProductApiUrl = "http://localhost:5000/api/products";
        }

        // Show all Product
        public async Task<IActionResult> Index()
        {
            HttpResponseMessage response = await client.GetAsync(ProductApiUrl);
            string stringData = await response.Content.ReadAsStringAsync();
            var options = new JsonSerializerOptions
            {
                PropertyNameCaseInsensitive = true
            };
            List<Product> listProducts = JsonSerializer.Deserialize<List<Product>>(stringData, options);
            return View(listProducts);
        }

        // GET: ProductManagerController/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: ProductManagerController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create(Product product)
        {
            if (ModelState.IsValid)
            {
                string stringData = JsonSerializer.Serialize(product);
                var contentData = new StringContent(stringData, System.Text.Encoding.UTF8, "application/json");
                HttpResponseMessage response = await client.PostAsync(ProductApiUrl, contentData);
                if (response.IsSuccessStatusCode)
                {
                    ViewBag.Message = "Product inserted successfully!";
                } else
                {
                    ViewBag.Message = "Error while calling web API";
                }
            }
            return View(product);
        }

        // POST: ProductManagerController/Delete/5
        public async Task<IActionResult> Delete(int? id)
        {
            HttpResponseMessage response = await client.DeleteAsync($"{ProductApiUrl}/{id}");
            if (response.IsSuccessStatusCode)
            {
                TempData["Message"] = "Product Deleted successfully!";
            } else
            {
                TempData["Message"] = "Error while calling web API";
            }
            return RedirectToAction(nameof(Index));
        }
    }
}
