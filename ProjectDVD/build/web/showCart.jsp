<%-- 
    Document   : showCart
    Created on : Nov 25, 2020, 7:53:08 PM
    Author     : PLOYMUDDLE
--%>

<%@page import="model.ProductTable"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.CartTable"%>
<%@page import="model.Cart"%>
<%@page import="model.Product"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <jsp:useBean id="cart" class="model.Cart" scope="request"/>
    <%
        EntityManager em = (EntityManager) session.getAttribute("entitymanager");
        Vector<Cart> cartList = CartTable.findAllCart(em);
        Iterator<Cart> itr = cartList.iterator();
    %>
    <body>
        <h1 align = 'center'>Shopping Cart</h1>
            <table width="600" border="1" align ="center">
                <tr>
                    <th> <div align="center">DVD Name </div></th>
                    <th> <div align="center">Rate </div></th>
                    <th> <div align="center">Year </div></th>
                    <th> <div align="center">Price </div></th>
                    <th> <div align="center">Quantity </div></th>
                    <th> <div align="center">Add Cart </div></th>
                </tr>

                <%
                    while (itr.hasNext()) {
                        cart = itr.next();
                        Product dvd = ProductTable.findProductById(em, cart.getId());
                        out.println("<tr>");
                        out.println("<form name=\"mainForm\" action=\"RemoveToCartController\">");
                        out.println("<input type=\"hidden\" name=\"id\" value=\"" + cart.getId() + "\" />");
                        out.println("<td> " + dvd.getName() + "</td>");
                        out.println("<td> " + dvd.getRate() + "</td>");
                        out.println("<td> " + dvd.getProductyear() + "</td>");
                        out.println("<td> " + dvd.getPrice() + "</td>");
                        out.println("<td align=\"center\"> " + cart.getQuantity() + "</td>");
                %>
                <td align="center"><input type="submit" value="Remove" name="remove" /></td>
                    <%
                            out.println("</form>");
                            out.println("<tr>");
                        }
                    %>
            </table>  
            </br>
            <div align="center">
                <a href="CheckOutController?checkout=Check+Out"> Check Out </a>
            </div>
        
    </body>
</html>

