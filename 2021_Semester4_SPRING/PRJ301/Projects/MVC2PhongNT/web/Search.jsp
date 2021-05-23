<%-- 
    Document   : Search
    Created on : Feb 26, 2021, 9:13:50 PM
    Author     : Tran Phong <phongntse150974@fpt.edu.vn>
--%>

<%@page import="phongnt.accountInfo.AccountInfoDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <!-- <link rel="stylesheet" href="font-awesome.min.css"> -->
        <link rel="stylesheet" href="css/style.css">
        <title>Search</title>
    </head>

    <body>
        <div class="container">
            <div class="jumbotron">
                <h1>Java Web Application - PhongNT</h1>
            </div>

            <div class="row">
                <h2>Search users by Last name</h2>
            </div>
            <div class="row d-flex justify-content-center">
                <form action="Search" method="GET">
                    <div class="form-group">
                        <label for="txtSearchValue">Value to search: </label>
                        <input type="text" class="form-control" id="txtSearchValue" 
                               name="txtSearchValue" placeholder="Enter value to search..."
                               value="<%= (request.getParameter("txtSearchValue") != null ? 
                                        request.getParameter("txtSearchValue") : "" ) %>">
                    </div>
                    <button type="submit" class="btn btn-success" value="Search" name="btnAction">Search</button>
                </form>
            </div>
            
            <% 
                String searchValue = request.getParameter("txtSearchValue");
                if (searchValue != null) {
                    List<AccountInfoDTO> searchResult = (List<AccountInfoDTO>) request.getAttribute("SEARCH_RESULT");
                    if (searchResult != null) {
                        int count = 0;
                        %>
                        <table class="table mt-3">
                            <thead>
                                <tr>
                                    <th scope="col">No.</th>
                                    <th scope="col">Username</th>
                                    <th scope="col">Password</th>
                                    <th scope="col">Full Name</th>
                                    <th scope="col">Role</th>
                                    <th scope="col">Delete</th>
                                </tr>
                            </thead>
                            <tbody>
                <%
                        for (AccountInfoDTO accountInfoDTO : searchResult) {
                            String deleteURL = "Home"
                                    + "?btnAction=Delete"
                                    + "&username=" + accountInfoDTO.getUsername()
                                    + "&lastSearchValue=" + searchValue;
                                %>
                                <tr>
                                    <th scope="row">
                                        <%= ++count %>
                                    </th>
                                    <td>
                                        <%= accountInfoDTO.getUsername() %>
                                    </td>
                                    <td>
                                        <%= accountInfoDTO.getPassword() %>
                                    </td>
                                    <td>
                                        <%= accountInfoDTO.getFullname() %>
                                    </td>
                                    <td>
                                        <%= accountInfoDTO.isRole() %>
                                    </td>
                                    <td>
                                        <a href="<%= deleteURL %>">Delete</a>
                                    </td>
                                </tr>
                            
                <%
                    
                        } // EndFor

                        %>
                            </tbody>
                        </table>
            <%
                    } else {
                        %>
                        <h2>No record is matched!!!</h2>
            <%
                    } // Endif
                
                } // EndIf 
            %>
        </div>
        
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

    </body>
</html>

