<%-- 
    Document   : index
    Created on : Apr 23, 2021, 9:38:36 PM
    Author     : hd
    Hoadnt: Your code here. Do not delete this comment
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Food Management</title>
    </head>
    <body>
        <h1>Food Management</h1>
        <a href="insert.jsp">Insert New Food</a>
        <h2>Search Food by Cooking time</h2>
        <form action="MainController">
            Search food with the Cooking time from 
            <input type="text" name="fromTime" value="${param.fromTime}" required="" /> 
            to 
            <input type="text" name="toTime" value="${param.toTime}" required=""/>
            <br/>
            <input type="submit" value="Search" name="action" />
        </form>
        <c:set var="error" value="${requestScope.ERROR}"/>
        <c:if test="${not empty error}">
            <font color="red">
            ${error}
            </font>
        </c:if>
        <c:if test="${empty error}">

            <c:set var="searchResult" value="${requestScope.SEARCH_RESULT}"/>
            <c:if test="${empty searchResult}">
                <h3>No record found!!</h3>
            </c:if>
            <c:if test="${not empty searchResult}">
                <h3>Search Result</h3>
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Cooking Time</th>
                            <th>Description</th>
                            <th>Create Date</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${searchResult}" var="product" varStatus="iCount">
                            <tr>
                                <td>
                                    ${iCount.count}
                                </td>
                                <td>
                                    ${product.name}
                                </td>
                                <td>
                                    ${product.price}
                                </td>
                                <td>
                                    ${product.cookingTime}
                                </td>
                                <td>
                                    ${product.description}
                                </td>
                                <td>
                                    ${product.createDate}
                                </td>
                                <td>
                                    <c:url var="delete" value="MainController">
                                        <c:param name="action" value="Delete"/>
                                        <c:param name="id" value="${product.id}"/>
                                        <c:param name="fromTime" value="${param.fromTime}" />
                                        <c:param name="toTime" value="${param.toTime}" />
                                    </c:url>
                                    <a href="${delete}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </c:if>
        </c:if>
    </body>
</html>
