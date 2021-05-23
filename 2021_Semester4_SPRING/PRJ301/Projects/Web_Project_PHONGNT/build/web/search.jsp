<%-- 
    Document   : search.jsp
    Created on : Mar 15, 2021, 10:24:36 PM
    Author     : Tran Phong <phongntse150974@fpt.edu.vn>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <%@include file="welcome.jsp" %>
       
        <h1>Search Account by Last name</h1>
        <form action="Search">
            Value to search: <input type="text" name="txtSearchValue" 
                                    value="${param.txtSearchValue}" /> 
            <br/>
            <input type="submit" value="Search" name="btnAction" />
        </form>
        
        <br/>
        <c:set var="searchValue" value="${param.txtSearchValue}" />
        <c:if test="${not empty searchValue}">
            <c:if test="${not empty requestScope.SEARCH_ERROR.errorMsg}">
                <font color='red'>
                    ${requestScope.SEARCH_ERROR.errorMsg}
                </font>
            </c:if>
            <c:if test="${not empty requestScope.SEARCH_RESULT}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Full name</th>
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
                                    ${account.username}
                                    <input type="hidden" name="txtUsername" 
                                           value="${account.username}" />
                                </td>
                                <td>
                                    <input type="text" name="txtPassword" 
                                           value="${account.password}" />
                                </td>
                                <td>
                                    <input type="text" name="txtLastname" 
                                           value="${account.lastname}" />
                                </td>
                                <td>
                                    <input type="checkbox" name="isAdmin" 
                                           value="ADMIN" 
                                           <c:if test="${account.admin}" >
                                               checked="checked"
                                           </c:if> 
                                    />
                                </td>
                                <td>
                                    <!-- Delete -->
                                    <c:url var="deleteUrl" 
                                           value="Delete" >
                                        <c:param name="username" 
                                                 value="${account.username}" />
                                        <c:param name="lastSearchValue" 
                                                 value="${param.txtSearchValue}" />
                                    </c:url>
                                    <a href="${deleteUrl}">Delete</a>
                                </td>
                                <td>
                                    <!-- Update -->
                                    <input type="submit" value="Update" 
                                           name="btnAction" />
                                    <input type="hidden" name="lastSearchValue" 
                                           value="${param.txtSearchValue}" />
                                </td>
                            </tr>
                        </form>
                            
                        </c:forEach>
                    </tbody>
                </table>

            </c:if>
            <c:if test="${empty requestScope.SEARCH_RESULT}">
                <h2>
                    No record is matched!!!!
                </h2>
            </c:if>
        </c:if>        
    </body>
</html>
