/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phongnt.cart.CartObj;
import phongnt.cart.CartProductDTO;
import phongnt.order.OrderDAO;
import phongnt.order.OrderError;
import phongnt.tblProducts.TblProductsDAO;
import phongnt.tblProducts.TblProductsDTO;
import phongnt.tblUsers.TblUsersDAO;
import phongnt.tblUsers.TblUsersDTO;

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
        String strTotal = request.getParameter("total");

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

                if (!isError) {
                    // Add Order
                    // Get the Cart
                    HttpSession session = request.getSession(false);
                    if (session != null) {
                        CartObj cart = (CartObj) session.getAttribute("CART");
                        if (cart != null) {
                            Map<Integer, CartProductDTO> cartList = cart.getCart();
                            if (cartList != null) {

                                String userID = "";
                                float total = Float.parseFloat(strTotal);
                                Timestamp date = new Timestamp(System.currentTimeMillis());

                                TblUsersDTO curUser = (TblUsersDTO) session.getAttribute("LOGIN_USER");
                                if (curUser != null) {
                                    userID = curUser.getUserID();
                                } else {
                                    Date dNow = new Date();
                                    SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
                                    String datetime = ft.format(dNow);
                                    userID = "user" + datetime;

                                    TblUsersDAO userDAO = new TblUsersDAO();
                                    userDAO.createAccount(userID, datetime, name, "", address, false);
                                }
                                TblProductsDAO dao = new TblProductsDAO();
                                Map<Integer, CartProductDTO> productList = cart.getCart();
                                Set<Integer> productIds = productList.keySet();
                                boolean isQuantity = false;
                                for (Integer productId : productIds) {
                                    TblProductsDTO product = dao.getProduct(productId);
                                    if (product.getQuantity() < productList.get(productId).getQuantity()) {
                                        isQuantity = true;
                                        throw new RuntimeException("Error when add to Cart!! Please check your product and its quantity!!");
                                    }
                                }
                                if (!isQuantity) {
                                    OrderDAO OrderDAO = new OrderDAO();
                                    int result = OrderDAO.createOrder(userID, name, address, total, date, cart);
                                    if (result > 0) {
                                        // Order successfully
                                        url = CHECK_OUT_SUCCESS;
                                        request.setAttribute("ORDER_SUCCESS", cart);
                                        session.removeAttribute("CART");
                                    } else {
                                        // Failed to order
                                        errors.setErrorMsg("Cannot process your Order!! "
                                                + "Please contact the web owner for more details!!!");
                                        request.setAttribute("ORDER_ERROR", errors);
//                                    isError = true;
                                    }
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
//            isError = true;
        } catch (NamingException ex) {
            log("CheckOutServlet Naming: " + ex.getMessage());
            errors.setErrorMsg("Can't process your Order! An error has occured "
                    + "during your order processing... Please contact the web owner for more details!!!");
            request.setAttribute("ORDER_ERROR", errors);
//            isError = true;
        } catch (RuntimeException ex) {
            errors.setErrorMsg(ex.getMessage());
            request.setAttribute("ORDER_ERROR", errors);
        } finally {

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
