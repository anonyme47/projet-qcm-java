<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modele.Questionnaire" %>
<%@page import="modele.Qcm" %>
<%@page import="modele.Question" %>
<%@page import="modele.Reponse" %>
<%@page import="java.util.List" %>

<%@page import="java.util.Map" %>
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
                            Qcm qcm = (Qcm) request.getSession().getAttribute("qcm");
                            int questionRepondues = 0;
                            int nbQuestionsTotal = qcm.getQuestionnaire().getQuestions().size();
                            int noteMax = qcm.getQuestionnaire().getNoteMax();
                            Integer note = (Integer) request.getAttribute("note");

                            List<Question> questions = qcm.getQuestionnaire().getQuestions();
                            for (Question question : questions) {
                                List<Integer> userRep = qcm.getUserReponses().get(question.getIdQuestion());
                                if (!userRep.isEmpty()) {
                                    questionRepondues++;
                                }
                            }

                %>

                <div id="contenu">
                    <h4 id="liste">Résultats pour ce questionnaire</h4>
                    <div id="score">
                        <p>Votre note : <br /><span class="score_value <%= (note < noteMax / 2) ? "mauvais" : "bon"%>"><%= note%> / <%= noteMax%></span></p>
                    </div>
                    <div class="recapitule_questionnaire">
                        <h5>Récapitulatif du questionnaire</h5>
                        <table>
                            <tr>
                                <td class="static">Titre</td>
                                <td><%= qcm.getQuestionnaire().getLibelle()%></td>
                            </tr>
                            <tr>
                                <td class="static">Thème</td>
                                <td><%= request.getAttribute("theme")%></td>
                            </tr>
                            <tr>
                                <td class="static">Niveau</td>
                                <td><%= request.getAttribute("niveau")%></td>
                            </tr>
                            <tr>
                                <td class="static">Questions répondues</td>
                                <td><%= questionRepondues%> / <%= nbQuestionsTotal%></td>
                            </tr>
                            <tr>
                                <td class="static">Temps utilisé</td>
                                <td>50 secondes</td>
                            </tr>
                        </table>
                    </div>

                    <dl id="resultat" class="liste_recapitulatif">
                        <%
                                    for (Question question : questions) {
                                        out.println("<dt>&Eacute;noncé : " + question.getLibelle() + "</dt>");
                                        List<Reponse> rep = question.getReponses();
                                        List<Integer> userRep = qcm.getUserReponses().get(question.getIdQuestion());
                                        if (!userRep.isEmpty()) {
                                            out.println("<dd>Vos réponses");
                                            out.println("<ul>");
                                            for (int j = 0; j < rep.size(); j++) {
                                                Reponse reponse = rep.get(j);
                                                int idDansRep = reponse.getIdReponse();

                                                if (userRep.contains(idDansRep)) {
                                                    if (reponse.estCorrecte()) {
                                                        out.println("<li class='bon'>" + reponse.getLibelle() + " (+" + reponse.getNote() + " points)</li>");
                                                    } else {
                                                        out.println("<li class='mauvais'>" + reponse.getLibelle() + " (" + reponse.getDescriptif() + ")</li>");
                                                    }
                                                }
                                            }
                                            out.println("</ul></dd>");
                                        } else {
                                            out.println("<dd class='mauvais'>Vous n'avez pas répondu à cette question</dd>");
                                        }
                                    }
                        %>
                    </dl>
                    <a href="Accueil?action=retourAccueil">&laquo; Retour à l'accueil</a>
                </div>
            </div>

            <div id="footer">
                <p>&copy; Copyright 2009 Ferrand &ndash; Rabarison &mdash; Design: Lou Ferrand &ndash; Maria Rabarison, <a href="#" title="Projet Java">DagoFly</a></p>
            </div>
        </div>
    </body>
</html>