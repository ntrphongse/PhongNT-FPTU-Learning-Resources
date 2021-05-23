<%-- 
    Document   : SearchJSP
    Created on : Feb 25, 2021, 9:06:25 AM
    Author     : Trần Phong <phongntse150974@fpt.edu.vn>
--%>

<%-- <%@page import="phongnt.accountInfo.AccountInfoDTO"%>
<%@page import="java.util.List"%> --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <font color="red">Welcome, ${sessionScope.username}</font>
        <h1>Search Page</h1>
        <form action="search" method="GET">
            Search value: <input type="text" name="txtSearch" value="${param.txtSearch}" size="100" placeholder="Enter something to search here..."/> <br/>
            <input type="submit" value="Search" name="btnAction" />
        </form><br/>
        <a href="bookStore.jsp">Buy Book here</a></br></br>

        <c:set var="searchValue" value="${param.txtSearch}" />
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCH_RESULT}" />
            <c:if test="${not empty result}">
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
                        
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                        <form action="update">
                            <tr>
                                <td>
                                    ${counter.count}
                                    .</td>
                                <td>
                                    ${dto.username}
                                    <input type="hidden" name="txtUsername" 
                                           value="${dto.username}" />
                                </td>
                                <td>
                                    <!--${dto.password}-->
                                    <input type="text" name="txtPassword" 
                                           value="${dto.password}" />
                                </td>
                                <td>
                                    ${dto.fullname}
                                </td>
                                <td>
                                    <!--${dto.role}-->
                                    <input type="checkbox" name="chkAdmin" value="ON" 
                                           <c:if test="${dto.role}">
                                               checked="checked"
                                           </c:if>
                                    />
                                </td>
                                <td>
                                    <c:url var="deleteLink" value="deleteAccount">
                                        <c:param name="btnAction" value="Delete" />
                                        <c:param name="pk" value="${dto.username}" />
                                        <c:param name="lastSearchValue" value="${searchValue}" />
                                    </c:url>
                                    <a href="${deleteLink}">Delete</a>
                                </td>
                                <td>
                                    <input type="submit" value="Update" name="btnAction" />
                                    <input type="hidden" name="lastSearchValue" 
                                           value="${searchValue}" />
                                </td>
                            </tr>
                        </form>
                        </c:forEach>
                    </tbody>
                </table>

            </c:if>
            <c:if test="${empty result}">
                <h2>
                    No record is matched!!!!
                </h2>
            </c:if>
        </c:if>

        <%-- <%
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals("MVCUsername")) {
                        %>
                        <font color="red">
                            Welcome, <%= cookies[i].getValue() %>
                            </font> </br>
                            <form action="DispatchServlet">
                                <input type="submit" value="Log Out" name="btnAction" />
                            </form>
        <%
                        break;
                    }
                }
            } // EndIf Cookies are null
                %>

        <h1>Search Page</h1>
        <form action="DispatchServlet" method="GET">
            Search value: <input type="text" name="txtSearch" value="<%= (request.getParameter("txtSearch") != null) ? request.getParameter("txtSearch") : ""  %>" size="100" placeholder="Enter something to search here..."/> <br/>
            <input type="submit" value="Search" name="btnAction" />
        </form><br/>
        <a href="bookStore.jsp">Buy Book here</a></br></br>
        <% 
            String searchValue = request.getParameter("txtSearch");
            if (searchValue != null) {
                List<AccountInfoDTO> result = (List<AccountInfoDTO>)request.getAttribute("SEARCH_RESULT");
                if (result != null) {
                    %> 
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
                            <% 
                                int count = 0;
                                for (AccountInfoDTO dto : result) {
                                    String urlRewriting = "DispatchServlet"
                                            + "?btnAction=Delete"
                                            + "&pk=" + dto.getUsername()
                                            + "&lastSearchValue=" + searchValue;
                                    %>
                                <form action="DispatchServlet" method="POST">
                                    <tr>
                                        <td>
                                            <%= ++count %>
                                        </td>
                                        <td>
                                            <%= dto.getUsername() %>
                                            <input type="hidden" name="txtUsername" 
                                                   value="<%= dto.getUsername() %>" />
                                        </td>
                                        <td>
                                            <input type="text" name="txtPassword" 
                                                   value="<%= dto.getPassword() %>" />
                                        </td>
                                        <td>
                                            <%= dto.getFullname() %>
                                        </td>
                                        <td>
                                            <input type="checkbox" name="chkAdmin" 
                                                   value="ON" 
                                                   <%
                                                       if (dto.isRole()) {
                                                           %>
                                                           checked="checked"
                                                   <%
                                                       } // EndIf Check Role
                                                   %>
                                                   />
                                        </td>
                                        <td>
                                            <a href="<%= urlRewriting %>">Delete</a>
                                        </td>
                                        <td>
                                            <input type="hidden" name="lastSearchValue" 
                                                   value="<%= searchValue %>" />
                                            <input type="submit" value="Update" name="btnAction" />
                                        </td>
                                    </tr>
                                </form>
                            <%
                                }
                            %>
                        </tbody>
                    </table>

        <%
                } else {
                    %> 
                    <h2>No record is matched!!!</h2>
        <%
                } // EndIf search has no record
            } // EndIf searchValue has a value
        %>
        --%>
    </body>
</html>
