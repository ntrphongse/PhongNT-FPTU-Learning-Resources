/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phongnt.accountInfo.AccountInfoDAO;

/**
 *
 * @author Hp
 */
public class LoginServlet extends HttpServlet {
    private final String INVALID_PAGE = "invalid.html";
//    private final String SEARCH_PAGE = "search.html";
    private final String SEARCH_PAGE = "SearchJSP.jsp";
    private final String VIEW_CART_PAGE = "ViewCart.jsp";

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
        
        String url = INVALID_PAGE; // Default
        
        // Get Parameters
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String lastURL = request.getParameter("redirect");
        
        try {
            AccountInfoDAO dao = new AccountInfoDAO();
            boolean result = dao.checkLogin(username, password);

            if (result) {
                if (lastURL != null && lastURL.equals("viewcart")) {
                    url = VIEW_CART_PAGE;
                } else {
                    url = SEARCH_PAGE;
                }
//                Cookie cookie = new Cookie(username, password);
//                Cookie cookieUser = new Cookie("MVCUsername", username);
//                Cookie cookiePassword = new Cookie(username, password);
//                cookieUser.setMaxAge(60*10);
//                cookiePassword.setMaxAge(60*15);
//                response.addCookie(cookieUser);
//                response.addCookie(cookiePassword);
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    // TODO Code
                    // Get Fullname
                    // Save Fullname
            }
        } catch (SQLException ex) {
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
//            response.sendRedirect(url); // Send response
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
