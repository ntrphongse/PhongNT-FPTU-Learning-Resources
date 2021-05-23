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
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <link rel="stylesheet" href="vendors/bootstraps/css/bootstrap.min.css">
        <!--        <link rel="stylesheet" href="vendors/font-awesome/css/all.css">-->
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/store.css">

        <title>View Your Cart | ${initParam.WEB_NAME}</title>
    </head>
    <body>
        <jsp:include flush="true" page="welcome.jsp">
            <jsp:param name="page" value="viewcart" />
        </jsp:include>
        <main>
            <h2>
                <i class="fas fa-shopping-cart"></i> View Your Cart
            </h2>
            <c:set var="cart" value="${sessionScope.CART.cart}" />
            <c:if test="${empty cart}">
                <h3>No items in cart...</h3>
                <a class="btn btn-warning" href="Shop">Click here to start shopping...</a>
            </c:if>
            <c:if test="${not empty cart}">
                <!--                <table border="1">
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
                <%--<c:set var="orderTotal" value="${0}" />--%>
                <form action="removeFromCart">
                <%--<c:forEach var="cartItem" items="${cart}" varStatus="iCount">--%>
                <%--<c:set var="bookId" value="${cartItem.key}" />--%>
                <%--<c:set var="quantity" value="${cartItem.value}" />--%>
                <%--<jsp:useBean id="flowerDAO" scope="page"--%> 
                             class="phongnt.tblProducts.TblProductsDAO" 
                             type="phongnt.tblProducts.TblProductsDAO" />
                <%--<c:set var="book" value="${flowerDAO.getProduct(bookId)}" />--%>
                
                <tr>
                    <td>
                ${iCount.count}
            .</td>
            <td>
                ${book.productName}
            </td>
            <td>
                ${book.publishYear}
            </td>
            <td>
                <%--<f:formatNumber var="price"--%> 
                                value="${book.price}" 
                                minIntegerDigits="0" />
                ${price}
            </td>
            <td>
                ${quantity}
            </td>
            <td>
                <%--<f:formatNumber var="itemTotal"--%> 
                                value="${book.price * quantity}" 
                                minIntegerDigits="0" />
                <%--<c:set var="orderTotal"--%> 
                       value="${orderTotal + book.price * quantity}" />
                ${itemTotal}
            </td>
            <td>
                <input type="checkbox" name="isRemove" 
                       value="${book.id}" />
            </td>
        </tr>
                <%--</c:forEach>--%>
                    <tr>
                        <td colspan="5">
                            Order Total:
                        </td>
                        <td>
                <%--<f:formatNumber var="strOrderTotal"--%> 
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
</table>-->

                <jsp:useBean id="categoryDAO" scope="page" 
                             class="phongnt.tblCategories.TblCategoriesDAO" 
                             type="phongnt.tblCategories.TblCategoriesDAO" />
                <c:set var="orderTotal" value="${0}" />
                <div class="bbb_deals mr-0 mt-5">
                    <c:forEach var="cartItem" items="${cart}" varStatus="iCount">
                        <c:set var="id" value="${cartItem.key}" />
                        <c:set var="quantity" value="${cartItem.value.quantity}" />
                        <c:set var="price" value="${cartItem.value.price}" />
                        <jsp:useBean id="flowerDAO" scope="page" 
                                     class="phongnt.tblProducts.TblProductsDAO" 
                                     type="phongnt.tblProducts.TblProductsDAO" />
                        <c:set var="flower" value="${flowerDAO.getProduct(id)}" />

                        <!--                                <div class="ribbon ribbon-top-right"><span><small class="cross">x </small>4</span></div>-->
                        <!--                                <div class="bbb_deals_title">Today's Combo Offer</div>-->
                        <div class="bbb_deals_slider_container">
                            <div class=" bbb_deals_item">
                                <div class="row">
                                    <div class="col-12 col-md-3 col-lg-2">
                                        <div class="bbb_deals_image">
                                            <a href="#">
                                                <img src="assets/img/${flower.image}" alt="">
                                            </a>
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-5"
                                         <div class="bbb_deals_content">
                                            <div class="bbb_deals_info_line d-flex flex-row justify-content-start">
                                                <div class="bbb_deals_item_category">
                                                    ${categoryDAO.getCategoryName(flower.categoryID)}
                                                </div>
                                                <!--                                                <div class="bbb_deals_item_price_a ml-auto">
                                                                                                    <strike>₹30,000</strike>
                                                                                                </div>-->
                                            </div>
                                            <div class="bbb_deals_info_line d-flex flex-row justify-content-start">
                                                <div class="bbb_deals_item_name">
                                                    <h3>
                                                        ${flower.productName}
                                                    </h3>
                                                </div>

                                            </div>
                                            <div class="bbb_deals_info_line d-flex flex-row justify-content-start">
                                                <div class="bbb_deals_item_price">
                                                    <f:formatNumber value = "${price}" type = "currency"/>

                                                </div>
                                            </div>
                                            <div class="bbb_deals_info_line d-flex flex-row justify-content-start">
                                                <div class="bbb_deals_item_quantity">
                                                    Quantity: ${quantity}

                                                </div>

                                            </div>
                                            <div class="bbb_deals_info_line d-flex flex-row justify-content-start mt-3">
                                                <div class="bbb_deals_item_total">
                                                    Total: <span class="badge badge-secondary" style="font-size: 100%">
                                                        <f:formatNumber value = "${price * quantity}" type = "currency"/>
                                                    </span>
                                                    <c:set var="orderTotal"
                                                           value="${orderTotal + price * quantity}" />

                                                </div>

                                            </div>
                                            <div class="mt-3">
                                                <form action="removeFromCart">
                                                    <input type="hidden" name="id" value="${flower.productID}" />
                                                    <button type="submit" 
                                                            class="btn btn-danger d-inline-block" 
                                                            name="btnAction" value="Remove">
                                                        Remove
                                                    </button>
                                                </form>     
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <hr>
                        </c:forEach>   
                        <span class="badge badge-success mt-3" style="font-size: 175%">
                            Order Total: <f:formatNumber value = "${orderTotal}" type = "currency"/>
                        </span> 

                    </div>
                    <a class="btn btn-warning mt-3" href="checkout">
                        <i class="fas fa-money-check-alt"></i> Check Out now
                    </a>

                </c:if>
        </main>
        <script src = "vendors/jquery/jquery-min.js"></script>  
        <script src = "vendors/bootstraps/js/bootstrap.min.js"></script>
    </body>
</html>
