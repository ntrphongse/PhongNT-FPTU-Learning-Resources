 <%-- 
    Document   : ViewCart
    Created on : Mar 4, 2021, 9:41:12 AM
    Author     : Trần Phong <phongntse150974@fpt.edu.vn>
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="phongnt.productInfo.ProductInfoDTO"%>
<%@page import="phongnt.productInfo.ProductInfoDAO"%>
<%@page import="java.util.Map"%>
<%@page import="phongnt.cart.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trần Phong Book Store</title>
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
        %>
        <h1>Your cart includes</h1>
        <%
            // 1. Customer goes to his/her cart place
            if (session != null) { // JSP getSession(false)
                // 2. Customer takes their cart
                CartObj cart = (CartObj)session.getAttribute("CART");
                if (cart != null) {
                    // 3. Customer gets items to check
                    Map<Integer, Integer> items = cart.getItems();
                    if (items != null) {
                        %>
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>Title</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <form action="remove">
                            <tbody>
                                <% 
                                    int count = 0;
                                    ArrayList<Double> totals = new ArrayList<>();
                                    for (int productId : items.keySet()) {
                                        ProductInfoDAO dao = new ProductInfoDAO();
                                        ProductInfoDTO dto = dao.getProduct(productId);
                                        double price = dto.getPrice();
                                        int quantity = items.get(productId);
                                        double total = price * quantity;
                                        totals.add(total);
                                %>
                                <tr>
                                    <td>
                                        <%= ++count %>
                                    .</td>
                                    <td>
                                        <%= dto.getTitle() %>
                                    </td>
                                    <td>
                                        <%= (double)Math.round(dto.getPrice()) %>
                                    </td>
                                    <td>
                                        <%= items.get(productId) %>
                                    </td>
                                    <td>
                                        <%= total %>
                                    </td>
                                    <td>
                                        <input type="checkbox" name="chkItem" 
                                               value="<%= productId %>" />
                                    </td>
                                </tr>
                                <%
                                    } // EndFor Loop
                                    double sum = 0;
                                    for (double t : totals) {
                                        sum += t;
                                    }
                                %>
                                <tr>
                                    <td colspan="3">
                                        <strong>Sum</strong>
                                    </td>
                                    <td colspan="3">
                                        <%= sum %>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="3">
                                        <a href="bookStore.jsp">Add More Book To Cart</a>
                                    </td>
                                    <td colspan="3">
                                        <input type="submit" value="Remove" name="btnAction"/>
                                    </td>
                                </tr>
                            </tbody>
                            </form>
                        </table>
                                </br>
                                <%
                                    if (username == null) {
                                        %>
                                        <a href="Login.jsp?redirect=viewcart">You need to login to Check out!!!</a>
                                <%
                                    } else {
                                %>
                                    <form action="CheckOut.jsp">
                                        <input type="hidden" name="curUsername" value="<%= username %>" />
                                        <input type="submit" value="Check out" name="btnAction" />
                                    </form>
                                
        <%
                                    }
                        return;
                    } // EndIf Items existed
                } // EndIf Card is existed
            }
        %>
        
        <h2>
            No item is in cart
        </h2>
        <br>
        <a href="bookStore.jsp">Buy Book here!!!</a>
    </body>
</html>
