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
import phongnt.accountInfo.AccountInfoDAO;
import phongnt.accountInfo.AccountInfoLoginError;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class LoginServlet extends HttpServlet {

    private final String LOGIN_PAGE = "login";
    private final String SEARCH_PAGE = "search";
    private final String SHOPPING_PAGE = "Shop";
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
        
        String button = request.getParameter("btnAction");
        
        String url = LOGIN_PAGE;
        
        AccountInfoLoginError errors = new AccountInfoLoginError();
        boolean isError = false;
        
        try {
            if (button != null) {
                String username = request.getParameter("txtUsername");
                String password = request.getParameter("txtPassword");
                String redirect = request.getParameter("redirect");
                
                AccountInfoDAO dao = new AccountInfoDAO();
                
                boolean isLogin = dao.checkLogin(username, password);
                
                if (isLogin) {
                    
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    session.setAttribute("lastname", dao.getLastName(username));
                    int isAdmin = dao.isAdmin(username);
                    
                    session.setAttribute("isAdmin", isAdmin);

                    if (redirect.isEmpty()) {
                        switch (isAdmin) {
                            case 0:
                                url = SHOPPING_PAGE;
                                break;
                            case 1:
                                url = SEARCH_PAGE;
                                break;
                            default:
                                errors.setErrorMsg("Something went wrong... Please try again");
                                isError = true;
                                break;
                        }
                        
                    } else {
                        url = redirect;
                    }
                } else {
                    errors.setErrorMsg("Wrong username or password! Please check again...");
                    isError = true;
                }
            }
        } catch (SQLException ex) {
            log("LoginServlet SQL: " + ex.getCause());
            errors.setErrorMsg("An error has occured during your login... Please contact the web owner for more details!!!");
            isError =  true;
        } catch (NamingException ex) {
            log("LoginServlet Naming: " + ex.getCause());
            errors.setErrorMsg("An error has occured during your login... Please contact the web owner for more details!!!");
            isError =  true;
        }
        finally {
            
            if (isError) {
                request.setAttribute("LOGIN_ERROR", errors);
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
