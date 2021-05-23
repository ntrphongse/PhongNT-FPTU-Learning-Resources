<%-- 
    Document   : Login
    Created on : Mar 8, 2021, 9:50:46 PM
    Author     : Trần Phong <phongntse150974@fpt.edu.vn>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Login</h1>
        <form name="loginForm" action="login" method="POST">
            <input type="hidden" name="redirect" value="<%= (request.getParameter("redirect")) %>" />
            Username: <input type="text" name="txtUsername" value="" /> <br/>
            Password: <input type="password" name="txtPassword" value="" /> <br/>
            <input type="submit" value="Login" name="btnAction" />
            <input type="reset" value="Reset" name="btnReset" />
        </form> </br>
        <a href="bookStore.jsp">Buy Book here</a><br/>
        <a href="createNewAccount.html">No Account? Click here to register</a>
    </body>
</html>
