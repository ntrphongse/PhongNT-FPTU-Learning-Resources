<%-- 
    Document   : shopping
    Created on : Apr 19, 2021, 7:49:02 AM
    Author     : Tran Phong <phongntse150974@fpt.edu.vn>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ReTake's Milk Tea</title>
    </head>
    <body>
        <h1>Welcome to my Tea!</h1>
        <form action="MainController">
            Choose your tea: 
            <select name="cmbTea">
                <option value='T01-Matcha Tea-50'>Matcha Tea</option>
                <option value='T02-Fresh Coffee-40'>Fresh Coffee</option>
                <option value='T03-Bac Siu-20'>Bac Siu</option>
                <option value='T04-Pink Tea-90'>Pink Tea</option>
                
            </select>
            <input type="submit" value="Add" name="action" />
        </form>
        <a href='viewCart.jsp'>View Your Cart</a>
        
        <%
            String message = (String) request.getAttribute("MESSAGE");
            if (message == null) {
                message = "";
            }
        %>
        <h1><%= message %></h1>
    </body>
</html>
