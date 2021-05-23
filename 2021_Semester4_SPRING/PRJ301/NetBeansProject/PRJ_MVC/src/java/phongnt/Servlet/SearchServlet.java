/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phongnt.accountInfo.AccountInfoDAO;
import phongnt.accountInfo.AccountInfoDTO;

/**
 *
 * @author Trần Phong <phongntse150974@fpt.edu.vn>
 */
public class SearchServlet extends HttpServlet {

//    private final String SEARCH_PAGE = "search.html";
    private final String SEARCH_PAGE = "SearchJSP.jsp";
    private final String SEARCH_RESULT_PAGE = "SearchJSP.jsp";
    
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
        String searchValue = request.getParameter("txtSearch");
        try {
            if (searchValue.trim().length() > 0) {
                AccountInfoDAO dao = new AccountInfoDAO();
                dao.searchLastname(searchValue);
                
                List<AccountInfoDTO> result = dao.getAccountList();
                request.setAttribute("SEARCH_RESULT", result);
                url = SEARCH_RESULT_PAGE;
            } // End if searchValue has value
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
