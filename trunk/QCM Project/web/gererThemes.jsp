<%-- 
    Document   : gererThemes
    Created on : 13 avr. 2010, 14:24:26
    Author     : Lou
--%>
<%@page import="modele.Theme"%>
<%@page import="java.util.HashMap"%>
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
            <jsp:include page="scripts/header.jsp" />

            <div id="body">
                <jsp:include page="scripts/menu_left.jsp" />

                <div id="contenu">
                    <h4>Gérer les thèmes des questionnaires</h4>

                    <%
                                HashMap<Integer, Theme> themes = (HashMap) request.getAttribute("themes");
                                if (themes != null) {
                                    %>
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>Libellé</th>
                                                <th>Modifier</th>
                                                <th>Supprimer</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                            for (Integer idTheme : themes.keySet()) {
                                                Theme theme = themes.get(idTheme);
                                                out.println("<tr>");
                                                out.println("<td>" + theme.getLibelle() + "</td>");
                                                out.println("<td><a href=''><img src='img/edit_16.png' /></a></td>");
                                                out.println("<td><a href=''><img src='img/delete_16.png' /></a></td>");
                                                out.println("</tr>");
                                            }
                                            %>
                                        </tbody>
                                    </table>

                                    <%
                                }
                    %>

                </div>
            </div>

            <div id="footer">
                <p>&copy; Copyright 2009 Ferrand &ndash; Rabarison &mdash; Design: Lou Ferrand &ndash; Maria Rabarison, <a href="#" title="Projet Java">DagoFly</a></p>
            </div>
        </div>
    </body>
</html>