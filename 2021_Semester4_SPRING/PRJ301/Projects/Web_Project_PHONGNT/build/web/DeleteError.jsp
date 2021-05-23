<%-- 
    Document   : DeleteError
    Created on : Mar 16, 2021, 6:37:39 PM
    Author     : Tran Phong <phongntse150974@fpt.edu.vn>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Error</title>
    </head>
    <body>
        <h1>
            <c:set var="errors" value="${requestScope.DELETE_ERROR}" />
            <font color='red'>
                ${errors.errorMsg}
            </font>
            <br/>
            
        </h1>
        <c:url var="searchUrl" 
               value="Search">
            <c:param name="txtSearchValue" value="${param.lastSearchValue}" />
        </c:url>
        <a href="${searchUrl}">Click here to return to your Search</a>
    </body>
</html>
