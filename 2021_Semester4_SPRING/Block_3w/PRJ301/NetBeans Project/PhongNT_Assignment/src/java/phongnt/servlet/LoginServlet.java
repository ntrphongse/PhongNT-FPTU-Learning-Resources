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
import phongnt.tblUsers.TblUsersLoginError;

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
        
        TblUsersLoginError errors = new TblUsersLoginError();
        boolean isError = false;
        
        try {
            if (button != null) {
                String userID = request.getParameter("userID");
                String password = request.getParameter("password");
                String redirect = request.getParameter("redirect");
                
                TblUsersDAO dao = new TblUsersDAO();
                
                boolean isLogin = dao.checkLogin(userID, password);
                
                if (isLogin) {
                    int isAdmin = dao.isAdmin(userID);
                    HttpSession session = request.getSession();
//                    session.setAttribute("userID", userID);
//                    session.setAttribute("fullName", dao.getFullName(userID));
                    session.setAttribute("LOGIN_USER", new TblUsersDTO(
                            userID, 
                            "", 
                            dao.getFullName(userID), 
                            isAdmin == 1, 
                            "", 
                            dao.getAddress(userID))
                    );
                    
//                    // Cookies
//                    Cookie userIDCookie = new Cookie("userID", userID);
//                    Cookie passwordCookie = new Cookie("password", password);
//                    response.addCookie(userIDCookie);
//                    response.addCookie(passwordCookie);

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
            log("LoginServlet SQL: " + ex.getMessage());
            errors.setErrorMsg("An error has occured during your login... Please contact the web owner for more details!!!");
            isError =  true;
        } catch (NamingException ex) {
            log("LoginServlet Naming: " + ex.getMessage());
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
