<%-- 
    Document   : insert
    Created on : Apr 23, 2021, 9:39:56 PM
    Author     : hd
    Your code here. Do not delete this comment
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert New Food</title>
    </head>
    <body>
        <h1>Insert new Food</h1>
        <a href="product.jsp">Search</a>
        <c:set var="insertError" value="${requestScope.INSERT_ERROR}" />
        <form action="MainController">
            ID: <input type="text" name="id" value="${param.id}" />
            <br/>
            <c:if test="${not empty insertError.idError}">
                <font color="red">
                    ${insertError.idError}
                </font><br/>
            </c:if>
            Name: <input type="text" name="name" value="${param.name}" />
            <br/>
            <c:if test="${not empty insertError.nameError}">
                <font color="red">
                    ${insertError.nameError}
                </font><br/>
            </c:if>
            Description: <textarea name="description" rows="4">${param.description}</textarea>
            <br/>
            <c:if test="${not empty insertError.descriptionError}">
                <font color="red">
                    ${insertError.descriptionError}
                </font><br/>
            </c:if>
            Price: <input type="text" name="price" value="${param.price}" />
            <br/>
            <c:if test="${not empty insertError.priceError}">
                <font color="red">
                    ${insertError.priceError}
                </font><br/>
            </c:if>
            Cooking Time: <input type="text" name="cookingTime" value="${param.cookingTime}" />
            <br/>
            <c:if test="${not empty insertError.cookingTimeError}">
                <font color="red">
                    ${insertError.cookingTimeError}
                </font><br/>
            </c:if>
            <input type="submit" value="Insert" name="action" />
            <br/>
            <c:if test="${not empty requestScope.INSERT_SUCCESS}">
                <font color="green">
                ${requestScope.INSERT_SUCCESS}
                </font>
            </c:if>
            <c:if test="${not empty requestScope.ERROR}">
                <font color="red">
                ${requestScope.ERROR}
                </font>
            </c:if>
        </form>
    </body>
</html>
