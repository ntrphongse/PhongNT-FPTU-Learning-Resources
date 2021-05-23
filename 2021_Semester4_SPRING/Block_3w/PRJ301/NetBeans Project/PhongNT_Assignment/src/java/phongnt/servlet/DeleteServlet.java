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
import phongnt.tblUsers.TblUsersDeleteError;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class DeleteServlet extends HttpServlet {
    
    private final String SEARCH_SERVLET = "Search";
    private final String SEARCH_PAGE = "search";
//    private final String ERROR_PAGE = "deleteError";
    private final String ERROR_PAGE = "search";

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
        
        String userID = request.getParameter("userID");
        String lastSearchValue = request.getParameter("lastSearchValue");
        
        String url = ERROR_PAGE; // Default is Error
        
        TblUsersDeleteError errors = new TblUsersDeleteError();
        boolean isError = false;
        
        try {
            if (!(userID.trim().isEmpty() || 
                    lastSearchValue.trim().isEmpty())) {
                // The true link from Search is clicked
                
                HttpSession session = request.getSession();
                String curUserID = ((TblUsersDTO) session.getAttribute("LOGIN_USER")).getUserID();
                if (curUserID != null && userID.trim().equals(curUserID.trim())) {
                    errors.setErrorMsg("You can not delete yourself!!! ");
                    isError = true;
                } else {
                    TblUsersDAO dao = new TblUsersDAO();
                    boolean result = dao.deleteAccount(userID);

                    if (result) {
                        // Delete successfully
//                        url = SEARCH_SERVLET + "?searchValue=" + lastSearchValue;
                        request.setAttribute("DELETE_SUCCESS", true);
                    } else {
                        errors.setErrorMsg("Can not delete the account with "
                                + "the userID '" + userID + "'!!!!");
                        isError = true;
                    }
                }
            }
        } catch (SQLException ex) {
            log("DeleteServlet SQL: " + ex.getMessage());
            errors.setErrorMsg("An error has occured during your delete... Please contact the web owner for more details!!!");
            isError = true;
            
        } catch (NamingException ex) {
            log("DeleteServlet Naming: " + ex.getMessage());
            errors.setErrorMsg("An error has occured during your delete... Please contact the web owner for more details!!!");
            isError = true;
        }
        finally {
            url = SEARCH_SERVLET + "?searchValue=" + lastSearchValue;
            request.setAttribute("DELETE_ERROR", errors);
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
