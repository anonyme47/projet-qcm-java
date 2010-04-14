<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modele.Questionnaire" %>
<%@page import="modele.Question" %>
<%@page import="java.util.List" %>
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
                    <%
                                out.println("<form action='CreerQuestionnaire' method='post'>");
                                out.println("<table id='question_a_ajouter' class='liste center question-a-ajouter' border='1'>");
                                out.println("<tr>");
                                out.println("<th class='libelle'>Libellé</th>");
                                out.println("<th class='descriptif'>Descriptif</th>");
                                out.println("<th class='note'>Note</th>");
                                out.println("<th class='correcte'>Réponse correcte</th>");
                                out.println("</tr>");
                                int nbReponses = Integer.parseInt(request.getAttribute("nbReponses").toString());
                                for (int i = 0; i < nbReponses; i++) {
                                    out.println("<tr>");
                                    out.println("<td><input type='text' value='' name='libelleReponse_" + i + "' /></td>");
                                    out.println("<td><input type='text' value='' name='DescriptifReponse_" + i + "' /></td>");
                                    out.println("<td><input type='text' value='' name='noteReponse_" + i + "' /></td>");
                                    out.println("<td><input type='checkbox' value='' name='estCorrecteReponse_" + i + "' /></td>");
                                    out.println("</tr>");
                                }
                                out.println("</table>");
                                out.println("<input type='hidden' name='nbReponses' value='" + nbReponses + "' />");
                                out.println("<input type='hidden' name='action' value='createNewQuestion' />");
                                out.println("<input type='submit' name='action' value='Ajouter ces réponses' class='button' />");
                                out.println("</form>");
                    %>
                </div>
            </div>

            <div id="footer">
                <p>&copy; Copyright 2009 Ferrand &ndash; Rabarison &mdash; Design: Lou Ferrand &ndash; Maria Rabarison, <a href="#" title="Projet Java">DagoFly</a></p>
            </div>
        </div>
    </body>
</html>
