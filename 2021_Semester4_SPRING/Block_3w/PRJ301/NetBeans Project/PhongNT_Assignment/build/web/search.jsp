<%-- 
    Document   : search.jsp
    Created on : Mar 15, 2021, 10:24:36 PM
    Author     : Tran Phong <phongntse150974@fpt.edu.vn>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
        
        <title>Search | ${initParam.WEB_NAME}</title>
    </head>
    <body>
        <jsp:include flush="true" page="welcome.jsp">
            <jsp:param name="page" value="search" />
        </jsp:include>
       
        <main>
            
        <h2> 
            <i class="fas fa-search"></i> Search Account by Full name
        </h2>
        
        <form action="Search">
            <div class="row">
                <div class="form-group col-9 col-lg-4">
                    <label for="searchValue">Value to search: </label>
                    <input type="text" class="form-control" id="searchValue" 
                           name="searchValue" value="${param.searchValue}" 
                           placeholder="abc" >
                </div>
            </div>
            <button style="width:20%" type="submit" 
                    class="btn btn-warning d-inline-block mr-5" 
                    name="btnAction" value="Search">
                Search
            </button>
        </form>
        <div class="mt-5">                   
        <c:set var="searchValue" value="${param.searchValue}" />
        <c:if test="${not empty searchValue}">
            <!-- Search Error -->
            <c:if test="${not empty requestScope.SEARCH_ERROR.errorMsg}">
                <div class="alert alert-danger" role="alert">
                    ${requestScope.SEARCH_ERROR.errorMsg}
                </div>>
            </c:if>
            
            <!-- Delete Error -->
            <c:set var="errors" value="${requestScope.DELETE_ERROR}" />
            <c:if test="${not empty errors.errorMsg}">
                <div class="alert alert-danger" role="alert">
                    ${errors.errorMsg}
                </div>
            </c:if>
            
            <!-- Delete Success -->
            <c:if test="${not empty requestScope.DELETE_SUCCESS}">
                <div class="alert alert-success" role="alert">
                    Delete user successfully!
                </div>
            </c:if>
            
            <!-- Update Error -->
            <c:set var="errors" value="${requestScope.UPDATE_ERROR}" />
            
            <c:if test="${not empty errors.passwordLengthErr}">
                <div class="alert alert-danger" role="alert">
                    ${errors.passwordLengthErr} <br/>
                </div>
            </c:if>
            <c:if test="${not empty errors.fullNameLengthErr}">
                <div class="alert alert-danger" role="alert">
                    ${errors.fullNameLengthErr} <br/>
                </div>
            </c:if>
            <c:if test="${not empty errors.phoneError}">
                <div class="alert alert-danger" role="alert">
                    ${errors.phoneError} <br/>
                </div>
            </c:if>
            <c:if test="${not empty errors.adressLengthErr}">
                <div class="alert alert-danger" role="alert">
                    ${errors.adressLengthErr} <br/>
                </div>
            </c:if>
            <c:if test="${not empty errors.cannotUpdateErr}">
                <div class="alert alert-danger" role="alert">
                    ${errors.cannotUpdateErr} <br/>
                </div>
            </c:if>
            <c:if test="${not empty errors.errorMsg}">
                <div class="alert alert-danger" role="alert">
                    ${errors.errorMsg} <br/>
                </div>
            </c:if>
            
            <!-- Update Success -->
            <c:if test="${not empty requestScope.UPDATE_SUCCESS}">
                <div class="alert alert-success" role="alert">
                    Update user successfully!
                </div>
            </c:if>
                
            <c:if test="${not empty requestScope.SEARCH_RESULT}">
                <div class="table-responsive">
                    <table class="table table-hover" >
                        <thead>
                            <tr class="bg-warning">
                                <th>No.</th>
                                <th>User ID</th>
                                <th>Password</th>
                                <th>Full name</th>
                                <th>Phone</th>
                                <th>Address</th>
                                <th>Role</th>
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="account" 
                                       items="${requestScope.SEARCH_RESULT}" 
                                       varStatus="iCount">
                            <form action="Update">
                                <tr>
                                    <td>
                                        ${iCount.count}
                                    .</td>
                                    <td>
                                        ${account.userID}
                                        <input type="hidden" name="userID" 
                                               value="${account.userID}" />
                                    </td>
                                    <td>
                                        <input type="text" name="password" 
                                               value="${account.password}" 
                                               class="form-control" style="width: 50%"/>
                                    </td>
                                    <td>
                                        <input type="text" name="fullName" 
                                               value="${account.fullName}" 
                                               class="form-control" style="width: 70%"/>
                                    </td>
                                    <td>
                                        <input type="text" name="phone" 
                                               value="${account.phone}" 
                                               class="form-control" style="width: 70%"/>
                                    </td>
                                    <td>
                                        <input type="text" name="address" 
                                               value="${account.address}" 
                                               class="form-control" style="width: 90%"/>
                                    </td>
                                    <td>
                                         <div class="form-group">
                                            <input type="checkbox" name="isAdmin" 
                                                    value="ADMIN" id="isAdmin${iCount.count}"
                                                    <c:if test="${account.admin}" >
                                                        checked="checked"
                                                    </c:if> 
                                                    <%-- <c:if test="${fn:trim(sessionScope.userID) eq fn:trim(account.userID)}">
                                                        disabled="disabled"
                                                    </c:if> --%>
                                                    class="form-check-input"
                                             />
                                            <label for="isAdmin${iCount.count}">Admin </label>
                                        </div>
                                    </td>
                                    <td>
                                        <!-- Delete -->
                                        <c:url var="deleteUrl" 
                                               value="Delete" >
                                            <c:param name="userID" 
                                                     value="${account.userID}" />
                                            <c:param name="lastSearchValue" 
                                                     value="${param.searchValue}" />
                                        </c:url>
                                        <a class="btn btn-danger" href="${deleteUrl}">
                                            Delete
                                        </a>
                                    </td>
                                    <td>
                                        <!-- Update -->
                                        <button type="submit" 
                                                class="btn btn-info d-inline-block mr-5" 
                                                name="btnAction" value="Update">
                                            Update
                                        </button>
                                        <input type="hidden" name="lastSearchValue" 
                                               value="${param.searchValue}" />
                                    </td>
                                </tr>
                            </form>

                            </c:forEach>
                        </tbody>
                    </table>
                </div>

            </c:if>
            <c:if test="${empty requestScope.SEARCH_RESULT}">
                <h3>
                    No record is matched!!!!
                </h3>
            </c:if>
        </c:if>
        </div>
        </main>
        
        <script src = "vendors/jquery/jquery-min.js"></script>  
        <script src = "vendors/bootstraps/js/bootstrap.min.js"></script>
    </body>
</html>
