<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modele.Questionnaire" %>
<%@page errorPage="index.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" href="css/screen.css" type="text/css" media="screen" title="css" charset="utf-8" />
        <title>Projet QCM - Attention</title>
    </head>
    <body>
        <div id="content">
            <jsp:include page="scripts/header.jsp" />

            <div id="body">
                <jsp:include page="scripts/menu_left.jsp" />

                <div id="contenu">
                    <h3>Attention : veuillez lire ceci avant de débuter votre questionnaire</h3>
                    <div class="warning-qcm">

                        <p><img id="warning-image" src="img/warning.gif" alt="Attention" height="40px" />Vous êtes sur le point de passer un questionnaire et il y a certains points sur lesquels nous nous sentons obligés de vous informer :</p>
                        <ul>
                            <li>Certains questionnaires ont une limite de temps, vous ne pourrez plus répondre aux questions passé cette limite et votre note sera automatiquement calculée en fonction des réponses que vous aurez déjà données;</li>
                            <li>Vous pouvez choisir de terminer le questionnaire à tout moment en cliquant sur le bouton "Terminer maintenant", le questionnaire s'arrêtera et votre note sera calculée;</li>
                        </ul>
                        <%
                                    Questionnaire questionnaire = (Questionnaire) request.getAttribute("questionnaire");
                                    if (questionnaire != null) {

                        %>
                        <div class="recapitule_questionnaire liste">
                            <h5>Récapitulé du questionnaire</h5>
                            <table>
                                <tr>
                                    <td class="static">Titre</td>
                                    <td><%=questionnaire.getLibelle()%></td>
                                </tr>
                                <tr>
                                    <td class="static">Thème</td>
                                    <td><%=request.getAttribute("theme").toString()%></td>
                                </tr>
                                <tr>
                                    <td class="static">Niveau</td>
                                    <td><%=request.getAttribute("niveau").toString()%></td>
                                </tr>
                                <tr>
                                    <td class="static">Nombre de questions</td>
                                    <td><%=questionnaire.getQuestions().size()%></td>
                                </tr>
                                <tr>
                                    <td class="static">Temps accordé</td>
                                    <td><%=questionnaire.getLimiteTemps()%> minutes</td>
                                </tr>
                            </table>
                        </div>
                        <%
                                    }
                        %>


                        <a href="Accueil" class="button">Retourner à l'accueil</a>

                        <form action="PasserQuestionnaire" method="post" id="commencer_qcm_form">
                            <input type="hidden" name="questionnaire" value="<%= questionnaire.getIdQuestionnaire()%>" />
                            <input type="hidden" name="action" value="commencerQcm" />
                            <input type="submit" value="Commencer" class="button" />
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