/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Map;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phongnt.cart.CartObj;
import phongnt.orderInfo.OrderInfoDAO;
import phongnt.orderDetails.OrderDetailsDAO;

/**
 *
 * @author Trần Phong <phongntse150974@fpt.edu.vn>
 */
public class CheckOutServlet extends HttpServlet {

    private final String BOOKING_PAGE = "bookStore.jsp";
    private final String CHECKOUT_PAGE = "CheckOut.html";
    private final String ERROR_PAGE = "error.html";

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
        
        String username = request.getParameter("curUsername");
        String address = request.getParameter("address");
        String url = BOOKING_PAGE;
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                CartObj cart = (CartObj)session.getAttribute("CART");
                if (cart != null) {
                    Map<Integer, Integer> items = cart.getItems();
                    if (items != null) {
                        // Add into Order
                        OrderInfoDAO orderDao = new OrderInfoDAO();
                        Timestamp time = new Timestamp(System.currentTimeMillis());
                        int orderId = orderDao.addOrder(username, address, time);
                        
                        if (orderId > 0) {
                            boolean isAdd = false;
                            for (int productId : items.keySet()) {
                                OrderDetailsDAO detailDao = new OrderDetailsDAO();
                                isAdd = detailDao.addOrderDetails(orderId, productId, items.get(productId));
                            }
                            if (isAdd) {
                                session.setAttribute("CART", null);
                                url = CHECKOUT_PAGE;
                            } else {
                                log("Can't add Order Details!!!!");
                                url = ERROR_PAGE;
                            }
                        } else {
                            log("Can add Order !!!!");
                            url = ERROR_PAGE;
                        }
                    }
                }
                
            }
        } catch (SQLException ex) {
//            ex.printStackTrace();
            log(ex.getMessage());
            request.setAttribute("Error", ex.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("Error");
            rd.forward(request, response);
        } catch (NamingException ex) {
            log(ex.getMessage());
            request.setAttribute("Error", ex.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("Error");
            rd.forward(request, response);
        }
        finally {
            response.sendRedirect(url);
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
