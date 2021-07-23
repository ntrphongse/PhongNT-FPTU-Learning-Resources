using AutomobileLibrary.BusinessObject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AutomobileLibrary.DataAccess
{
    public class CarDBContext
    {
        // Initialize car list
        private static List<Car> CarList = new List<Car>()
        {
            new Car
            {
                CarID = 1,
                CarName = "CRV",
                Manufacturer = "Honda",
                Price = 30000,
                ReleaseYear = 2021
            },
            new Car
            {
                CarID = 2,
                CarName = "Ford Focus",
                Manufacturer = "Ford",
                Price = 15000,
                ReleaseYear = 2020
            }
        };

        // Using Singleton Pattern
        private static CarDBContext instance = null;
        private static readonly object instanceLook = new object();

        private CarDBContext()
        {

        }
        
        public static CarDBContext Instance
        {
            get
            {
                lock (instanceLook)
                {
                    if (instance == null)
                    {
                        instance = new CarDBContext();
                    }
                    return instance;
                }
            }
        }

        public List<Car> GetCarList => CarList;

        public Car GetCarById(int carID)
        {
            // Using LINQ to Object
            Car car = CarList.SingleOrDefault(pro => pro.CarID == carID);
            return car;
        }

        // Add a new car
        public void AddNew(Car car)
        {
            Car pro = GetCarById(car.CarID);
            if (pro == null)
            {
                CarList.Add(car);
            } else
            {
                throw new Exception("Car already exists!");
            }
        }

        // Update a car
        public void Update(Car car)
        {
            Car c = GetCarById(car.CarID);
            if (c == null)
            {
                throw new Exception("Car doesn't exist!!");
            } else
            {
                var index = CarList.IndexOf(c);
                CarList[index] = car;
            }
        }

        // Remove a car
        public void Remove(int CarID)
        {
            Car p = GetCarById(CarID);
            if (p == null)
            {
                throw new Exception("Car doesn't exist!!");
            } else
            {
                CarList.Remove(p);
            }
        }
    } // End Class
}
