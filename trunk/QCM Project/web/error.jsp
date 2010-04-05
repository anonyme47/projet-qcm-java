<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" href="css/screen.css" type="text/css" media="screen" title="css" charset="utf-8" />
        <title>Projet QCM</title>
    </head>
    <body>
        <div id="content">
            <p id="top">Une erreur s'est produite</p>
           <div id="logo">
                <h1><a href="index.jsp">iQCM</a></h1>
            </div>
            <ul id="menu">
                <li><a href="Accueil?action=retourAccueil">Accueil</a></li>
                <li><a href="#">Actualité</a></li>
                <li><a href="#">A propos</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
            <div class="line"></div>

            <div id="body">
                <h1>Vous avez rencontré une erreur</h1><br/><br/>
                <%
                    if(request.getAttribute("errorMessage")!=null){
                        out.println((String) request.getAttribute("errorMessage"));
                    }

                    
                %>
            </div>

            <div id="footer">
                <p>&copy; Copyright 2009 Ferrand &ndash; Rabarison &mdash; Design: Lou Ferrand &ndash; Maria Rabarison, <a href="#" title="Projet Java">DagoFly</a></p>
            </div>
        </div>
    </body>
</html>
