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
import phongnt.accountInfo.AccountInfoCreateError;
import phongnt.accountInfo.AccountInfoDAO;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class CreateNewAccountServlet extends HttpServlet {
    private final String ERROR_PAGE = "createNewAccount.jsp";
    private final String LOGIN_PAGE = "login.html";

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
        String confirm = request.getParameter("txtConfirm");
        String fullname = request.getParameter("txtFullname");
        
        String url = ERROR_PAGE;
        
        AccountInfoCreateError errors = new AccountInfoCreateError();
        boolean foundErr = false;
        
        try {
            // 1. Check valid user input
            if (username.trim().length() < 6 || username.trim().length() > 30) {
                foundErr = true;
                errors.setUsernameLengthErr("Username requires input from 6 to 30 characters!");
            }
            
            if (password.trim().length() < 6 || username.trim().length() > 20) {
                foundErr = true;
                errors.setPasswordLengthErr("Password requires input from 6 to 20 characters!");
            } else if (!password.trim().equals(confirm.trim())) {
                foundErr = true;
                errors.setConfirmNotMatch("Confirm mus be matched with password!");
            }
            
            if (fullname.trim().length() < 2 || fullname.trim().length() > 50) {
                foundErr = true;
                errors.setFullNameLengthErr("Full name requires input from 2 to 50 characters!");
            }
            
            if (foundErr) {
                request.setAttribute("CREATE_ERROR", errors);
            } else {
                // 2. Call DAO
                AccountInfoDAO dao = new AccountInfoDAO();
                boolean result = dao.createNewAccount(username, password, fullname, false);
                if (result) {
                    url = LOGIN_PAGE;
                } 
//                else {
//                    throw new SQLException("Duplicate username");
//                }
            }
            
        } catch (SQLException ex) {
            String errMsg = ex.getMessage();
            
            log("CreateNewAccountServlet SQL: " + errMsg);
            if (errMsg.contains("duplicate")) {
                errors.setUsernameIsExisted(username + " is existed");
                request.setAttribute("CREATE_ERROR", errors);
            }
            
        } catch (NamingException ex) {
            log("CreateNewAccountServlet Naming: " + ex.getMessage());
        }
        finally {
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
