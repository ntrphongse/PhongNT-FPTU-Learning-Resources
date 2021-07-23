using System;
using System.Collections;

namespace LabEventDelegate
{
    class Product
    {
        public int ProductID { get; set; }
        public string ProductName { get; set; }
        public int Quantity { get; set; }
        public float UnitPrice { get; set; }

        public Product()
        {
        }

        public Product(int productID, string productName, int quantity, float unitPrice)
        {
            ProductID = productID;
            ProductName = productName;
            Quantity = quantity;
            UnitPrice = unitPrice;
        }

        private float _subtotal;

        public float subtotal
        {
            get
            {
                return Quantity * UnitPrice;
            }
        }

    }
    public delegate void MyDelegate(string s);

    class ManageProduct
    {
        public event MyDelegate RemoveProduct;

        private ArrayList productList = new ArrayList();

        public ArrayList ProductList
        {
            get
            {
                return productList;
            }
        }
        public void AddNew(Product p)
        {
            productList.Add(p);
        }
        public Product Find(int productID)
        {
            foreach (Product product in productList)
            {
                if (product.ProductID.Equals(productID)) {
                    return product;
                }
            }
            return null;
        }
        public void Remove(int ProductID)
        {
            Product product = Find(ProductID);
            if (product != null)
            {
                productList.Remove(product);
                //RemoveProduct += (string s) => {
                //    Console.WriteLine("Removed the Product with ProductID: " + ProductID + " successfully!!");
                //};
                if (RemoveProduct != null)
                {
                    RemoveProduct("Removed the Product with ProductID: " + ProductID + " successfully!!");
                }
                
            }
        }
    }
}
