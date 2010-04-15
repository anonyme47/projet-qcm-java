<%-- 
    Document   : gererNiveaux
    Created on : 13 avr. 2010, 14:24:54
    Author     : Lou
--%>
<%@page import="modele.Niveau"%>
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
                    <h4>Gérer les niveaux des questionnaires</h4>
                    <jsp:include page="scripts/errorViewHelper.jsp" />

                    <%
                        HashMap<Integer, Niveau> niveaux = (HashMap) request.getAttribute("niveaux");
                        if (niveaux != null) {
                    %>
                                    <table class="format">
                                        <tr>
                                            <th>Libellé</th>
                                            <th>Modifier</th>
                                            <th>Activité</th>
                                            <th>Contrôle</th>
                                        </tr>
                            <%
                                for (Integer idTheme : niveaux.keySet()) {
                                    Niveau niveau = niveaux.get(idTheme);
                            %>
                                <tr>
                                <td> <%= niveau.getLibelle() %></td>
                                <%
                                    if (niveau.getUtilisations() == 0) {
                                %>
                                <td class="centered">
                                    <a href="Admin?action=editNiveau&id=<%= niveau.getIdNiveau() %>"><img src="img/edit_16.png" alt="Modifier le libellé du niveau" /></a>
                                </td>
                                <td class="centered">
                                    <%
                                    if (niveau.estActif()) {
                                        out.println("<span class='bon'>Actif</span>");
                                    } else {
                                        out.println("<span class='mauvais'>Inactif</span>");
                                    }
                                    %>
                                </td>
                                <td class="centered">
                                    <form method="post" action="Admin?action=controleNiveau">
                                        <input type="hidden" name="id" value="<%= niveau.getIdNiveau() %>" />
                                    <% if (niveau.estActif()) { %>
                                        <input type="submit" value="Désactiver" /> <input type="hidden" name="est_actif" value="false" />
                                    <% } else { %>
                                        <input type="submit" value="Activer" /> <input type="hidden" name="est_actif" value="true" />
                                    <% } %>
                                    </form>
                                </td>
                                <% } else { %>
                                <td class="centered" colspan="3"><small>Ce niveau ne peut pas être modifié ou supprimé.</small></td>
                                <% } %>
                                </tr>
                            <%
                            }
                            %>
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