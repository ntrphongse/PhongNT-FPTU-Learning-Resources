/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoadnt.controllers;

import hoadnt.product.ProductDAO;
import hoadnt.product.ProductDTO;
import hoadnt.product.ProductErrorDTO;
import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hd
 */
public class InsertController extends HttpServlet {
    private static final String INSERT_PAGE = "insert.jsp";
    private static final String ERROR_PAGE = "insert.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    Hoadnt: Your code here. Do not delete this comment
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String url = ERROR_PAGE;
        ProductErrorDTO error = new ProductErrorDTO();
        boolean isError = false;
        
        try {
            
            String id = request.getParameter("id").trim();
            String name = request.getParameter("name").trim();
            String description = request.getParameter("description").trim();
            String strPrice = request.getParameter("price").trim();
            float price = 0;
            String strCookingTime = request.getParameter("cookingTime").trim();
            int cookingTime = 0;
            boolean status = true;
            Timestamp createDate = new Timestamp(System.currentTimeMillis());
            
            if (!id.matches("^F-[0-9a-zA-z]{3}")) {
                error.setIdError("Food ID requires input to be formatted with F-XXX !!");
                isError = true;
            }
            if (name.length() < 3 || name.length() > 50) {
                error.setNameError("Food Name requires input from 3 to 50 characters!!");
                isError = true;
            }
            if (description.length() < 5 || description.length() > 500) {
                error.setDescriptionError("Food Description requires input from 5 to 500 characters!!");
                isError = true;
            }
            
                try {
                    price = Float.parseFloat(strPrice);
                    if (price < 0) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException ex) {
                    error.setPriceError("Food Price requires input of a positive number!!");
                    isError = true;
                }
            
            
                try {
                    cookingTime = Integer.parseInt(strCookingTime);
                    if (cookingTime < 0) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException ex) {
                    error.setCookingTimeError("Food Cooking Time requires input of a positive integer!!");
                    isError = true;
                }
            
            
            if (!isError) {
                ProductDTO newProduct = new ProductDTO(id, name, description, price, cookingTime, status, createDate);
                ProductDAO dao = new ProductDAO();
                boolean iInsert = dao.insert(newProduct);
                if (iInsert) {
                    request.setAttribute("INSERT_SUCCESS", "Insert Food successfully!!");
                    url = INSERT_PAGE;
                } else {
                    error.setError("Something went wrong, please contact the web owner for more detail!!!");
                    isError = true;
                }
            }
            
        } catch (Exception e) {
            log("Error at InsertController: " + e.getMessage());
            if (e.getMessage().contains("duplicate")) {
                error.setIdError("Food ID is existed!!");
                isError = true;
            } else {
                request.setAttribute("ERROR", "Something went wrong, please cont.act the web owner for more detail!!!");
            }
        } 
        finally {
            request.setAttribute("INSERT_ERROR", error);
            request.getRequestDispatcher(url).forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
