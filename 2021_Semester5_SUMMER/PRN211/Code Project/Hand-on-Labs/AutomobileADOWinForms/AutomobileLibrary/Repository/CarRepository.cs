using AutomobileLibrary.BusinessObject;
using AutomobileLibrary.DataAccess;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AutomobileLibrary.Repository
{
    public class CarRepository : ICarRepository
    {
        public void DeleteCar(int carId) => CarDBContext.Instance.Remove(carId);

        public Car GetCarById(int carId) => CarDBContext.Instance.GetCarByID(carId);


        public IEnumerable<Car> GetCars() => CarDBContext.Instance.GetCarList();


        public void InsertCar(Car car) => CarDBContext.Instance.AddNew(car);


        public void UpdateCar(Car car) => CarDBContext.Instance.Update(car);
    }
}
