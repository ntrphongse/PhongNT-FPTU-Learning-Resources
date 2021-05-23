/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phongnt.cart.CartObj;
import phongnt.cart.CartObjAddToCartError;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class AddToCartServlet extends HttpServlet {
    private final String DETAIL_SERVLET = "Detail";

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
        
        String strId = request.getParameter("bookId");
        String strQuantity = request.getParameter("quantity");
        
        String url = DETAIL_SERVLET;
        
        CartObjAddToCartError errors = new CartObjAddToCartError();
        boolean isErr = false;
        
        try {
            if (strId != null && strQuantity != null) {
                int id = Integer.parseInt(strId);
                int quantity = Integer.parseInt(strQuantity);
                
                HttpSession session = request.getSession();

                CartObj cart = (CartObj)session.getAttribute("CART");

                if (cart == null) {
                    cart = new CartObj();
                }
                cart.addBookToCart(id, quantity);
                session.setAttribute("CART", cart);
            }
        } catch (NumberFormatException ex) {
            log("AddToCartServlet NumberFormat: " + ex.getMessage());
            errors.setNumberFormatErr("Wrong number format! Please make sure "
                    + "that you entered a number as quantity!!!");
            request.setAttribute("ADD_ERROR", errors);
            isErr = true;
        }
        finally {
            url = DETAIL_SERVLET + "?bookId=" + strId + 
                    "&quantity=" + strQuantity;
            if (isErr) {
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            } else {
                url += "&add=success";
                response.sendRedirect(url);
            }
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
