<%-- 
    Document   : CheckOut
    Created on : Mar 8, 2021, 10:19:23 PM
    Author     : Trần Phong <phongntse150974@fpt.edu.vn>
--%>

<%@page import="phongnt.productInfo.ProductInfoDTO"%>
<%@page import="phongnt.productInfo.ProductInfoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="phongnt.cart.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check out your orders</title>
    </head>
    <body>
        <%
            String username = (String)session.getAttribute("username");
            if (username != null) {
                %> 
                <font color="red">Welcome <%= username %></font>
                </br>
<!--                <form action="logOut">
                    <input type="submit" value="Log Out" name="btnAction" />
                </form>-->
        <%
            }
            
        %>
        <h1>Your Order</h1>
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
                                </tr>
                            </thead>
                            <form action="DispatchServlet">
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
<!--                                <tr>
                                    <td colspan="3">
                                        
                                    </td>
                                    <td colspan="3">
                                        <input type="submit" value="Remove" name="btnAction"/>
                                    </td>
                                </tr>-->
                            </tbody>
                            </form>
                        </table>
                                </br>
                                <a href="bookStore.jsp">Add More Book To Cart</a>
                                </br>
                                </br>
                                <%
                                    if (username == null) {
                                        %>
                                        <a href="Login.jsp?redirect=viewcart">You need to login to Check out!!!</a>
                                <%
                                    } else {
                                %>
                                    <form action="checkOut">
                                        <input type="hidden" name="curUsername" value="<%= username %>" />
                                        Your address: <textarea type="text" name="address" value="" rows="5"></textarea></br></br>
                                        <input type="submit" value="Check out now" name="btnAction" />
                                    </form>
                                
        <%
                                    }
                    } // EndIf Items existed
                } // EndIf Card is existed
            }
        %>
    </body>
</html>
