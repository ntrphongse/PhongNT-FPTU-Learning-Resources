<%-- 
    Document   : update
    Created on : Apr 22, 2021, 9:39:11 AM
    Author     : Tran Phong <phongntse150974@fpt.edu.vn>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Update Page</title>
    </head>

    <c:set var="loginUser" value="${sessionScope.LOGIN_USER}" />
    <c:if test="${empty loginUser}">
        <c:redirect url="login.html"/>            
    </c:if>

    <c:if test="${loginUser.roleID ne 'AD'}">
        <c:redirect url="login.html"/>            
    </c:if>

    <c:if test="${empty param.userID or empty param.fullName or empty param.roleID}">
        <c:redirect url="MainController">
            <c:param name="action" value="Search" />
            <c:param name="search" value="${param.search}"/>
        </c:redirect> 
    </c:if>
    <body>
        <h1>Update Information</h1>
        <form action="MainController" method="POST">
            User ID: <input readonly="" type="text" name="userID" value="${param.userID}" /><br/>
            ${requestScope.ERROR.userIDError}<br/>
            Full name: <input required="" type="text" name="fullName" value="${param.fullName}" /><br/>
            ${requestScope.ERROR.fullNameError}<br/>
            Role ID: <input required="" type="text" name="roleID" value="${param.roleID}" /><br/>
            ${requestScope.ERROR.roleIDError}<br/>
            Old Password: <input required="" type="password" name="oldPassword" value="" /><br/>
            ${requestScope.ERROR.passwordError}<br/>
            New Password: <input required="" type="password" name="newPassword" value="" /><br/>
            ${requestScope.ERROR.newPasswordError}<br/>
            Confirm: <input required="" type="password" name="confirm" value="" /><br/>
            ${requestScope.ERROR.confirmError}<br/>
            <input type="hidden" name="search" value="${param.search}" />
            <input type="submit" value="Confirm" name="action" />
            <input type="reset" value="Reset" />

        </form>
    </body>
</html>
