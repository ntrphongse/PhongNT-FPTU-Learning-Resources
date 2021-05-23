/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoadnt.controllers;

import hoadnt.product.ProductDAO;
import hoadnt.product.ProductDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hd
 */

public class SearchController extends HttpServlet {
    
    private static final String SEARCH_PAGE = "product.jsp";
    private static final String ERROR = "product.jsp";

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
        
        String strFrom = request.getParameter("fromTime").trim();
        int from = 0;
        String strTo = request.getParameter("toTime").trim();
        int to = 0;
        
        String url = ERROR;
        boolean isError = false;
        
        try {
            
            from = Integer.parseInt(strFrom);
            to = Integer.parseInt(strTo);
            
            if (from > to) {
                int t = from;
                from = to;
                to = t;
            }
            
            ProductDAO dao = new ProductDAO();
            List<ProductDTO> productList = dao.search(from, to);
            request.setAttribute("SEARCH_RESULT", productList);
            
        } catch (Exception e) {
            log("Error at SearchController: " + e.getMessage());
            if (e.getMessage().contains("input string")) {
                request.setAttribute("ERROR", "Cooking Time must be an integer!!");
            }
        }
        finally {
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
