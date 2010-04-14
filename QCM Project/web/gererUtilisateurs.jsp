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
        <title>Projet QCM</title>
    </head>
    <body>
        <div id="content">
            <jsp:include page="scripts/header.jsp" />

            <div id="body">
                <jsp:include page="scripts/menu_left.jsp" />

                <div id="contenu">
                    <h4>Gérer les questionnaires</h4>

                    <%
                                HashMap<Integer, User> users = (HashMap) request.getAttribute("users");
                                if (users != null) {
                                    %>
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>Login</th>
                                                <th>Nom</th>
                                                <th>Prénom</th>
                                                <th>email</th>
                                                <th>Mot de passe</th>
                                                <th>Statut</th>
                                                <th>Modifier</th>
                                                <th>Supprimer</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                            for (Integer idUser : users.keySet()) {
                                                User user = users.get(idUser);
                                                out.println("<tr>");
                                                out.println("<td>" + user.getLogin() + "</td>");
                                                out.println("<td>" + user.getNom() + "</td>");
                                                out.println("<td>" + user.getPrenom() + "</td>");
                                                out.println("<td>" + user.getEmail() + "</td>");
                                                out.println("<td>" + user.getPassword() + "</td>");
                                                out.println("<td>" + user.getStatut().getLibelle() + "</td>");
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
                    <a href="#" class="button">Ajouter un utilisateur</a>

                </div>
            </div>

            <div id="footer">
                <p>&copy; Copyright 2009 Ferrand &ndash; Rabarison &mdash; Design: Lou Ferrand &ndash; Maria Rabarison, <a href="#" title="Projet Java">DagoFly</a></p>
            </div>
        </div>
    </body>
</html>
