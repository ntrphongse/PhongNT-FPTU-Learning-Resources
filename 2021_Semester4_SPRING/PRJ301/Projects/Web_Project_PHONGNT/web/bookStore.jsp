<%-- 
    Document   : bookStore
    Created on : Mar 17, 2021, 9:04:16 PM
    Author     : Tran Phong <phongntse150974@fpt.edu.vn>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tran Phong Book Store</title>
    </head>
    <body>
        <jsp:include flush="true" page="welcome.jsp">
            <jsp:param name="page" value="Shop" />
        </jsp:include>
        
        <h1>Tran Phong Book Store</h1>
        <c:set var="errors" value="${requestScope.STORE_ERROR}" />
        <c:if test="${not empty errors.errorMsg}">
            <h2>
                <font color="red">
                    ${errors.errorMsg}
                </font><br/>
            </h2>
            <a href="/">Click here to return to home page</a>
        </c:if>
        <c:if test="${empty errors.errorMsg}">
            <c:set var="bookList" value="${requestScope.PRODUCT_LIST}" />
            
            <c:if test="${empty bookList}">
                <jsp:forward page="Shop" />
            </c:if>
            
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Title</th>
                        <th>Price</th>
                        <th>Detail</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="book" items="${bookList}" varStatus="iCount">
                        <form action="Detail">
                            <tr>
                                <td>
                                    ${iCount.count}
                                </td>
                                <td>
                                    ${book.title}
                                </td>
                                <td>
                                    <f:formatNumber var="price" value="${book.price}" 
                                                    minIntegerDigits="0" />
                                    ${price}
                                </td>
                                <td>
                                    <input type="submit" value="View Detail" name="btnAction" />
                                    <input type="hidden" name="bookId" 
                                           value="${book.id}" />
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </body>
</html>
