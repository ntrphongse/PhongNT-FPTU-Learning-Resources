using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ManageCategoriesApp
{
    // Declaring record Category
    public record Category
    {
        public int CategoryID { get; set; }
        public string CategoryName { get; set; }
    }

    public class ManageCategories
    {
        SqlConnection connection;
        SqlCommand command;
        string ConnectionString = "Server=TRANPHONG\\SQLEXPRESS;uid=sa;pwd=123456;database=MyStore";
        public List<Category> GetCategories()
        {
            List<Category> categories = new List<Category>();
            connection = new SqlConnection(ConnectionString);
            string SQL = "SELECT CategoryID, CategoryName " +
                "FROM Categories";
            command = new SqlCommand(SQL, connection);
            try
            {
                connection.Open();
                SqlDataReader reader = command.ExecuteReader(CommandBehavior.CloseConnection);
                if (reader.HasRows)
                {
                    while (reader.Read())
                    {
                        categories.Add(new Category
                        {
                            CategoryID = reader.GetInt32("CategoryID"),
                            CategoryName = reader.GetString("CategoryName")
                        });
                        
                    } // End While
                } // End If
            } catch (Exception ex)
            {
                throw new Exception(ex.Message);
            } finally
            {
                connection.Close();
            }
            return categories;
        }

        public void InsertCategory(Category category)
        {
            connection = new SqlConnection(ConnectionString);

            command = new SqlCommand("INSERT Categories " +
                "VALUES (@CategoryName)", connection);
            command.Parameters.Add("@CategoryName", SqlDbType.NVarChar).Value = category.CategoryName;
            try
            {
                connection.Open();
                command.ExecuteNonQuery();
            } catch (Exception ex)
            {
                throw new Exception(ex.Message);
            } finally
            {
                connection.Close();
            }
        }

        public void UpdateCategory(Category category)
        {
            connection = new SqlConnection(ConnectionString);

            command = new SqlCommand("UPDATE Categories " +
                "SET CategoryName = @CategoryName " +
                "WHERE CategoryID = @CategoryID", connection);
            command.Parameters.AddWithValue("@CategoryID", category.CategoryID);
            command.Parameters.AddWithValue("@CategoryName", category.CategoryName);
            try
            {
                connection.Open();
                command.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                connection.Close();
            }
        }

        public void DeleteCategory(Category category)
        {
            connection = new SqlConnection(ConnectionString);

            command = new SqlCommand("DELETE Categories " +
                "WHERE CategoryID = @CategoryID", connection);
            command.Parameters.AddWithValue("@CategoryID", category.CategoryID);
            try
            {
                connection.Open();
                command.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                connection.Close();
            }
        }
    }
}
