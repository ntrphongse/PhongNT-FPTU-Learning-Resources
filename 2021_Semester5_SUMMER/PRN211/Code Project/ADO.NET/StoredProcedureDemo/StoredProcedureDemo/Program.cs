using System;
using Microsoft.Data.SqlClient;

namespace StoredProcedureDemo
{
    class Program
    {
        static (int OutputValue, int ReturnValue) CountProductsByCategoryID(int CategoryID)
        {
            (int OutputValue, int ReturnValue) result; // Tuple

            string ConnectionString = "Server=TRANPHONG\\SQLEXPRESS;uid=sa;pwd=123456;database=MyStore";
            SqlConnection connection = new SqlConnection(ConnectionString);
            SqlCommand command = new SqlCommand();
            command.Connection = connection;
            command.CommandType = System.Data.CommandType.StoredProcedure;
            connection.Open();
            CountProductsUsingOutputValue();
            CountProductsUsingReturnValue();

            void CountProductsUsingOutputValue()
            {
                command.CommandText = "spCountProductsUsingOutputValue";
                command.Parameters.AddWithValue("@CategoryID", CategoryID);
                // Using ouput value
                command.Parameters.Add("@NumberOfProducts", System.Data.SqlDbType.Int)
                                    .Direction = System.Data.ParameterDirection.Output;
                command.ExecuteNonQuery();
                result.OutputValue = (int)command.Parameters["@NumberOfProducts"].Value;
            }

            void CountProductsUsingReturnValue()
            {
                command.CommandText = "spCountProductsUsingReturnValue";
                //command.Parameters.AddWithValue("@CategoryID", CategoryID);
                //// Using ouput value
                //command.Parameters.Add("@NumberOfProducts", System.Data.SqlDbType.Int)
                //                    .Direction = System.Data.ParameterDirection.Output;
                command.Parameters["@NumberOfProducts"].Direction = System.Data.ParameterDirection.ReturnValue;
                command.ExecuteNonQuery();
                result.ReturnValue = (int)command.Parameters["@NumberOfProducts"].Value;
            }

            connection.Close();

            return result;
        }
        static void Main(string[] args)
        {
            int CategoryID = 1;
            var result = CountProductsByCategoryID(CategoryID);
            Console.WriteLine($"Number of products by CategoryID: {CategoryID}");
            Console.WriteLine($"---> OutputValue: {result.OutputValue}, Return Value: {result.ReturnValue}");

            CategoryID = 3;
            result = CountProductsByCategoryID(CategoryID);
            Console.WriteLine($"Number of products by CategoryID: {CategoryID}");
            Console.WriteLine($"---> OutputValue: {result.OutputValue}, Return Value: {result.ReturnValue}");
            Console.ReadLine();
        }
    }
}
