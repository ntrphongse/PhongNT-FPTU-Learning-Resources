<%-- 
    Document   : insert
    Created on : Apr 16, 2021, 7:20:04 AM
    Author     : Tran Phong <phongntse150974@fpt.edu.vn>
--%>

<%@page import="phongnt.dtos.UserErrorDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New User</title>
    </head>
    <body>
        <h1>Input user's Information</h1>
        <%
            UserErrorDTO error = (UserErrorDTO) request.getAttribute("ERROR_USER");
            if (error == null) {
                error = new UserErrorDTO("", "", "", "", "");
            }
        %>
        <form action="MainController" method="POST">
            User ID: <input type="text" name="userID" value="" required=""/><br/>
            <%= error.getUserIDError() %> <br/>
            Full Name: <input type="text" name="fullname" value="" required=""/><br/>
            <%= error.getFullNameError() %> <br/>
            Role ID: <input type="text" name="roleID" value="" required=""/><br/>
            <%= error.getRoleIDError()%> <br/>
            Password: <input type="password" name="password" value="" required=""/><br/>
            Confirm: <input type="password" name="confirm" value="" required="" /><br/>
            <%= error.getConfirmError()%> <br/>
            <input type="submit" value="Insert" name="action" />
            <input type="reset" value="Reset" />

        </form>
    </body>
</html>
