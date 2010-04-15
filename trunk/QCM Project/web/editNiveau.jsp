<%-- 
    Document   : modifierNiveau
    Created on : 15 avr. 2010, 16:32:50
    Author     : Lou
--%>

<%@page import="modele.Niveau"%>
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
                    <h4>Modifier le niveau</h4>
                    <jsp:include page="scripts/errorViewHelper.jsp" />
                    <%
                                Niveau niveau = (Niveau) request.getAttribute("niveau");
                    %>
                    <div class="choice">
                        <p>Appliquez les modifications nécessaires sur le libellé du niveau :</p>
                        <form action="Admin?action=editNiveau" method="post">
                            <table>
                                <tr>
                                    <td class="static"><label for="libelle">Libellé : </label></td>
                                    <td><input type="text" name="libelle" id="libelle" value="<%= niveau.getLibelle()%>"/></td>
                                </tr>
                            </table>
                            <input type="hidden" name="id" value="<%= niveau.getIdNiveau()%>" />
                            <input type="submit" value="Enregistrer" class="button" />
                            <a href="Admin?action=gererNiveaux" class="button">Annuler</a>
                        </form>
                    </div>
                </div>
            </div>

            <div id="footer">
                <p>&copy; Copyright 2009 Ferrand &ndash; Rabarison &mdash; Design: Lou Ferrand &ndash; Maria Rabarison, <a href="#" title="Projet Java">DagoFly</a></p>
            </div>
        </div>
    </body>
</html>