<%-- 
    Document   : editTheme
    Created on : 15 avr. 2010, 17:29:42
    Author     : Lou
--%>

<%@page import="modele.Theme"%>
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
                                Theme theme = (Theme) request.getAttribute("theme");
                    %>
                    <p>Appliquez les modifications nécessaires sur le libellé du thème :</p>
                    <div  class="choice">
                        <form action="Admin?action=editTheme" method="post">
                            <table>
                                <tr>
                                    <td><label for="libelle"><strong>Libellé : </strong></label></td>
                                    <td><input type="text" name="libelle" id="libelle" value="<%= theme.getLibelle()%>" size="50" class="medium-input" /></td>
                                </tr>
                            </table>
                            <input type="hidden" name="id" value="<%= theme.getIdTheme()%>" />
                            <input type="submit" value="Enregistrer" class="button" />
                            <a href="Admin?action=gererThemes" class="button">Annuler</a>
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