using AutomobileLibrary.BusinessObject;
using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AutomobileLibrary.DataAccess
{
    public class CarDBContext : BaseDAL
    {

        // Singleton
        private static CarDBContext instance = null;
        private static readonly object instanceLock = new object();
        private CarDBContext()
        {

        }

        public static CarDBContext Instance
        {
            get
            {
                lock (instanceLock)
                {
                    if (instance == null)
                    {
                        instance = new CarDBContext();
                    }
                    return instance;
                }
            }
        }

        public IEnumerable<Car> GetCarList()
        {
            IDataReader dataReader = null;
            string SQLSelect = "SELECT CarID, CarName, Manufacturer, Price, ReleasedYear " +
                "FROM Car";
            var cars = new List<Car>();

            try
            {
                dataReader = dataProvider.GetDataReader(SQLSelect, CommandType.Text, out connection);
                while (dataReader.Read())
                {
                    cars.Add(new Car
                    {
                        CarID = dataReader.GetInt32(0),
                        CarName = dataReader.GetString(1),
                        Manufacturer = dataReader.GetString(2),
                        Price = dataReader.GetDecimal(3),
                        ReleasedYear = dataReader.GetInt32(4)
                    });
                }
            } catch (Exception ex)
            {
                throw new Exception(ex.Message);
            } finally
            {
                dataReader.Close();
                dataProvider.CloseConnection(connection);
            }

            return cars;
        }

        public Car GetCarByID (int carID)
        {
            Car car = null;

            IDataReader dataReader = null;
            string SQLSelect = "SELECT CarID, CarName, Manufacturer, Price, ReleasedYear " +
                "FROM Car " +
                "WHERE CarID = @CarID";

            try
            {
                var param = dataProvider.CreateParameter("@CarID", 4, carID, DbType.Int32);
                dataReader = dataProvider.GetDataReader(SQLSelect, CommandType.Text, out connection, param);
                while (dataReader.Read())
                {
                    car = new Car
                    {
                        CarID = dataReader.GetInt32(0),
                        CarName = dataReader.GetString(1),
                        Manufacturer = dataReader.GetString(2),
                        Price = dataReader.GetDecimal(3),
                        ReleasedYear = dataReader.GetInt32(4)
                    };
                }
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                dataReader.Close();
                dataProvider.CloseConnection(connection);
            }

            return car;
        }

        public void AddNew(Car car)
        {
            try
            {
                Car pro = GetCarByID(car.CarID);
                if (pro == null)
                {
                    string SQLInsert = "INSERT Car " +
                        "VALUES (@CarID, @CarName, @Manufacturer, @Price, @ReleasedYear)";
                    var parameters = new List<SqlParameter>();
                    parameters.Add(dataProvider.CreateParameter("@CarID", 4, car.CarID, DbType.Int32));
                    parameters.Add(dataProvider.CreateParameter("@CarName", 50, car.CarName, DbType.String));
                    parameters.Add(dataProvider.CreateParameter("@Manufacturer", 50, car.Manufacturer, DbType.String));
                    parameters.Add(dataProvider.CreateParameter("@Price", 50, car.Price, DbType.Decimal));
                    parameters.Add(dataProvider.CreateParameter("@ReleasedYear", 4, car.ReleasedYear, DbType.Int32));
                    dataProvider.Insert(SQLInsert, CommandType.Text, parameters.ToArray());
                }
                else
                {
                    throw new Exception("The car is existed!!");
                }
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                dataProvider.CloseConnection(connection);
            }
        }

        public void Update(Car car)
        {
            try
            {
                Car pro = GetCarByID(car.CarID);
                if (pro == null)
                {
                    string SQLInsert = "UPDATE Car " +
                        "SET CarName = @CarName, Manufacturer = @Manufacturer, " +
                        "Price = @Price, ReleasedYear = @ReleasedYear " +
                        "WHERE CarID = @CarID";
                    var parameters = new List<SqlParameter>();
                    parameters.Add(dataProvider.CreateParameter("@CarID", 4, car.CarID, DbType.Int32));
                    parameters.Add(dataProvider.CreateParameter("@CarName", 50, car.CarName, DbType.String));
                    parameters.Add(dataProvider.CreateParameter("@Manufacturer", 50, car.Manufacturer, DbType.String));
                    parameters.Add(dataProvider.CreateParameter("@Price", 50, car.Price, DbType.Decimal));
                    parameters.Add(dataProvider.CreateParameter("@ReleasedYear", 4, car.ReleasedYear, DbType.Int32));
                    dataProvider.Update(SQLInsert, CommandType.Text, parameters.ToArray());
                }
                else
                {
                    throw new Exception("The car doesn't existed!!");
                }
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                dataProvider.CloseConnection(connection);
            }
        }

        public void Remove(int carID)
        {
            try
            {
                Car pro = GetCarByID(carID);
                if (pro != null)
                {
                    string SQLInsert = "DELETE Car " +
                        "WHERE CarID = @CarID";
                    var parameter = dataProvider.CreateParameter("@CarID", 4, carID, DbType.Int32);
                    dataProvider.Update(SQLInsert, CommandType.Text, parameter);
                }
                else
                {
                    throw new Exception("The car doesn't existed!!");
                }
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                dataProvider.CloseConnection(connection);
            }
        }
    }
}
