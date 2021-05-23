<%-- 
    Document   : createNewAccount
    Created on : Mar 17, 2021, 7:31:54 PM
    Author     : Tran Phong <phongntse150974@fpt.edu.vn>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <title>Create New Account | ${initParam.WEB_NAME}</title>
    </head>
    <body>
        <jsp:include flush="true" page="welcome.jsp">
            <jsp:param name="page" value="signup" />
        </jsp:include>
        <main>
            <h2>
                <i class="fas fa-user-plus"></i> Create a New Account
            </h2>
            <div class="row d-flex justify-content-center mt-3">
                <div class="col-9 col-lg-4">
                    <form action="Signup" method="POST">
                        <c:set var="errors" value="${requestScope.CREATE_ERROR}" />

                        <div class="form-group">
                            <label for="userID">User ID* (6 - 30 chars)</label>
                            <input type="text" class="form-control" id="userID" 
                                   name="userID" value="${param.userID}" > 
                        </div>
                        <c:if test="${not empty errors.userIDLengthErr}">
                            <div class="alert alert-danger" role="alert">
                                ${errors.userIDLengthErr}
                            </div>
                        </c:if>

                        <div class="form-group">
                            <label for="password">Password* (6 - 20 chars)</label>
                            <input type="password" class="form-control" id="password" 
                                   name="password" value="" > 
                        </div>
                        <c:if test="${not empty errors.passwordLengthErr}">
                            <div class="alert alert-danger" role="alert">
                                ${errors.passwordLengthErr}
                            </div>
                        </c:if>

                        <div class="form-group">
                            <label for="confirm">Confirm*</label>
                            <input type="password" class="form-control" id="confirm" 
                                   name="confirm" value="" >
                        </div>
                        <c:if test="${not empty errors.confirmNotMatchErr}">
                            <div class="alert alert-danger" role="alert">
                                ${errors.confirmNotMatchErr}
                            </div>
                        </c:if>

                        <div class="form-group">
                            <label for="fullName">Full Name* (2 - 50 chars)</label>
                            <input type="text" class="form-control" id="fullName" 
                                   name="fullName" value="${param.fullName}" >
                        </div>
                        <c:if test="${not empty errors.fullNameLengthErr}">
                            <div class="alert alert-danger" role="alert">
                                ${errors.fullNameLengthErr}
                            </div>
                        </c:if>

                        <div class="form-group">
                            <label for="phone">Phone number*</label>
                            <input type="text" class="form-control" id="phone" 
                                   name="phone" value="${param.phone}" >
                        </div>
                        <c:if test="${not empty errors.phoneErr}">
                            <div class="alert alert-danger" role="alert">
                                ${errors.phoneErr}
                            </div>
                        </c:if>

                        <div class="form-group">
                            <label for="address">Address*</label>
                            <textarea class="form-control" id="address" 
                                      name="address" rows=3 >${param.address}</textarea>
                        </div>
                        <c:if test="${not empty errors.addressLengthErr}">
                            <div class="alert alert-danger" role="alert">
                                ${errors.addressLengthErr}
                            </div>
                        </c:if>

                        <button style="width:50%" type="submit" 
                                class="btn btn-warning d-inline-block mr-5" 
                                name="btnAction" value="Create New Account">
                            Create New Account
                        </button>
                        <button style="width:30%" class="btn btn-secondary d-inline-block" 
                                type="reset">
                            Reset
                        </button>
                        <br/>
                        <c:if test="${not empty errors.userIDExistedErr}">
                            <div class="alert alert-danger mt-3" role="alert">
                                ${errors.userIDExistedErr}
                            </div>
                        </c:if>
                        <c:if test="${not empty errors.errorMsg}">
                            <div class="alert alert-danger mt-3" role="alert">
                                ${errors.errorMsg}
                            </div>
                        </c:if>

                    </form>
                    <br/>
                    Already have an account? <a class="btn btn-primary d-inline-block" href="login">Click here to Login</a>
                </div>
            </div>
        </main>

        <script src = "vendors/jquery/jquery-min.js"></script>  
        <script src = "vendors/bootstraps/js/bootstrap.min.js"></script>
    </body>
</html>
