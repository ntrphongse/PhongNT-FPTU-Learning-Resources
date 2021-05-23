<%-- 
    Document   : login
    Created on : Apr 20, 2021, 10:26:07 PM
    Author     : Tran Phong <phongntse150974@fpt.edu.vn>
--%>

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
        
        <title>Login | ${initParam.WEB_NAME}</title>
    </head>

    <body>
        
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
                        <li class="nav-item ml-3">
                            <a class="nav-link" href="/">
                            <i class="fas fa-store-alt"></i> Buy Flowers
                            </a>
                        </li>
                        <li class="nav-item ml-3 ">
                            <a class="nav-link" href="/my">
                                <i class="fas fa-shopping-cart"></i> View Cart
                            </a>
                        </li>
                        <li class="nav-item ml-3 active">
                            <a class="nav-link" href="/all">
                                <i class="fas fa-sign-in-alt"></i> Log In
                            </a>
                        </li>
                        <li class="nav-item ml-3 ">
                            <a class="nav-link" href="/admin">
                                <i class="fas fa-user-plus"></i> Sign Up
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        
        <main>
        
        <h2>
            <i class="fas fa-sign-in-alt"></i> Login
        </h2>
            
        <div class="row d-flex justify-content-center mt-3">
            <div class="col-3">
                <form action="MainController">
                    <div class="form-group">
                        <label for="userID">User ID</label>
                        <input type="text" class="form-control" id="userID" name="userID" >
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" name="password">
                    </div>
                    <div class="form-group form-check">
                        <input type="checkbox" class="form-check-input" id="remember">
                        <label class="form-check-label" for="remember">Remember me</label>
                    </div>
            
                    <button style="width:50%" type="submit" class="btn btn-warning" name="action">Login</button>
                </form>
            </div>
        </div>
       
        </main>
        
        <script src = "vendors/jquery/jquery-min.js"></script>  
        <script src = "vendors/bootstraps/js/bootstrap.min.js"></script>

    </body>
</html>
