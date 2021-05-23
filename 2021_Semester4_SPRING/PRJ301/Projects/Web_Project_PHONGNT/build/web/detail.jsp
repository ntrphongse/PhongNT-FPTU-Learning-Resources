<%-- 
    Document   : detail
    Created on : Mar 17, 2021, 9:40:50 PM
    Author     : Tran Phong <phongntse150974@fpt.edu.vn>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>    
    <c:set var="errors" value="${requestScope.DETAIL_ERROR}" />
    
    <c:set var="book" value="${requestScope.PRODUCT_DETAIL}" />
    
    <c:if test="${empty book or not empty errors.numberFormatErr}">
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>View Detail - Error</title>
        </head>
        <body>
            <c:if test="${not empty sessionScope.username}">
                <%@include file="welcome.jsp" %>
            </c:if>

            <h1>Tran Phong Book Store</h1>
            <h2>No such a book was found...</h2><br/>
            <a href="shop">Click here to view our Book store...</a>
        </body>
    </c:if>
        
    <c:if test="${not empty book}" >
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>View Detail - ${book.title}</title>
        </head>
        <body>
            <jsp:include flush="true" page="welcome.jsp">
                <jsp:param name="page" value="Detail?bookId=${book.id}" />
            </jsp:include>

            <h1>Tran Phong Book Store</h1>
<!--            <a href="Shop">← Go back to our Store</a><br/>-->
            <h2>${book.title}</h2>

            <ul>
                <li>Publish Year: ${book.publishYear}</li>
                <f:formatNumber var="price" 
                                value="${book.price}" 
                                minIntegerDigits="0" />
                <li>Price: ${price}</li>
                
            </ul>
            <br/>
            <form action="addToCart">
                <input type="hidden" name="bookId" value="${book.id}" />
                <c:if test="${not empty param.quantity}">
                    <c:set var="quantity" value="${param.quantity}" />
                </c:if>
                <c:if test="${empty param.quantity}">
                    <c:set var="quantity" value="1" />
                </c:if>
                Quantity: <input type="text" name="quantity" 
                                 value="${quantity}" /> 
                <c:set var="addError" value="${requestScope.ADD_ERROR}" />
                <c:if test="${not empty addError.numberFormatErr}">
                    <br/>
                    <font color="red">
                        ${addError.numberFormatErr}
                    </font>
                </c:if>
                <input type="submit" value="Add to Cart" name="btnAction"/>
            </form>
            <c:set var="success" value="${param.add}" />
            <c:if test="${success eq 'success'}">
                <font color="green">
                    Add to Cart successfully!!
                </font>
            </c:if>
            <br/>
<!--            <a href="viewcart">View your Cart</a>-->

        </body>
    </c:if>
    
</html>
