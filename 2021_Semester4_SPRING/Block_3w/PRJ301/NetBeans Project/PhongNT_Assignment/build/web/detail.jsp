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

    <c:set var="flower" value="${requestScope.PRODUCT_DETAIL}" />

    <c:if test="${empty flower or not empty errors.numberFormatErr}">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta http-equiv="x-ua-compatible" content="ie=edge">
            <link rel="stylesheet" href="vendors/bootstraps/css/bootstrap.min.css">
            <!--        <link rel="stylesheet" href="vendors/font-awesome/css/all.css">-->
            <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
            <link rel="stylesheet" href="assets/css/style.css">

            <title>View Detail - Error | ${initParam.WEB_NAME}</title>
        </head>
        <body>
            <jsp:include flush="true" page="welcome.jsp">
                <jsp:param name="page" value="shopping" />
            </jsp:include>
            <main>
                <h2>
                    <i class="fas fa-info-circle"></i> View Detail
                </h2>
                <h3>No such a flower was found...</h3>
            </main>
        </body>
    </c:if>

    <c:if test="${not empty flower}" >
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta http-equiv="x-ua-compatible" content="ie=edge">
            <link rel="stylesheet" href="vendors/bootstraps/css/bootstrap.min.css">
            <!--        <link rel="stylesheet" href="vendors/font-awesome/css/all.css">-->
            <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
            <link rel="stylesheet" href="assets/css/style.css">
            <link rel="stylesheet" href="assets/css/store.css">

            <title>View Detail | ${initParam.WEB_NAME}</title>
        </head>
        <body>
            <jsp:include flush="true" page="welcome.jsp">
                <jsp:param name="page" value="shopping" />
            </jsp:include>
            <main>
                <h2>
                    <i class="fas fa-info-circle"></i> View Detail
                </h2>
                <!--            <a href="Shop">← Go back to our Store</a><br/>-->
                <jsp:useBean id="categoryDAO" scope="page" 
                             class="phongnt.tblCategories.TblCategoriesDAO" 
                             type="phongnt.tblCategories.TblCategoriesDAO" />

                <div class="bbb_deals mr-0 mt-5">
                    <!--                                <div class="ribbon ribbon-top-right"><span><small class="cross">x </small>4</span></div>-->
                    <!--                                <div class="bbb_deals_title">Today's Combo Offer</div>-->
                    <div class="bbb_deals_slider_container">
                        <div class=" bbb_deals_item">
                            <div class="row">
                                <div class="col-12 col-md-3">
                                    <div class="bbb_deals_image">
                                        <a href="#">
                                            <img src="assets/img/${flower.image}" alt="">
                                        </a>
                                    </div>
                                </div>
                                <div class="col-12 col-md-9"
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
                                                <f:formatNumber value = "${flower.price}" type = "currency"/>

                                            </div>
                                        </div>
                                        <div class="available">
                                            <div class="available_line d-flex flex-row justify-content-start">
                                                <div class="available_title">
                                                    Available: <span>${flower.quantity}</span>
                                                </div>
                                            </div>
                                            <div class="available_bar"><span style="width:17%"></span></div>
                                        </div>

                                        <form action="addToCart" class="mt-5">
                                            <input type="hidden" name="id" value="${flower.productID}" />

                                            <c:if test="${not empty param.quantity}">
                                                <c:set var="quantity" value="${param.quantity}" />
                                            </c:if>

                                            <c:if test="${empty param.quantity}">
                                                <c:set var="quantity" value="1" />
                                            </c:if>

                                            <div class="form-group">
                                                <label class="d-inline" for="quantity">Quantity: </label>
                                                <input type="number" class="form-control d-inline-block" id="quantity" 
                                                       name="quantity" value="${quantity}" max="${flower.quantity}" min="0"
                                                       style="width:50%">
                                            </div>

                                            <button style="width:30%" type="submit" 
                                                    class="btn btn-warning d-inline-block" 
                                                    name="btnAction" value="Add to Cart">
                                                Add to Cart
                                            </button>
                                            <c:set var="addError" value="${requestScope.ADD_ERROR}" />


                                        </form>
                                        <c:if test="${not empty addError.numberFormatErr}">
                                            <br/>
                                            <div class="alert alert-danger mt-3" role="alert">
                                                ${addError.numberFormatErr}
                                            </div>
                                        </c:if>
                                            <c:if test="${not empty addError.errorMsg}">
                                            <br/>
                                            <div class="alert alert-danger mt-3" role="alert">
                                                ${addError.errorMsg}
                                            </div>
                                        </c:if>
                                        <c:set var="success" value="${param.add}" />
                                        <c:if test="${success eq 'success'}">
                                            <div class="alert alert-success mt-3" role="alert">
                                            Add to Cart successfully!!
                                            </div>
                                        </c:if>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
            <!--            <a href="viewcart">View your Cart</a>-->
        </main>
    </body>
</c:if>

</html>
