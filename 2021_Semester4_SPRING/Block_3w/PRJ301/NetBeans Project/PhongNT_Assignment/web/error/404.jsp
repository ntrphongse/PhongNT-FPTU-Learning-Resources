<%-- 
    Document   : 404
    Created on : Apr 26, 2021, 10:20:51 PM
    Author     : Tran Phong <phongntse150974@fpt.edu.vn>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <link rel="stylesheet" href="vendors/bootstraps/css/bootstrap.min.css">
        <!--        <link rel="stylesheet" href="vendors/font-awesome/css/all.css">-->
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
        <link rel="stylesheet" href="assets/css/style.css">

        <title>Error - 404 Not Found | ${initParam.WEB_NAME}</title>
    </head>

    <body>
        <jsp:include flush="true" page="/welcome.jsp">
            <jsp:param name="page" value="" />
        </jsp:include>
        <main>
        <h2> 
            <i class="fas fa-exclamation-circle"></i> Error
        </h2>
        <h3 class="mt-3">
            <font color="red">
                Oopps!! The page you requested doesn't exist! Please check 
                the URL and try again!
            </font>
        </h3>
        </main>
        <script src = "vendors/jquery/jquery-min.js"></script>  
        <script src = "vendors/bootstraps/js/bootstrap.min.js"></script>
    </body>
</html>
