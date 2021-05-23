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
import phongnt.tblUsers.TblUsersUpdateError;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class UpdateServlet extends HttpServlet {

    private final String SEARCH_SERVLET = "Search";
    private final String SEARCH_PAGE = "search";
//    private final String ERROR_PAGE = "updateError";
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

        String userID = request.getParameter("userID").trim();
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName").trim();
        String phone = request.getParameter("phone");
        String address = request.getParameter("address").trim();
        String admin = request.getParameter("isAdmin");
        String lastSearchValue = request.getParameter("lastSearchValue").trim();

        String url = ERROR_PAGE;

        boolean isError = false;
        TblUsersUpdateError errors = new TblUsersUpdateError();

        try {
            if (!(userID.isEmpty()
                    || lastSearchValue.isEmpty())) {
                // The true link is click
                if (password.length() < 6 || password.length() > 50) {
                    errors.setPasswordLengthErr("Password requires input from 6 "
                            + "to 50 characters!");
                    isError = true;
                }
                if (fullName.length() < 2 || fullName.length() > 50) {
                    errors.setFullNameLengthErr("Full name requires input from 2 "
                            + "to 50 characters!!");
                    isError = true;
                }
                if (!phone.matches("^0(([0-9]){9})")) {
                    errors.setPhoneError("Wrong Phone Number!!");
                    isError = true;
                }
                if (address.length() < 6 || address.length() > 255) {
                    errors.setAdressLengthErr("Address requires input from 6 "
                            + "to 255 characters!");
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
                    TblUsersDAO dao = new TblUsersDAO();
                    boolean result = dao.updateAccount(userID,
                            password, fullName, phone, address, isAdmin);
                    if (result) {
                        // Update successfully
//                        url = SEARCH_SERVLET + 
//                                "?txtSearchValue=" + lastSearchValue;
                        request.setAttribute("UPDATE_SUCCESS", true);
                        HttpSession session = request.getSession();
                        String curUserID = ((TblUsersDTO) session.getAttribute("LOGIN_USER")).getUserID();
                        if (userID.equals(curUserID)) {
                            // Update Session fullname
                            TblUsersDTO newUser = new TblUsersDTO(userID, "", fullName, isAdmin, "", "");

                            session.setAttribute("LOGIN_USER", newUser);
                        }

                    } else {
                        errors.setCannotUpdateErr("Cannot update the account '"
                                + userID + "' !!!");
                    }
                }
            }
        } catch (SQLException ex) {
            log("UpdateServlet SQL: " + ex.getMessage());
            errors.setErrorMsg("An error has occured during your search... Please contact the web owner for more details!!!");

        } catch (NamingException ex) {
            log("UpdateServlet Naming: " + ex.getMessage());
            errors.setErrorMsg("An error has occured during your search... Please contact the web owner for more details!!!");
            request.setAttribute("UPDATE_ERROR", errors);
        } finally {

            url = SEARCH_SERVLET + "?searchValue=" + lastSearchValue;
            request.setAttribute("UPDATE_ERROR", errors);
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
