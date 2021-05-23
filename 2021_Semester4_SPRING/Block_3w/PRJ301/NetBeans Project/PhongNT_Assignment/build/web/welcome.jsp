<%-- 
    Document   : welcome
    Created on : Mar 20, 2021, 5:03:14 PM
    Author     : Tran Phong <phongntse150974@fpt.edu.vn>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:set var="iPage" value="${param.page}" />

<header>
    <!-- Menu -->

    <nav class="navbar navbar-expand-lg navbar-light fixed-top">
        <div class="navbar-brand col-5 col-md-2 col-lg-2">
            <span style="font-weight:800">${initParam.WEB_NAME}</span>
        </div>

        <button class="navbar-toggler btn-warning bttn-material-circle bttn-md bttn-no-outline pt-1" type="button" data-toggle="collapse" data-target="#navbarToggler" aria-controls="navbarToggler" aria-expanded="false" aria-label="Toggle navigation">
            <i class="fas fa-bars"></i>
        </button>

        <div class="collapse navbar-collapse" id="navbarToggler">
            <ul class="navbar-nav ml-auto">                
                <c:if test="${empty sessionScope.LOGIN_USER.userID}">
                    <li class="nav-item ml-3 <c:if test="${iPage eq 'shopping'}">${"active"}</c:if>">
                        <a class="nav-link" href="shop">
                            <i class="fas fa-store-alt"></i> Buy Flowers
                        </a>
                    </li>
                    <li class="nav-item ml-3 <c:if test="${iPage eq 'viewcart'}">${"active"}</c:if>">
                        <a class="nav-link" href="viewcart">
                            <i class="fas fa-shopping-cart"></i> View Cart
                        </a>
                    </li>
                    <li class="nav-item ml-3 <c:if test="${iPage eq 'login'}">${"active"}</c:if>">
                        <a class="nav-link" href="login">
                            <i class="fas fa-sign-in-alt"></i> Log In
                        </a>
                    </li>
                    <li class="nav-item ml-3 <c:if test="${iPage eq 'signup'}">${"active"}</c:if>">
                            <a class="nav-link" href="signup">
                                <i class="fas fa-user-plus"></i> Sign Up
                            </a>
                        </li>
                </c:if>

                <c:if test="${not empty sessionScope.LOGIN_USER.userID}">

                    <c:if test="${sessionScope.LOGIN_USER.admin eq true}">
                        <li class="nav-item ml-3 <c:if test="${iPage eq 'search'}">${"active"}</c:if>">
                                <a class="nav-link" href="search">
                                    <i class="fas fa-search"></i> Search
                                </a>
                            </li>
                    </c:if>
                    <c:if test="${sessionScope.LOGIN_USER.admin eq false}">
                        <li class="nav-item ml-3 <c:if test="${iPage eq 'shopping'}">${"active"}</c:if>">
                            <a class="nav-link" href="Shop">
                                <i class="fas fa-store-alt"></i> Buy Flowers
                            </a>
                        </li>
                        <li class="nav-item ml-3 <c:if test="${iPage eq 'viewcart'}">${"active"}</c:if>">
                            <a class="nav-link" href="viewcart">
                                <i class="fas fa-shopping-cart"></i> View Cart
                            </a>
                        </li>
                    </c:if>
                    <li class="nav-item ml-3 <c:if test="${iPage eq 'logout'}">${"active"}</c:if>">
                            <a class="nav-link" href="Logout">
                                <i class="fas fa-sign-out-alt"></i> Log Out
                            </a>
                        </li>
                        <li class="nav-item ml-3 <c:if test="${iPage eq 'user'}">${"active"}</c:if>">
                            <a class="nav-link" href="#">
                                <i class="fas fa-user"></i> Welcome, <strong>${sessionScope.LOGIN_USER.fullName}</strong>
                        </a>
                    </li>
                </c:if>
            </ul>
        </div>
    </nav>
</header>

<!--<a href="Shop">Buy Books</a> |
<a href="viewcart">View Your Cart</a> |-->

<%--<c:if test="${empty sessionScope.username}">
    <a href="login?redirect=${iPage}">Log In</a> |
    <a href="signup">Sign Up</a> 
</c:if>--%>



