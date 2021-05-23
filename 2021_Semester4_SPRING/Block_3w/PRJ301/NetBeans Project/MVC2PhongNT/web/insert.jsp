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
        
        <form action="MainController" method="POST">
            User ID: <input type="text" name="userID" value="" required=""/><br/>
            ${requestScope.ERROR_USER.userIDError} <br/>
            Full Name: <input type="text" name="fullname" value="" required=""/><br/>
            ${requestScope.ERROR_USER.fullNameError} <br/>
            Role ID: <input type="text" name="roleID" value="" required=""/><br/>
            ${requestScope.ERROR_USER.roleIDError} <br/>
            Password: <input type="password" name="password" value="" required=""/><br/>
            Confirm: <input type="password" name="confirm" value="" required="" /><br/>
            ${requestScope.ERROR_USER.confirmError} <br/>
            <input type="submit" value="Insert" name="action" />
            <input type="reset" value="Reset" />

        </form>
    </body>
</html>
