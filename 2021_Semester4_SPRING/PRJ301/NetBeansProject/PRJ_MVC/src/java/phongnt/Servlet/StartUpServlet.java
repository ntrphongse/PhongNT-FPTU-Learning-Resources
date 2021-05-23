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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phongnt.accountInfo.AccountInfoDAO;

/**
 *
 * @author Trần Phong <phongntse150974@fpt.edu.vn>
 */
public class StartUpServlet extends HttpServlet {
    private final String LOGIN_PAGE = "Login.jsp";
    private final String SEARCH_PAGE = "SearchJSP.jsp";

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
        String url = LOGIN_PAGE;
        
        try {
           // 1. Check cookies are existed
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                // 2. Get Username & Password from last cookie
//                Cookie lastCookie = cookies[cookies.length-1];
//                String username = lastCookie.getName();
//                String password = lastCookie.getValue();
                String username = null;
                String password = null;
                for (int i = 0; i < cookies.length; i++) {
                    Cookie curCookie = cookies[i];
                    if (curCookie.getName().equals("MVCUsername")) {
                        username = curCookie.getValue();
                        break;
                    }
                } // EndFor find Username
                
                if (username != null) {
                    for (int i = 0; i < cookies.length; i++) {
                        Cookie curCookie = cookies[i];
                        if (curCookie.getName().equals(username)) {
                            password = curCookie.getValue();
                            break;
                        }
                    } // EndFor find Password
                }
                
                // 3. Check Username & Password is correct
                AccountInfoDAO dao = new AccountInfoDAO();
                boolean isLogin = dao.checkLogin(username, password);
                
                if (isLogin) {
                    url = SEARCH_PAGE;
                } // EndIf User valid
            } // Cookies have existed
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
        } finally {
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
