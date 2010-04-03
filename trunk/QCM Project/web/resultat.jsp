<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modele.Questionnaire" %>
<%@page import="modele.Qcm" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" href="css/screen.css" type="text/css" media="screen" title="css" charset="utf-8" />
        <title>Projet QCM - Les résultats</title>
    </head>
    <body>
        <div id="content">
            <jsp:include page="scripts/header.jsp" />

            <div id="body">
                <jsp:include page="scripts/menu_left.jsp" />
                <%--<jsp:useBean type="modele.Questionnaire" id="questionnaire" />--%>

                <%
                    Questionnaire questionnaire = (Questionnaire) request.getAttribute("questionnaire");
                    Qcm qcm = (Qcm) request.getSession().getAttribute("qcm");
                %>

                <div id="contenu">
                    <h4 id="liste">Résultats pour ce questionnaire</h4>
                    <div id="score">
                        <p>Votre note : <span class="score_value mauvais">10%</span></p>
                    </div>
                    <div class="recapitule_questionnaire">
                        <h5>Récapitulatif du questionnaire</h5>
                        <table>
                            <tr>
                                <td class="static">Titre</td>
                                <td><%= questionnaire.getLibelle() %></td>
                            </tr>
                            <tr>
                                <td class="static">Thème</td>
                                <td><%= request.getAttribute("theme") %></td>
                            </tr>
                            <tr>
                                <td class="static">Niveau</td>
                                <td><%= request.getAttribute("niveau") %></td>
                            </tr>
                            <tr>
                                <td class="static">Questions répondues</td>
                                <td><%= qcm.getUserReponses().size() %> / <%= qcm.getQuestions().size() %></td>
                            </tr>
                            <tr>
                                <td class="static">Temps utilisé</td>
                                <td>50 secondes</td>
                            </tr>
                        </table>
                    </div>

                    <dl id="resultat" class="liste">
                        <!-- foreach question dans le questionnaire -->
                        <%
                            for (Integer question : qcm.getQuestions().keySet()) {
                                out.println("<dt>Question " + question + "</dt>");
                                out.println("<dd>Votre réponse : " + qcm.getQuestions().get(question) + "</dd>");
                            }
                        %>
<%--                        <dt>Question 1</dt>
                        <dd>La réponse de l'utilisateur puis la vraie réponse</dd>
                        <dt>Question 2</dt>
                        <dd>Vous n'avez pas répondu à cette question</dd>
--%>                    </dl>
                    <a href="accueil.jsp">&laquo; Retour à l'accueil</a>
                </div>
            </div>

            <div id="footer">
                <p>&copy; Copyright 2009 Ferrand &ndash; Rabarison &mdash; Design: Lou Ferrand &ndash; Maria Rabarison, <a href="#" title="Projet Java">DagoFly</a></p>
            </div>
        </div>
    </body>
</html>