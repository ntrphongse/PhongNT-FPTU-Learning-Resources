<%-- 
    Document   : viewCart
    Created on : Mar 20, 2021, 5:37:00 PM
    Author     : Tran Phong <phongntse150974@fpt.edu.vn>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View your Cart</title>
    </head>
    <body>
        <jsp:include flush="true" page="welcome.jsp">
            <jsp:param name="page" value="viewcart" />
        </jsp:include>
        
        <h1>Your Cart includes</h1>
        <c:set var="cart" value="${sessionScope.CART.cart}" />
        <c:if test="${empty cart}">
            <h2>No items in cart...</h2>
            <a href="Shop">Click here to start shopping...</a>
        </c:if>
        <c:if test="${not empty cart}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Title</th>
                            <th>Publish Year</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Items total</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="orderTotal" value="${0}" />
                        <form action="removeFromCart">
                            <c:forEach var="cartItem" items="${cart}" varStatus="iCount">
                                <c:set var="bookId" value="${cartItem.key}" />
                                <c:set var="quantity" value="${cartItem.value}" />
                                <jsp:useBean id="bookDAO" scope="page" 
                                        class="phongnt.productInfo.ProductInfoDAO" 
                                        type="phongnt.productInfo.ProductInfoDAO" />
                                <c:set var="book" value="${bookDAO.getProduct(bookId)}" />
                                
                                <tr>
                                    <td>
                                        ${iCount.count}
                                    .</td>
                                    <td>
                                        ${book.title}
                                    </td>
                                    <td>
                                        ${book.publishYear}
                                    </td>
                                    <td>
                                        <f:formatNumber var="price" 
                                                        value="${book.price}" 
                                                        minIntegerDigits="0" />
                                        ${price}
                                    </td>
                                    <td>
                                        ${quantity}
                                    </td>
                                    <td>
                                        <f:formatNumber var="itemTotal" 
                                                        value="${book.price * quantity}" 
                                                        minIntegerDigits="0" />
                                        <c:set var="orderTotal" 
                                               value="${orderTotal + book.price * quantity}" />
                                        ${itemTotal}
                                    </td>
                                    <td>
                                        <input type="checkbox" name="isRemove" 
                                               value="${book.id}" />
                                    </td>
                                </tr>
                            </c:forEach>
                                <tr>
                                    <td colspan="5">
                                        Order Total:
                                    </td>
                                    <td>
                                         <f:formatNumber var="strOrderTotal" 
                                                    value="${orderTotal}" 
                                                    minIntegerDigits="0" />
                                        ${strOrderTotal}
                                    </td>
                                    <td>
                                        <input type="submit" value="Remove" name="btnAction" />
                                    </td>
                                </tr>
                        </form>
                    </tbody>
                </table>
            <br/>
            <a href="checkout">Check Out now</a>
            
        </c:if>
            
    </body>
</html>
