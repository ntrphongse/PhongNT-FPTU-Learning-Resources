<%-- 
    Document   : login
    Created on : Mar 15, 2021, 9:54:37 PM
    Author     : Tran Phong <phongntse150974@fpt.edu.vn>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

        <title>Login | ${initParam.WEB_NAME}</title>
    </head>
    <body>
        <jsp:include flush="true" page="welcome.jsp">
            <jsp:param name="page" value="login" />
        </jsp:include>

        <main>
            <h2> 
                <i class="fas fa-sign-in-alt"></i> Login
            </h2>
            <div class="row d-flex justify-content-center mt-3">
                <div class="col-9 col-lg-4">
                    <form action="Login" method="POST">

                        <div class="form-group">
                            <label for="userID">User ID</label>
                            <input type="text" class="form-control" id="userID" 
                                   name="userID" value="${param.userID}" >
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" 
                                   name="password" value="">
                        </div>

                        <input type="hidden" name="redirect" value="${param.redirect}" />

                        <!--                        <div class="form-group form-check">
                                                    <input type="checkbox" class="form-check-input" id="remember">
                                                    <label class="form-check-label" for="remember">Remember me</label>
                                                </div>-->

                        <button style="width:30%" type="submit" 
                                class="btn btn-warning d-inline-block mr-5" 
                                name="btnAction" value="Login">
                            Login
                        </button>
                        <button style="width:30%" class="btn btn-secondary d-inline-block" 
                                type="reset">
                            Reset
                        </button>

                        <a class="btn btn-primary d-block mt-3" href="signup">
                            Don't have an Account? Create a new one here
                        </a>

                        <c:if test="${not empty requestScope.LOGIN_ERROR.errorMsg}">
                            <div class="alert alert-danger mt-3" role="alert">
                                ${requestScope.LOGIN_ERROR.errorMsg}
                            </div>
                        </c:if>

                    </form>
                </div>
            </div>
        </main>

        <script src = "vendors/jquery/jquery-min.js"></script>  
        <script src = "vendors/bootstraps/js/bootstrap.min.js"></script>
    </body>
</html>