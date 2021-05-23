<%-- 
    Document   : login
    Created on : Mar 15, 2021, 9:54:37 PM
    Author     : Tran Phong <phongntse150974@fpt.edu.vn>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%@include file="welcome.jsp" %>
        <h1>Login</h1>
        <form action="Login" method="POST">
            Username: <input type="text" name="txtUsername" 
                             value="${param.txtUsername}" /> <br/> <br/>
            Password: <input type="password" name="txtPassword" value="" /> <br/> <br/>
            <input type="hidden" name="redirect" value="${param.redirect}" />
            <input type="submit" value="Login" name="btnAction" /> 
            <input type="reset" value="Reset" />
            <br/><br/>
            <c:if test="${not empty requestScope.LOGIN_ERROR.errorMsg}">
                <font color='red'>
                    ${requestScope.LOGIN_ERROR.errorMsg}
                </font>
            </c:if>
        </form>
            <a href="signup">Don't have an Account? Create a new one here</a>
    </body>
</html>