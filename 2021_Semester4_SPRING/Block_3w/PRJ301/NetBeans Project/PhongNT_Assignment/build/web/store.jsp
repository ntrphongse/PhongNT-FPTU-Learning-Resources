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
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <link rel="stylesheet" href="vendors/bootstraps/css/bootstrap.min.css">
        <!--        <link rel="stylesheet" href="vendors/font-awesome/css/all.css">-->
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/store.css">

        <title>Buy Flowers | ${initParam.WEB_NAME}</title>
    </head>
    <body>
        <c:if test="${empty param.category}">
            <jsp:forward page="Shop">
                <jsp:param name="category" value="all" />
            </jsp:forward>
        </c:if>
        <jsp:include flush="true" page="welcome.jsp">
            <jsp:param name="page" value="shopping" />
        </jsp:include>

        <main>
            <h2>
                <i class="fas fa-store-alt"></i> Buy Flowers
            </h2>
            <c:set var="errors" value="${requestScope.STORE_ERROR}" />
            <c:if test="${not empty errors.errorMsg}">
                <div class="alert alert-danger" role="alert">
                    ${errors.errorMsg}
                </div>
            </c:if>

            <c:if test="${empty errors.errorMsg}">
                <jsp:useBean id="categoryDAO" scope="page" class="phongnt.tblCategories.TblCategoriesDAO" />

                <c:set var="categoriesList" value="${categoryDAO.categoriesList}" />
                <div class="row d-flex justify-content-center">
                    <div class="col-8 mt-3">
                        <form action="Shop" method="GET">

                            <div class="form-group">
                                <div class="row">
                                    <div class="col-3">
                                        Choose category:
                                    </div>
                                    <div class="col-5">
                                        <select name="category" class="form-control d-inline">
                                            <option value="all" <c:if test="${param.category eq 'all'}">selected=""</c:if>>
                                                    All
                                                </option>
                                            <c:forEach items="${categoriesList}" var="category">
                                                <option value="${category.key}" <c:if test="${param.category ne 'all' and param.category eq category.key}">selected=""</c:if>>
                                                    ${category.value}
                                                </option>
                                            </c:forEach>

                                        </select>
                                    </div>
                                    <div class="col-4">
                                        <button type="submit" 
                                                class="btn btn-warning d-inline-block mr-5" 
                                                name="btnAction" value="Search">
                                            Search
                                        </button>
                                    </div>
                                </div>

                            </div>
                        </form>
                    </div>
                </div>


                <c:set var="flowerList" value="${requestScope.PRODUCT_LIST}" />

                <c:if test="${empty flowerList}">
                    <jsp:forward page="Shop" />
                </c:if>

                <%--<c:set var="categoryList" value="${requestScope.CATEGORY_LIST}" />--%>
                <%--<c:if test="${empty categoryList}">--%>
                <%--<jsp:forward page="Shop" />--%>
                <%--</c:if>--%>
                <!--                <div class="table-responsive mt-5">
                                <table class="table table-hover">
                                    <thead>
                                        <tr class="bg-warning">
                                            <th>No.</th>
                                            <th>Title</th>
                                            <th>Price</th>
                                            <th>Detail</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                <%--<c:forEach var="flower" items="${flowerList}" varStatus="iCount">--%>
                <form action="Detail">
                    <tr>
                        <td>
                ${iCount.count}
            </td>
            <td>
                ${flower.productName}
            </td>
            <td>
                <%--<f:formatNumber var="price" value="${flower.price}"--%> 
                                minIntegerDigits="0" />
                ${price}
            </td>
            <td>
                <input type="submit" value="View Detail" name="btnAction" />
                <input type="hidden" name="bookId" 
                       value="${flower.productID}" />
            </td>
        </tr>
    </form>
                <%--</c:forEach>--%>
                </tbody>
            </table>
            </div>-->

                <div class="row">

                    <c:forEach var="flower" items="${flowerList}" varStatus="iCount">
                        <c:url var="detailURL" value="Detail">
                            <c:param name="id" value="${flower.productID}"/>
                        </c:url>
                        <div class="col-12 col-md-4 col-xl-3 mt-5">
                            <div class="bbb_deals">
                                <!--                                <div class="ribbon ribbon-top-right"><span><small class="cross">x </small>4</span></div>-->
                                <!--                                <div class="bbb_deals_title">Today's Combo Offer</div>-->
                                <div class="bbb_deals_slider_container">
                                    <div class=" bbb_deals_item">
                                        <div class="bbb_deals_image">
                                            <a href="${detailURL}">
                                                <img src="assets/img/${flower.image}" alt="">
                                            </a>
                                        </div>
                                        <div class="bbb_deals_content">
                                            <div class="bbb_deals_info_line d-flex flex-row justify-content-start">
                                                <div class="bbb_deals_item_category">
                                                    <c:url var="categoryURL" value="Shop">
                                                        <c:param name="category" value="${flower.categoryID}" />
                                                    </c:url>
                                                    <a href="${categoryURL}">
                                                        ${categoryDAO.getCategoryName(flower.categoryID)}
                                                    </a>
                                                </div>
                                                <!--                                                <div class="bbb_deals_item_price_a ml-auto">
                                                                                                    <strike>₹30,000</strike>
                                                                                                </div>-->
                                            </div>
                                            <div class="bbb_deals_info_line d-flex flex-row justify-content-start">
                                                <div class="bbb_deals_item_name">
                                                    <a href="${detailURL}" style="text-decoration: none">
                                                        ${flower.productName}
                                                    </a>
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
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </c:if>
        </main>
        <script src = "vendors/jquery/jquery-min.js"></script>  
        <script src = "vendors/bootstraps/js/bootstrap.min.js"></script>
    </body>
</html>
