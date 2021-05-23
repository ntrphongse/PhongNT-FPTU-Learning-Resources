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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phongnt.tblUsers.TblUsersDAO;
import phongnt.tblUsers.TblUsersDTO;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class StartupServlet extends HttpServlet {
    private final String LOGIN_SERVLET = "login";
    private final String SEARCH_SERVLET = "search";
    private final String SHOP_SERVLET = "shop";

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
                TblUsersDTO user = (TblUsersDTO) session.getAttribute("LOGIN_USER");
                if (user != null) {
                    // User has logged in before
                    TblUsersDAO dao = new TblUsersDAO();
                    if (dao.isAdmin(user.getUserID()) == 0) {
                        url = SHOP_SERVLET;
                    } else {
                        url = SEARCH_SERVLET;
                    }
                }
            } 
//            else {
//                // Check the Cookie
//                Cookie[] cookies = request.getCookies();
//                if (cookies != null) {
//                    // Cookies existed
//                    String user = null;
//                    String password = null;
//                    for (Cookie cookie : cookies) {
//                        if (cookie.getName().equals("user")) {
//                            user = cookie.getValue();
//                        }
//                        if (cookie.getName().equals("password")) {
//                            password = cookie.getValue();
//                        }
//                        if (user != null && password != null) {
//                            break;
//                        }
//                    }
//                    
//                    if (user != null && password != null) {
//                        // Username and Password had been saved before
//                        TblUsersDAO dao = new TblUsersDAO();
//                        boolean isLogin = dao.checkLogin(user, password);
//                        if (isLogin) {
//                            if (dao.isAdmin(user) == 0) {
//                                url = SHOP_SERVLET;
//                            } else {
//                                session = request.getSession();
//                                session.setAttribute("user", user);
//                                session.setAttribute("fullName", dao.getFullName(user));
//                                url = SEARCH_SERVLET;
//                            }
//                            
//                        }
//                    }
//                }
//            } // EndIf Session existed
            response.sendRedirect(url);
        } catch (NamingException ex) {
            log(ex.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (SQLException ex) {
            log(ex.getMessage());
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
