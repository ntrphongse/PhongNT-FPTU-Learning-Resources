/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phongnt.cart.CartObj;

/**
 *
 * @author Trần Phong <phongntse150974@fpt.edu.vn>
 */
public class RemoveServlet extends HttpServlet {

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
        
        try {
            // 1. Customer goes to their cart place
            HttpSession session = request.getSession(false); // Session time out
            if (session != null) {
                // 2. Customer takes their cart
                CartObj cart = (CartObj)session.getAttribute("CART");
                if (cart != null) {
                    // 3. Customer gets items
                    Map<Integer, Integer> items = cart.getItems();
                    if (items != null) {
                        // 4. Customer selects some removed Book
                        String[] selectedBook = request.getParameterValues("chkItem");
                        if (selectedBook != null) {
                            // 5. Remove Books from cart
                            for (String strProductId : selectedBook) {
                                cart.removeBookFromCart(Integer.parseInt(strProductId));
                            } // End For loop for Removing
                            session.setAttribute("CART", cart);
                        } // EndIf Selected Items list is existed
                        
                    } // EndIf Items have some books
                }
            } // EndIf existed Session
            
            // 6. Call View Card function
            String urlRewriting = "cart"
                    + "?btnAction=View your Cart";
            response.sendRedirect(urlRewriting);
        } finally {
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
