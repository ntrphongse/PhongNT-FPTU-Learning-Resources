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
import phongnt.accountInfo.AccountInfoCreateError;
import phongnt.accountInfo.AccountInfoDAO;


/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class CreateNewAccountServlet extends HttpServlet {

//    private final String CREATE_NEW_ACCOUNT_PAGE = "signup";
    private final String CREATE_NEW_ACCOUNT_ERROR = "signupError";
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
        
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String fullname = request.getParameter("txtFullname");
        
        String url = CREATE_NEW_ACCOUNT_ERROR;
        
        AccountInfoCreateError errors = new AccountInfoCreateError();
        boolean isError = false;
        
        try {
            if (username.trim().length() < 6 || username.trim().length() > 30) {
                isError = true;
                errors.setUsernameLengthErr("Username requires input from "
                        + "6 to 30 characters!!");
            }
            
            if (password.trim().length() < 6 || password.trim().length() > 20) {
                isError = true;
                errors.setPasswordLengthErr("Password requires input from "
                        + "6 to 20 characters!!");
            } else if (!(password.trim().equals(confirm.trim()))) {
                isError = true;
                errors.setConfirmNotMatchErr("Confirm doesn't match with the "
                        + "entered Password!!!");
            }
            
            if (fullname.trim().length() < 2 || fullname.trim().length() > 50) {
                isError = true;
                errors.setLastnameLengthErr("Full name requires input from "
                        + "2 to 50 characters!!");
                
            }

            
            if (isError) {
                request.setAttribute("CREATE_ERROR", errors);
            } else {
                // Create Account
                AccountInfoDAO dao = new AccountInfoDAO();
                boolean result = dao.createAccount(username, password, 
                                    fullname, false);
                if (result) {
                    url = LOGIN_PAGE;
                }
            }
        } catch (SQLException ex) {
            String errorMsg = ex.getMessage();
            log("CreateNewAccountServlet SQL: " + errorMsg);
            
            if (errorMsg.contains("duplicate")) {
                errors.setUsernameExistedErr("The username '" + username + 
                        "' is existed!!!");
            } else {
                errors.setErrorMsg("An error has occured during your sign up... Please contact the web owner for more details!!!");
            }
            request.setAttribute("CREATE_ERROR", errors);
        } catch (NamingException ex) {
            log("CreateNewAccountServlet Naming: " + ex.getMessage());
            errors.setErrorMsg("An error has occured during your sign up... Please contact the web owner for more details!!!");
            request.setAttribute("CREATE_ERROR", errors);
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
