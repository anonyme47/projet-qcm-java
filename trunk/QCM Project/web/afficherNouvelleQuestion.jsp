<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modele.Question" %>
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
                                int nbReponses = Integer.parseInt(request.getAttribute("nbReponses").toString());
                                Question question = (Question) request.getAttribute("question");
                    %>
                    <h4>Ajouter les réponses</h4>
                    <p><em>Rappel de la question : </em><%= question.getLibelle()%></p>
                    <form action="CreerQuestionnaire" method="post">
                        <table id="question_a_ajouter" class="format question-a-ajouter">
                            <tr>
                                <th>Réponse</th>
                                <th>Libellé</th>
                                <th>Descriptif</th>
                                <th>Note</th>
                                <th>Réponse correcte</th>
                            </tr>
                            <%
                                        for (int i = 0; i < nbReponses; i++) {
                                            out.println("<tr>");
                                            out.println("<td class='centered'><strong>" + i + "</strong></td>");
                                            out.println("<td><input type='text' value='' name='libelleReponse_" + i + "' class='medium-input' /></td>");
                                            out.println("<td><input type='text' value='' name='DescriptifReponse_" + i + "' class='medium-input' size='27' /></td>");
                                            out.println("<td><input type='text' value='' name='noteReponse_" + i + "' class='medium-input' size='4' /></td>");
                                            out.println("<td class='centered'><input type='checkbox' value='' name='estCorrecteReponse_" + i + "' class='medium-input' /></td>");
                                            out.println("</tr>");
                                        }
                            %>
                        </table>
                        <input type="hidden" name="nbReponses" value="<%= nbReponses%>" />
                        <input type="hidden" name="action" value="createNewQuestion" />
                        <input type="submit" name="action" value="Ajouter ces réponses" class="button" />
                    </form>
                </div>
            </div>

            <div id="footer">
                <p>&copy; Copyright 2009 Ferrand &ndash; Rabarison &mdash; Design: Lou Ferrand &ndash; Maria Rabarison, <a href="#" title="Projet Java">DagoFly</a></p>
            </div>
        </div>
    </body>
</html>
