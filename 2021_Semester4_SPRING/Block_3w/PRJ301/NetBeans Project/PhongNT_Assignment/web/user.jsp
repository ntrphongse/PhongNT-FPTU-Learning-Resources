<%-- 
    Document   : user
    Created on : Apr 26, 2021, 7:29:50 PM
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
        <link rel="stylesheet" href="assets/css/store.css">

        <title>User Profile | ${initParam.WEB_NAME}</title>
    </head>

    <body>
        <jsp:include flush="true" page="welcome.jsp">
            <jsp:param name="page" value="user" />
        </jsp:include>
        <main>
            <h2>
                <i class="fas fa-user"></i> Your Information
            </h2>
            <c:set var="error" value="${requestScope.USER_ERROR}" />
            <c:if test="${not empty error.errorMsg}">
                <div class="alert alert-danger" role="alert">
                    ${errors.errorMsg}
                </div>
            </c:if>
            <c:if test="${empty error.errorMsg}">
                <c:set var="userInfo" value="${requestScope.CURRENT_USER}" />
                <div class="row d-flex justify-content-center mt-3">
                    <div class="col-9 col-lg-4">
                        <form action="User" method="POST">
                            <div class="form-group">
                                <label for="userID">User ID</label>
                                <input type="text" class="form-control" id="userID" 
                                       name="userID" value="${userInfo.userID}" readonly=""> 
                            </div>

                            <div class="form-group">
                                <label for="fullName">Full Name </label>
                                <input type="text" class="form-control" id="fullName" 
                                       name="fullName" value="${userInfo.fullName}" readonly="" >
                            </div>


                            <div class="form-group">
                                <label for="phone">Phone number </label>
                                <input type="text" class="form-control" id="phone" 
                                       name="phone" value="${userInfo.phone}" >
                            </div>

                            <div class="form-group">
                                <label for="address">Address </label>
                                <textarea class="form-control" id="address" 
                                          name="address" rows=3 readonly="">${userInfo.address}</textarea>
                            </div>
                        </form>
                        
                    </div>
                </div>
            </c:if>

        </main>
        <script src = "vendors/jquery/jquery-min.js"></script>  
        <script src = "vendors/bootstraps/js/bootstrap.min.js"></script>

    </body>
</html>
