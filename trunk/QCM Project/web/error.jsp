<%-- 
    Document   : error
    Created on : 2 avr. 2010, 21:19:53
    Author     : marya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Vous avez rencontré une erreur</h1><br/><br/>
        <%
            out.println(request.getAttribute("errorMessage").toString());
        %>
    </body>
</html>
