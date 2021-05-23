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
import phongnt.tblUsers.TblUsersInfoError;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class UserServlet extends HttpServlet {

    private final String USER_PAGE = "User";
    private final String LOGIN_PAGE = "login";

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

        String url = USER_PAGE;
        TblUsersInfoError errors = new TblUsersInfoError();
        boolean isError = false;

        try {
            HttpSession session = request.getSession(false);
            if (session == null) {
                url = LOGIN_PAGE;
            } else {
                TblUsersDTO curUser = (TblUsersDTO) session.getAttribute("LOGIN_USER");
                if (curUser == null) {
                    url = LOGIN_PAGE;
                } else {
                    String userID = curUser.getUserID();
                    TblUsersDAO dao = new TblUsersDAO();
                    TblUsersDTO userInfo = dao.getUserInfo(userID);
                    request.setAttribute("CURRENT_USER", userInfo);
                    url = USER_PAGE;
                }
            }
        } catch (SQLException ex) {
            log("UserServlet SQL: " + ex.getMessage());
            errors.setErrorMsg("An error has occured... Please contact the web owner for more details!!!");
            request.setAttribute("USER_ERROR", errors);
        } catch (NamingException ex) {
            log("UserServlet Naming: " + ex.getMessage());
            errors.setErrorMsg("An error has occured... Please contact the web owner for more details!!!");
            request.setAttribute("USER_ERROR", errors);
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
