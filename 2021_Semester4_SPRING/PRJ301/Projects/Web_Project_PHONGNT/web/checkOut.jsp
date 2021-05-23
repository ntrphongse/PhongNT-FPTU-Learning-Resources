<%-- 
    Document   : checkOut
    Created on : Mar 20, 2021, 6:29:39 PM
    Author     : Tran Phong <phongntse150974@fpt.edu.vn>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Out</title>
    </head>
    <body>
        <jsp:include flush="true" page="welcome.jsp">
            <jsp:param name="page" value="checkout" />
        </jsp:include>
        <c:if test="${not empty sessionScope.username}">
            <c:set var="fullname" value="${sessionScope.lastname}" />
        </c:if>
        <h1>Your Order</h1>
        <c:set var="cart" value="${sessionScope.CART.cart}" />
        <c:if test="${empty cart}">
            <h2>No items in cart...</h2>
            <a href="Shop">Click here to start shopping...</a>
        </c:if>
        <c:if test="${not empty cart}">
<!--            <a href="Shop">← Continue Shopping</a><br/><br/>-->
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Title</th>
                        <th>Publish Year</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Items total</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="orderTotal" value="${0}" />
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
                                    <c:set var="orderTotal" value="${orderTotal + book.price * quantity}" />
                                    ${itemTotal}
                                </td>
                            </tr>
                        </c:forEach>
                            <tr>
                                <td colspan="5">
                                    Order Total
                                </td>
                                <td>
                                    <f:formatNumber var="strOrderTotal" 
                                                    value="${orderTotal}" 
                                                    minIntegerDigits="0" />
                                    ${strOrderTotal}
                                </td>
                            </tr>
                    </form>
                </tbody>
            </table>
            <h2>Shipping Information</h2>
            <c:set var="errors" value="${requestScope.ORDER_ERROR}" />
            <form action="Checkout">
                <c:if test="${not empty errors.noNameErr or 
                              not empty errors.noAddressErr or
                              not empty errors.errorMsg }">
                    <c:set var="fullname" value="${param.name}" />
                </c:if>
                Your Name: <input type="text" name="name" 
                       value="${fullname}" /> <br/>
                <c:if test="${not empty errors.noNameErr}">
                    <font color="red">
                        ${errors.noNameErr}
                    </font><br/>
                </c:if>
                    
                <c:if test="${not empty errors.noNameErr or 
                              not empty errors.noAddressErr or
                              not empty errors.errorMsg}">
                    <c:set var="address" value="${param.address}" />
                </c:if>
                Shipping Address: <textarea name="address" rows="4" cols="20">${address}</textarea>
                <br/>
                <c:if test="${not empty errors.noAddressErr}">
                    <font color="red">
                        ${errors.noAddressErr}
                    </font><br/>
                </c:if>
                <input type="submit" value="Check Out" />
            </form>
                <c:if test="${not empty errors.errorMsg}">
                    <font color="red">
                        ${errors.errorMsg}
                    </font><br/>
                </c:if>
        </c:if>
    </body>
</html>
