<%-- 
    Document   : index
    Created on : Apr 13, 2021, 9:20:37 AM
    Author     : Tran Phong <phongntse150974@fpt.edu.vn>
--%>

<%@page import="java.util.List"%>
<%@page import="phongnt.dtos.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !"admin".equals(loginUser.getRoleID())) {
                %>
                <jsp:forward page="login.html" />
        <%
            }
            String searchValue = request.getParameter("searchValue");
            if (searchValue == null) {
                searchValue = "";
            }

        %>
        <h1>Welcome: <%= loginUser.getFullname()%></h1> <br/>
        <form action="MainController">
            <input type="submit" value="Log Out" name="action" />
        </form>
        
        <a href="shopping.jsp">Shopping</a>

        <form action="MainController">
            Search: <input type="text" name="searchValue" value="" /> <br/>
            <input type="submit" value="Search" name="action" />
        </form>

        <%
            if (request.getParameter("searchValue") != null) {
                List<UserDTO> list = (List<UserDTO>) request.getAttribute("LIST_USER");
                if (list != null && !list.isEmpty()) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>User ID</th>
                    <th>Full Name</th>
                    <th>Role ID</th>
                    <th>Password</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (UserDTO user : list) {
                %>
            <form action="MainController">
            
                <tr>
                    <td>
                        <%= ++count%>
                    </td>
                    <td>
                        <input type="text" name="userID" 
                               value="<%= user.getUserID()%>" 
                               readonly=""/>
                        
                    </td>
                    <td>
                        <input type="text" name="fullName" 
                               value="<%= user.getFullname()%>" />
                        
                    </td>
                    <td>
                        <input type="text" name="roleID" 
                               value="<%= user.getRoleID()%>" />
                        
                    </td>
                    <td>
                        <%= user.getPassword()%>
                    </td>
                    <td>
                        <a href="MainController?action=Delete&userID=<%= user.getUserID() %>&lastSearch=<%= searchValue %>">
                            Delete
                        </a>
                    </td>
                    <td>
                        <input type="hidden" name="lastSearch" 
                               value="<%= searchValue %>" />
                        <input type="submit" value="Update" name="action" />
                    </td>
                </tr>  
                </form>
                <%
                    }

                %>

            </tbody>
        </table>

        <%            } else {
        %>
        <h2>No record found!!!</h2>
        <%
                }
            }
        %>

    </body>
</html>
