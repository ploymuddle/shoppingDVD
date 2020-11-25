<%-- 
    Document   : checkOutResult
    Created on : Nov 26, 2020, 1:16:59 AM
    Author     : PLOYMUDDLE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="center">Your Order is confirmed!</h1>
        <h1 align="center">The total amount is $<%= request.getAttribute("total")%> </h1>

        <div align="center">
            <a href="showCatalog.jsp">Back to DVD Catalog</a>
        </div>
    </body>
</html>
