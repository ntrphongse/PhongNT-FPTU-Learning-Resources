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
import phongnt.accountInfo.AccountInfoDAO;
import phongnt.accountInfo.AccountInfoUpdateError;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class UpdateServlet extends HttpServlet {
    private final String SEARCH_SERVLET = "Search";
    private final String SEARCH_PAGE = "search";
    private final String ERROR_PAGE = "updateError";

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
        
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String lastname = request.getParameter("txtLastname");
        String admin = request.getParameter("isAdmin");
        String lastSearchValue = request.getParameter("lastSearchValue");
        
        String url = SEARCH_PAGE;
        
        boolean isError = false;
        AccountInfoUpdateError errors = new AccountInfoUpdateError();
        
        try {
            if (!(username.trim().isEmpty() || 
                    lastSearchValue.trim().isEmpty())) {
                // The true link is click
                if (password.length() < 6 || password.length() > 20) {
                    errors.setPasswordLengthErr("Password requires input from 6 "
                            + "to 20 characters!");
                    isError = true;
                }
                if (lastname.length() < 2 || lastname.length() > 50) {
                    errors.setLastnameLengthErr("Full name requires input from 2 "
                            + "to 50 characters!!");
                    isError = true;
                }
//                if (isError) {
//                    url = ERROR_PAGE;
//                    request.setAttribute("UPDATE_ERROR", errors);
//                    RequestDispatcher rd = request.getRequestDispatcher(url);
//                    rd.forward(request, response);
//                } else {
                if (!isError) {
                    boolean isAdmin = false;
                    if (admin != null && admin.equals("ADMIN")) {
                        isAdmin = true;
                    }
                    AccountInfoDAO dao = new AccountInfoDAO();
                    boolean result = dao.updateAccount(username, 
                                    password, lastname, isAdmin);
                    if (result) {
                        // Update successfully
                        url = SEARCH_SERVLET + 
                                "?txtSearchValue=" + lastSearchValue;
                    } else {
                        errors.setCannotUpdateErr("Cannot update the account '"
                                + username + "' !!!");
                        isError = true;
                    }
                }
            }
        } catch (SQLException ex) {
            log("UpdateServlet SQL: " + ex.getMessage());
            errors.setErrorMsg("An error has occured during your search... Please contact the web owner for more details!!!");
            isError = true;
            
        } catch (NamingException ex) {
            log("UpdateServlet Naming: " + ex.getMessage());
            errors.setErrorMsg("An error has occured during your search... Please contact the web owner for more details!!!");
            request.setAttribute("UPDATE_ERROR", errors);
            isError = true;
        }
        finally {
            if (isError) {
                url = ERROR_PAGE;
                request.setAttribute("UPDATE_ERROR", errors);
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            } else {
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
