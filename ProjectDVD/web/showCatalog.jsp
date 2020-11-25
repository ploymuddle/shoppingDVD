<%-- 
    Document   : showCatalog
    Created on : Nov 25, 2020, 7:52:46 PM
    Author     : PLOYMUDDLE
--%>

<%@page import="model.CartTable"%>
<%@page import="model.ProductTable"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.Product"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:useBean id="dvd" class="model.Product" scope="request"/>
    <%
        EntityManager em = (EntityManager) session.getAttribute("entitymanager");
        Vector<Product> dvdList = ProductTable.findAllProduct(em);
        Iterator<Product> itr = dvdList.iterator();
    %>
    <body>
        <h1 align = 'center'>DVD Catalog</h1>

        <table width="600" border="1" align ="center" >
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
                    dvd = itr.next();
                    out.println("<tr>");
                    out.println("<form name=\"mainForm\" action=\"AddToCartController\">");
                    out.println("<td> " + dvd.getName() + "</td>");
                    out.println("<input type=\"hidden\" name=\"id\" value=\"" + dvd.getProductid() + "\" />");
                    out.println("<td> " + dvd.getRate() + "</td>");
                    out.println("<td> " + dvd.getProductyear() + "</td>");
                    out.println("<td> " + dvd.getPrice() + "</td>");
                    out.println("<td align=\"center\"><input type=\"text\" name=\"qty\"></td>");
            %>
            <td align="center"><input type="submit" value="AddToCart" name="submit"/></td>
                <%
                        out.println("</form>");
                        out.println("<tr>");
                    }
                %>

        </table>  
                </br>
        <hr style="width:50%;">

        <% if (!CartTable.findAllCart(em).isEmpty()) {%>
        <jsp:include page="showCart.jsp" flush="true" />
        <% }%>
    </body>
</html>
