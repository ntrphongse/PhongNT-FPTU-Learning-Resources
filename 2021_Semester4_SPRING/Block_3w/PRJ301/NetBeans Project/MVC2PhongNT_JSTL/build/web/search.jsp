<%-- 
    Document   : search
    Created on : Apr 22, 2021, 8:12:02 AM
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
        <title>Search Page</title>
    </head>

    <body>
        <c:set var="loginUser" value="${sessionScope.LOGIN_USER}" />
        <c:if test="${empty loginUser}">
            <c:redirect url="login.html"/>            
        </c:if>

        <c:if test="${loginUser.roleID ne 'AD'}">
            <c:redirect url="login.html"/>            
        </c:if>
        <h1>Welcome ${loginUser.fullName}</h1>
        <form action="MainController">
            <input type="submit" value="Log Out" name="action" />
        </form></br>
        <form action="MainController">
            Search: <input type="text" name="search" value="${param.search}" />
            <input type="submit" value="Search" name="action" />
        </form>
            <br/>
        <c:if test="${not empty requestScope.LIST_USER}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>User ID</th>
                        <th>Full Name</th>
                        <th>Role ID</th>
                        <th>Password</th>
                        <th>Delete</th>
                        <th>Update</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.LIST_USER}" var="user" varStatus="counter">
                    <form action="MainController" method="POST">
                    
                        <tr>
                            <td>
                                ${counter.count}
                            </td>
                            <td>
                                ${user.userID}
                            </td>
                            <td>
                                ${user.fullName}
                            </td>
                            <td>
                                ${user.roleID}
                            </td>
                            <td>
                                ${user.password}
                            </td>
                            <td>
                                <c:url value="MainController" var="delete">
                                    <c:param name="action" value="Delete" />
                                    <c:param name="userID" value="${user.userID}" />
                                    <c:param name="search" value="${param.search}" />
                                </c:url>
                                <a href="${delete}">Delete</a>
                            </td>
                            <td>
                                <input type="hidden" name="userID" value="${user.userID}" />
                                <input type="hidden" name="fullName" value="${user.fullName}" />
                                <input type="hidden" name="roleID" value="${user.roleID}" />
                                <input type="hidden" name="search" value="${param.search}" />
                                
                                <input type="submit" value="Update" name="action" />
                                
                            </td>
                        </tr>
                    </form>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>
        <c:set var="error" value="${requestScope.DELETE_ERROR}"/>
        <c:if test="${not empty error}">
            <font color="red">
                ${error}
            </font>
        </c:if>
    </body>
</html>
