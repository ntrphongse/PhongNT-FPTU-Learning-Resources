<%-- 
    Document   : checkOutSuccess
    Created on : Apr 26, 2021, 6:42:33 PM
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

        <title>Check Out Successfully | ${initParam.WEB_NAME}</title>
    </head>
    <body>
        <jsp:include flush="true" page="welcome.jsp">
            <jsp:param name="page" value="viewcart" />
        </jsp:include>

        
        <main>
            <h2>
                <i class="fas fa-check-square"></i> Check Out Your Order Successfully
            </h2>

            
        </main>
    </body>
</html>
