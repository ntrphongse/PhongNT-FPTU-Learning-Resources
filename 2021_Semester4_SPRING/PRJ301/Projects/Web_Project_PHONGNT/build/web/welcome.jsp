<%-- 
    Document   : welcome
    Created on : Mar 20, 2021, 5:03:14 PM
    Author     : Tran Phong <phongntse150974@fpt.edu.vn>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:set var="iPage" value="${param.page}" />

<c:if test="${not empty sessionScope.username}">
    <font color="red">
        Welcome, ${sessionScope.lastname}
    </font><br/><br/>
    <a href="Logout">Log Out</a> |
    <c:if test="${sessionScope.isAdmin eq 1}">
        <a href="search">Search Account</a> |
    </c:if>
</c:if>
        
<a href="Shop">Buy Books</a> |
<a href="viewcart">View Your Cart</a> |

<c:if test="${empty sessionScope.username}">
    <a href="login?redirect=${iPage}">Log In</a> |
    <a href="signup">Sign Up</a> 
</c:if>

            
            
