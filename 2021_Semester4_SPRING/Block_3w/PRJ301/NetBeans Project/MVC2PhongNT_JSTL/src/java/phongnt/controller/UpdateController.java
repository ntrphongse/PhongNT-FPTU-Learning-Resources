/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phongnt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phongnt.user.UserDAO;
import phongnt.user.UserDTO;
import phongnt.user.UserErrorDTO;

/**
 *
 * @author Tran Phong <phongntse150974@fpt.edu.vn>
 */
public class UpdateController extends HttpServlet {
    
    private static final String ERROR = "update.jsp";
    private static final String SUCCESS = "MainController";

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
        UserErrorDTO userError = new UserErrorDTO("", "", "", "", "", "");
        try {
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String roleID = request.getParameter("roleID");
            String oldPassword = request.getParameter("oldPassword");
            String newPassword = request.getParameter("newPassword");
            String confirm = request.getParameter("confirm");
            String search = request.getParameter("search");
            
            
            if (userID.length() < 3 || userID.length() > 10) {
                userError.setUserIDError("User ID must be from 3 to 10 charaters!!");
                check = true;
            }
            if (fullName.length() < 5 || fullName.length() > 50) {
                userError.setFullNameError("Full name must be from 5 to 50 charaters!!");
                check = true;
            }
            if (roleID.length() < 2 || roleID.length() > 10) {
                userError.setRoleIDError("Role ID must be from 2 to 10 charaters!!");
                check = true;
            }
            
            UserDAO dao = new UserDAO();
            
            boolean checkPassword = dao.checkPassword(userID, oldPassword);
            
            if (!checkPassword) {
                userError.setPasswordError("Wrong Old Password!!");
                check = true;
            }
            else {
            if (!newPassword.equals(confirm)) {
                userError.setConfirmError("Confirm is not matched!!");
                check = true;
            }

            }
            if (check) {
                request.setAttribute("ERROR", userError);
            } else {
                UserDTO user = new UserDTO(userID, newPassword, fullName, roleID);
                dao.update(user);
                
                HttpSession session = request.getSession();
                UserDTO curUser = (UserDTO) session.getAttribute("LOGIN_USER");
                if (userID.trim().equals(curUser.getUserID().trim())) {
                    curUser.setFullName(fullName);
                    curUser.setRoleID(roleID);
                }
                
                session.setAttribute("LOGIN_USER", curUser);
                 
                url = SUCCESS + "?action=Search&search=" + search;
            }
            
        } catch (Exception e) {
            log("Error at UpdateController: " + e.toString());
            if (e.toString().contains("duplicate")) {
                userError.setUserIDError("Duplicate User ID!!");
                request.setAttribute("ERROR", userError);
            }
        }
        finally {
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
