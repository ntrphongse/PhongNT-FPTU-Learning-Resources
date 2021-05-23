/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phongnt.tblCategories.TblCategoriesDAO;
import phongnt.tblProducts.TblProductsDAO;
import phongnt.tblProducts.TblProductsDTO;
import phongnt.tblProducts.TblProductsShopError;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class StoreServlet extends HttpServlet {
    private final String STORE_PAGE = "shop";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        ArrayList<TblProductsDTO> result;
        HashMap<Integer, String> categoryList;
        
        String url = STORE_PAGE;
        TblProductsShopError errors = new TblProductsShopError();
        
        try {
            String strCategoryID = request.getParameter("category");
            if (strCategoryID.equals("all")) {
                strCategoryID = "-1";
            }
            int categoryID = Integer.parseInt(strCategoryID);
            
            TblProductsDAO dao = new TblProductsDAO();
            dao.getProducts(categoryID);
            result = dao.getProductList();
            request.setAttribute("PRODUCT_LIST", result);
            
//            TblCategoriesDAO categoryDAO = new TblCategoriesDAO();
//            categoryDAO.getCategoryNames();
//            categoryList = (HashMap<Integer, String>) categoryDAO.getCategoryList();
//            request.setAttribute("CATEGORY_LIST", categoryList);
            
        } catch (SQLException ex) {
            log("BookStore SQL: " + ex.getMessage());
            errors.setErrorMsg("An error has occured during your shopping... Please contact the web owner for more details!!!");
            request.setAttribute("STORE_ERROR", errors);
        } catch (NamingException ex) {
            log("BookStore Naming: " + ex.getMessage());
            errors.setErrorMsg("An error has occured during your shopping... Please contact the web owner for more details!!!");
            request.setAttribute("STORE_ERROR", errors);
        }
        finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
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
