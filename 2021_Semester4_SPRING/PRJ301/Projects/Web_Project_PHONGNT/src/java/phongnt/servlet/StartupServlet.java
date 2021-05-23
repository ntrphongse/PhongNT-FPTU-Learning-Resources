/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phongnt.accountInfo.AccountInfoDAO;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class StartupServlet extends HttpServlet {
    private final String LOGIN_SERVLET = "login";
    private final String SEARCH_SERVLET = "search";

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
        String url = LOGIN_SERVLET;
        
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                // Session existed
                String username = (String) session.getAttribute("username");
                if (username != null) {
                    // User has logged in before
                    url = SEARCH_SERVLET;
                }
            } else {
                // Check the Cookie
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    // Cookies existed
                    String username = null;
                    String password = null;
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("username")) {
                            username = cookie.getValue();
                        }
                        if (cookie.getName().equals("password")) {
                            password = cookie.getValue();
                        }
                        if (username != null && password != null) {
                            break;
                        }
                    }
                    
                    if (username != null && password != null) {
                        // Username and Password had been saved before
                        AccountInfoDAO dao = new AccountInfoDAO();
                        boolean isLogin = dao.checkLogin(username, password);
                        if (isLogin) {
                            url = SEARCH_SERVLET;
                        }
                    }
                }
            } // EndIf Session existed
            response.sendRedirect(url);
        } catch (NamingException ex) {
            log(ex.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (SQLException ex) {
            request.setAttribute("ERROR", "SQL Error!!!! " + ex.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
        finally {
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
