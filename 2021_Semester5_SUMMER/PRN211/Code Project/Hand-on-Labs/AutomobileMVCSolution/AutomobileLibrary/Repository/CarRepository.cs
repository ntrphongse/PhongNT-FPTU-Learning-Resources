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
        public void DeleteCar(int carId)
        {
            CarDAO.Instance.Remove(carId);
        }

        public Car GetCarByID(int carId)
        {
            return CarDAO.Instance.GetCarByID(carId);

        }

        public IEnumerable<Car> GetCars()
        {
            return CarDAO.Instance.GetCarList();
        }

        public void InsertCar(Car car)
        {
            CarDAO.Instance.AddNew(car);
        }

        public void UpdateCar(Car car)
        {
            CarDAO.Instance.Update(car);
        }
    }
}
