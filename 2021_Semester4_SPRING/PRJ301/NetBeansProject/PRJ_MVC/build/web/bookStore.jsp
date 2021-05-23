<%-- 
    Document   : bookStore
    Created on : Mar 7, 2021, 10:53:33 PM
    Author     : Trần Phong <phongntse150974@fpt.edu.vn>
--%>

<%@page import="phongnt.productInfo.ProductInfoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="phongnt.productInfo.ProductInfoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Trần Phong Book Store</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("MVCUsername")) {
                        %> 
                        <font color="red">Welcome <%= cookie.getValue() %></font>
                        </br>
                        <form action="logOut">
                            <input type="submit" value="Log Out" name="btnAction" />
                        </form>
        <%
                    }
                }
            }
        %>
        <h1>Book Store</h1>
        <%
            ProductInfoDAO dao = new ProductInfoDAO();
            ArrayList<ProductInfoDTO> productList = dao.getProductList();
            if (productList != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Title</th>
                    <th>Price</th>
                    <th>View Details and Order</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (ProductInfoDTO dto : productList) {
                        %>
                        <tr>
                            <td>
                                <%= ++count %>
                            .</td>
                            <td>
                                <%= dto.getTitle() %>
                            </td>
                            <td>
                                <%= (double)Math.round(dto.getPrice())%>
                            </td>
                            <td>
                                <center>
                                    <form action="Detail.jsp">
                                        <input type="hidden" name="productId" value="<%= dto.getId() %>" />
                                        <input type="submit" value="Details" name="btnAction" />
                                    </form>
                                </center>
                                
                            </td>
                            
                        </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <%
            } else { 
        %>
        <h2>No Book to show here!</h2>
        <%
            }
            String viewCartURL = "DispatchServlet"
                    + "?btnAction=View your Cart";
        %>
        <br>
        <form action="cart">
            <input type="submit" value="View your Cart" name="btnAction" />
        </form>
    </body>
</html>
