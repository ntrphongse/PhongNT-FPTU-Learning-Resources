<%-- 
    Document   : Detail
    Created on : Mar 8, 2021, 11:26:22 AM
    Author     : Trần Phong <phongntse150974@fpt.edu.vn>
--%>

<%@page import="phongnt.productInfo.ProductInfoDTO"%>
<%@page import="phongnt.productInfo.ProductInfoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        int productId = Integer.parseInt(request.getParameter("productId"));
        ProductInfoDAO dao = new ProductInfoDAO();
        ProductInfoDTO dto = dao.getProduct(productId);
        String title = null;
        int publishYear = 0;
        double price = 0.0;
        if (dto == null) {
            title = "No such a Book...";
        } else {
            title = dto.getTitle();
            publishYear = dto.getPublishYear();
            price = dto.getPrice();
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <%= (dto == null) ? title : "Detail - " + title %>
        </title>
    </head>
    <body>
        <%
            String username = (String)session.getAttribute("username");
            if (username != null) {
                %> 
                <font color="red">Welcome <%= username %></font>
                </br>
                <form action="logOut">
                    <input type="submit" value="Log Out" name="btnAction" />
                </form>
        <%
            }
            if (dto == null) {
                %>
        <h2>No such a Book was found...</h2>
        
        <%
            } else {
                %>
                <h2><%= title %></h2>
                <ul>
                    <li>Publish Year: <%= publishYear %></li>
                    <li>Price: <%= (double)Math.round(dto.getPrice()) %></li>
                </ul>
                <form action="cart">
                    <input type="hidden" name="productId" value="<%= productId %>" />
                    Quantity: <input type="number" name="quantity" value="1" />
                    <input type="submit" value="Add This Book to Cart" name="btnAction" />
                    <input type="submit" value="View your Cart" name="btnAction" />
                </form>
        <%
            }
        %>
        <a href="bookStore.jsp">Click here to go back to our Book Store</a>
    </body>
</html>
