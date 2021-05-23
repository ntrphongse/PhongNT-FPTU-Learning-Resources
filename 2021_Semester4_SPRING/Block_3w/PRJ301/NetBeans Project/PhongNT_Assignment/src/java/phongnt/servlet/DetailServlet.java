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
import phongnt.tblProducts.TblProductsDAO;
import phongnt.tblProducts.TblProductsDTO;
import phongnt.tblProducts.TblProductsDetailError;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class DetailServlet extends HttpServlet {
    
    private final String BOOK_STORE_PAGE = "Shop";
    private final String DETAIL_PAGE = "detail";

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
        
        String strId = request.getParameter("id");
        String url = DETAIL_PAGE;
        
        TblProductsDetailError errors = new TblProductsDetailError();
        
        try {
            if (strId != null) {
                int id = Integer.parseInt(strId);
                TblProductsDAO dao = new TblProductsDAO();
                TblProductsDTO result = dao.getProduct(id);

                request.setAttribute("PRODUCT_DETAIL", result);
                url = DETAIL_PAGE;
            }
            
        } catch (NumberFormatException ex) {
            log("DetailServlet NumberFormat: " + ex.getMessage());
            errors.setNumberFormatErr(ex.getMessage());
            request.setAttribute("DETAIL_ERROR", errors);
            url = DETAIL_PAGE;
        } catch (SQLException ex) {
            log("Detail SQL: " + ex.getMessage());
            errors.setErrorMsg("An error has occured during your shopping... Please contact the web owner for more details!!!");
            request.setAttribute("STORE_ERROR", errors);
        } catch (NamingException ex) {
            log("Detail Naming: " + ex.getMessage());
            errors.setErrorMsg("An error has occured during your shopping... Please contact the web owner for more details!!!");
            request.setAttribute("STORE_ERROR", errors);
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
