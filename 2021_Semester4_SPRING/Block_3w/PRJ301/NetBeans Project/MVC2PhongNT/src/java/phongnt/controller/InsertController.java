/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phongnt.daos.UserDAO;
import phongnt.dtos.UserDTO;
import phongnt.dtos.UserErrorDTO;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class InsertController extends HttpServlet {

    private static final String ERROR = "insert.jsp";
    private static final String SUCCESS = "login.html";

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

        String url = ERROR;
        boolean check = false;
        UserErrorDTO error = new UserErrorDTO("", "", "", "", "");
        try {
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullname");
            String roleID = request.getParameter("roleID");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");

            if (userID.length() < 3 || userID.length() > 10) {
                check = true;
                error.setUserIDError("User ID must contain 3 - 10 characters!!");
            }
            if (fullName.length() < 5 || fullName.length() > 50) {
                check = true;
                error.setFullNameError("Fullname must contain 5 - 50 characters!!");
            }
            if (roleID.length() < 3 || roleID.length() > 10) {
                check = true;
                error.setRoleIDError("Role ID must contain 3 - 10 characters!!");
            }
            if (!confirm.equals(password)) {
                check = true;
                error.setConfirmError("Confirm is not matched!!!");
            }

            if (check) {
                request.setAttribute("ERROR_USER", error);
            } else {
                UserDAO dao = new UserDAO();
//                boolean checkDuplicated = dao.checkDuplicated(userID);
//                if (checkDuplicated) {
//                    error.setUserIDError("User ID is existed!!");
//                    request.setAttribute("ERROR_USER", error);
//                } else {
//                    UserDTO user = new UserDTO(userID, fullName, roleID, password);
//                    dao.insert(user);
//                    url = SUCCESS;
//                }

                UserDTO user = new UserDTO(userID, fullName, roleID, password);
                dao.insert(user);
                url = SUCCESS;
            }

        } catch (Exception e) {
            if (e.toString().contains("duplicate")) {
                log("Error at InsertController: " + e.toString());
                error.setUserIDError("User ID is existed!!");
                request.setAttribute("ERROR_USER", error);
            }

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
