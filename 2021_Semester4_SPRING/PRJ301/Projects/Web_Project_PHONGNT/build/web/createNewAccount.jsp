<%-- 
    Document   : createNewAccount
    Created on : Mar 17, 2021, 7:31:54 PM
    Author     : Tran Phong <phongntse150974@fpt.edu.vn>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create a New Account</title>
    </head>
    <body>
        <%@include file="welcome.jsp" %>
        <h1>Create a New Account</h1>
        <form action="Signup" method="POST">
            <c:set var="errors" value="${requestScope.CREATE_ERROR}" />
            Username* <input type="text" name="txtUsername" 
                             value="${param.txtUsername}" /> (6 - 30 chars) <br/>
            <c:if test="${not empty errors.usernameLengthErr}">
                <font color='red'>
                    ${errors.usernameLengthErr}
                </font><br/>
            </c:if>
            Password* <input type="password" name="txtPassword" 
                             value="" /> (6 - 20 chars) <br/>
            <c:if test="${not empty errors.passwordLengthErr}">
                <font color='red'>
                    ${errors.passwordLengthErr}
                </font><br/>
            </c:if>
            Confirm* <input type="password" name="txtConfirm" value="" /> <br/>
            <c:if test="${not empty errors.confirmNotMatchErr}">
                <font color='red'>
                    ${errors.confirmNotMatchErr}
                </font><br/>
            </c:if>
            Full name* <input type="text" name="txtFullname" 
                              value="${param.txtFullname}" /> (2 - 50 chars) <br/>
            <c:if test="${not empty errors.lastnameLengthErr}">
                <font color='red'>
                    ${errors.lastnameLengthErr}
                </font><br/>
            </c:if>
            <input type="submit" value="Create New Account" name="btnAction" /> 
            <input type="reset" value="Reset" />
            <br/>
            <c:if test="${not empty errors.usernameExistedErr}">
                <font color='red'>
                    ${errors.usernameExistedErr}
                </font><br/>
            </c:if>
            <c:if test="${not empty errors.errorMsg}">
                <font color='red'>
                    ${errors.errorMsg}
                </font><br/>
            </c:if>
            
        </form>
        <br/>
        Already have an account? <a href="login">Click here to Login</a>
    </body>
</html>
