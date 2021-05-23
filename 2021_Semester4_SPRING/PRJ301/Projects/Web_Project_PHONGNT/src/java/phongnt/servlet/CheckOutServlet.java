/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phongnt.cart.CartObj;
import phongnt.order.OrderDAO;
import phongnt.order.OrderError;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class CheckOutServlet extends HttpServlet {
    private final String CHECK_OUT_PAGE = "checkout";
    private final String CHECK_OUT_SUCCESS = "orderconfirm";
    
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
        
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        
        String url = CHECK_OUT_PAGE;
        
        OrderError errors = new OrderError();
        boolean isError = false;
        
        try {
            if (name != null & address != null) {
                if (name.trim().length() < 2 || name.trim().length() > 50) {
                    errors.setNoNameErr("Your name requires input from 2 to "
                            + "50 characters!!!");
                    request.setAttribute("ORDER_ERROR", errors);
                    isError = true;
                }

                if (address.trim().length() < 10) {
                    errors.setNoAddressErr("Your address requires input that is "
                            + "more than 10 characters!!!");
                    request.setAttribute("ORDER_ERROR", errors);
                    isError = true;
                }

                if (isError) {
                    RequestDispatcher rd = request.getRequestDispatcher(url);
                    rd.forward(request, response);
                } else {
                    // Add Order
                    // Get the Cart
                    HttpSession session = request.getSession(false);
                    if (session != null) {
                        CartObj cart = (CartObj)session.getAttribute("CART");
                        if (cart != null) {
                            Map<Integer, Integer> cartList = cart.getCart();
                            if (cartList != null) {
                                OrderDAO dao = new OrderDAO();
                                boolean result = dao.createOrder(name, address, cart);
                                if (result) {
                                    // Order successfully
                                    url = CHECK_OUT_SUCCESS;
                                    session.removeAttribute("CART");
                                } else {
                                    // Failed to order
                                    errors.setErrorMsg("Cannot process your Order!! "
                                            + "Please contact the web owner for more details!!!");
                                    request.setAttribute("ORDER_ERROR", errors);
                                    isError = true;
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            log("CheckOutServlet SQL: " + ex.getMessage());
            errors.setErrorMsg("Can't process your Order! An error has occured "
                    + "during your order processing... Please contact the web owner for more details!!!");
            request.setAttribute("ORDER_ERROR", errors);
            isError = true;
        } catch (NamingException ex) {
            log("CheckOutServlet Naming: " + ex.getMessage());
            errors.setErrorMsg("Can't process your Order! An error has occured "
                    + "during your order processing... Please contact the web owner for more details!!!");
            request.setAttribute("ORDER_ERROR", errors);
            isError = true;
        }
        finally {
            if (isError) {
                // No error
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            } else {
                // Send to check out successfully page
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
