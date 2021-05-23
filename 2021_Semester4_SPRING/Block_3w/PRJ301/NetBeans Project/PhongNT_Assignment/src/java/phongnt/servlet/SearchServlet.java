/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phongnt.tblUsers.TblUsersDAO;
import phongnt.tblUsers.TblUsersDTO;
import phongnt.tblUsers.TblUsersSearchError;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class SearchServlet extends HttpServlet {

    private final String SEARCH_PAGE = "search";

    // No button or parameter => search => search.jsp => login
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

        String url = SEARCH_PAGE;

        TblUsersSearchError errors = new TblUsersSearchError();
//        boolean isError = false;

        try {
            String searchValue = request.getParameter("searchValue");
            searchValue = searchValue.trim();
            if (searchValue.length() > 0) {
                TblUsersDAO dao = new TblUsersDAO();
                dao.searchByFullName(searchValue);
                ArrayList<TblUsersDTO> searchResult = dao.getAccountList();
                request.setAttribute("SEARCH_RESULT", searchResult);
            }

        } catch (SQLException ex) {
            log("SearchServlet SQL: " + ex.getMessage());
            errors.setErrorMsg("An error has occured during your search... Please contact the web owner for more details!!!");
            request.setAttribute("SEARCH_ERROR", errors);
        } catch (NamingException ex) {
            log("SearchServlet Naming: " + ex.getMessage());
            errors.setErrorMsg("An error has occured during your search... Please contact the web owner for more details!!!");
            request.setAttribute("SEARCH_ERROR", errors);
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
