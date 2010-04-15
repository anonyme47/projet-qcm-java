<%-- 
    Document   : gererUtilisateurs
    Created on : 13 avr. 2010, 15:49:48
    Author     : Lou
--%>

<%@page import="modele.User"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" href="css/screen.css" type="text/css" media="screen" title="css" charset="utf-8" />
        <script src="js/jquery-1.4.2.min.js" type="text/javascript" />
        <script src="js/jquery-ui/js/jquery-ui-1.8.custom.min.js" type="text/javascript" />
        <script src="js/jquery-ui/css/ui-lightness/jquery-ui-1.8.custom.css" type="text/javascript" />

        <title>Projet QCM</title>
    </head>
    <body>
        <div id="content">
            <jsp:include page="scripts/header.jsp" />

            <div id="body">
                <jsp:include page="scripts/menu_left.jsp" />

                <div id="contenu">
                    <h4>Gérer les utilisateurs</h4>
                    <jsp:include page="scripts/errorViewHelper.jsp" />

                    <%
                                HashMap<Integer, User> users = (HashMap) request.getAttribute("users");
                                if (users != null) {
                    %>
                    <table class="format">
                        <tr>
                            <th>Login</th>
                            <th>Nom</th>
                            <th>Prénom</th>
                            <th>Email</th>
                            <th>Mot de passe</th>
                            <th>Statut</th>
                            <th>Contrôle</th>
                        </tr>
                        <%
                            for (Integer idUser : users.keySet()) {
                                User user = users.get(idUser);
                        %>
                        <tr>
                            <td><%= user.getLogin() %></td>
                            <td><%= user.getNom() %></td>
                            <td><%= user.getPrenom() %></td>
                            <td><%= user.getEmail() %></td>
                            <td><%= user.getPassword() %></td>
                            <td><%= user.getStatut().getLibelle() %></td>

                                <td class="centered">
                                    <%
                                    if (user.estActif()) {
                                        out.println("<span class='bon'>Actif</span>");
                                    } else {
                                        out.println("<span class='mauvais'>Inactif</span>");
                                    }
                                    %>
                                    <form method="post" action="Admin?action=controleUser">
                                        <input type="hidden" name="id" value="<%= user.getIdUser() %>" />
                                    <% if (user.estActif()) { %>
                                        <input type="submit" value="Désactiver" /> <input type="hidden" name="est_actif" value="false" />
                                    <% } else { %>
                                        <input type="submit" value="Activer" /> <input type="hidden" name="est_actif" value="true" />
                                    <% } %>
                                    </form>
                                </td>
                        </tr>
                        <% } %>
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
