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
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <link rel="stylesheet" href="vendors/bootstraps/css/bootstrap.min.css">
        <!--        <link rel="stylesheet" href="vendors/font-awesome/css/all.css">-->
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/store.css">

        <title>Check Out | ${initParam.WEB_NAME}</title>
    </head>
    <body>
        <jsp:include flush="true" page="welcome.jsp">
            <jsp:param name="page" value="viewcart" />
        </jsp:include>

        <c:if test="${not empty sessionScope.LOGIN_USER.fullName}">
            <c:set var="fullname" value="${sessionScope.LOGIN_USER.fullName}" />
            <c:set var="address" value="${sessionScope.LOGIN_USER.address}" />
        </c:if>
        <main>
            <h2>
                <i class="fas fa-money-check-alt"></i> Check Out Your Order
            </h2>

            <c:set var="cart" value="${sessionScope.CART.cart}" />

            <c:if test="${empty cart}">
                <h3>No items in cart...</h3>
                <a class="btn btn-warning" href="Shop">Click here to start shopping...</a>
            </c:if>

            <c:if test="${not empty cart}">
                <!--            <a href="Shop">← Continue Shopping</a><br/><br/>-->
                <jsp:useBean id="categoryDAO" scope="page" 
                             class="phongnt.tblCategories.TblCategoriesDAO" 
                             type="phongnt.tblCategories.TblCategoriesDAO" />
                <c:set var="orderTotal" value="${0}" />
                <div class="row">
                    <div class="col-12 col-lg-8">
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
                        </div>
                        <div class="col-12 col-lg-4">
                            <div class="mt-5">
                                <span class="badge badge-primary pt-2 mb-2 d-block">
                                    <h3><strong>Shipping Information</strong></h3>
                                </span> 

                                <c:set var="errors" value="${requestScope.ORDER_ERROR}" />
                                <form action="Checkout">
                                    <c:if test="${not empty errors.noNameErr or 
                                                  not empty errors.noAddressErr or
                                                  not empty errors.errorMsg }">
                                        <c:set var="fullname" value="${param.name}" />
                                    </c:if>
                                    <div class="form-group">
                                        <label for="name">Your name: </label>
                                        <input type="text" class="form-control" id="name" 
                                               name="name" value="${fullname}" >
                                    </div>

                                    <c:if test="${not empty errors.noNameErr}">
                                        <div class="alert alert-danger mt-3" role="alert">
                                            ${errors.noNameErr}
                                        </div>
                                    </c:if>

                                    <c:if test="${not empty errors.noNameErr or 
                                                  not empty errors.noAddressErr or
                                                  not empty errors.errorMsg}">
                                        <c:set var="address" value="${param.address}" />
                                    </c:if>
                                    <div class="form-group">
                                        <label for="address">Shipping Address: </label>
                                        <textarea name="address" rows="4" cols="20" class="form-control">${address}</textarea>
                                    </div>

                                    <c:if test="${not empty errors.noAddressErr}">
                                        <div class="alert alert-danger mt-3" role="alert">
                                            ${errors.noAddressErr}
                                        </div>
                                    </c:if>
                                    <input type="hidden" name="total" value="${orderTotal}" />
                                    <button type="submit" class="btn btn-warning d-inline-block mr-5" name="btnAction" value="Check Out">
                                        Check Out
                                    </button>

                                </form>

                                <c:if test="${not empty errors.errorMsg}">
                                    <div class="alert alert-danger mt-3" role="alert">
                                        ${errors.errorMsg}
                                    </div>
                                </c:if>
                                <c:if test="${not empty requestScope.ORDER_SUCCESS}">
                                    <div class="alert alert-success mt-3" role="alert">
                                        ${requestScope.ORDER_SUCCESS}
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </div>


                </c:if>
        </main>
    </body>
</html>
