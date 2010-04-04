<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map" %>
<%@page import="java.util.List" %>
<%@page import="modele.Reponse" %>
<%@page import="modele.Question" %>
<%@page import="modele.Qcm" %>
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
                    <fieldset id="modifier_reponses" class="">
                        <legend>Modifier mes réponses</legend>
                        <ul class="questions">
                            <%
                                        Question questionCourante = (Question) request.getAttribute("questionCourante");

                                        Map<Integer, String> questions = (Map) request.getSession().getAttribute("questions");
                                        if (questions != null) {
                                            for (Integer idQuestion : questions.keySet()) {
                                                if (questionCourante != null && questionCourante.getIdQuestion() == idQuestion) {
                                                    out.println("<li><strong>" + questions.get(idQuestion) + "</strong></li>");
                                                } else {
                                                    out.println("<li>" + questions.get(idQuestion) + "</li>");
                                                }
                                            }
                                        }
                            %>
                        </ul>
                    </fieldset>
                    <%
                        String titre_questionnaire = request.getSession().getAttribute("titreQuestionnaire").toString();
                        if(questionCourante!=null){
                    %>


                    <form class="question" action="PasserQuestionnaire?action=validerQuestion" method="post" accept-charset="utf-8">
                        <fieldset id="titre_questionnaire">
                            <legend><strong>Questionnaire : <%= titre_questionnaire %></strong></legend>
                            <p>
                                <%= questionCourante.getLibelle()%>
                            </p>
                        </fieldset>
                        <div id="reponses">
                            <%
                                        List<Reponse> reponses = questionCourante.getReponses();
                                        if (reponses != null) {
                                            for (Reponse reponse : reponses) {
                                                out.println("<input type='checkbox' name='reponses' value='"+reponse.getIdReponse()+"' /><label for='" + reponse.getIdReponse() + "'>" + reponse.getLibelle() + "</label><br />");
                                            }
                                        }
                            %>
                        </div>
                        <p><input type="submit" value="Valider la question" /></p>
                        <input type="hidden" name="idQuestion" value="<%= questionCourante.getIdQuestion() %>"/>
                    </form>
                    <div id="temps_restant">
                        <%
                        %>
                        <p>Il vous reste XX questions<br />et XX:XX minutes.</p>
                        <form action="PasserQuestionnaire" method="post" accept-charset="utf-8">
                            <input class="button" type="submit" value="Terminer maintenant &rarr;" />
                            <input type="hidden" name="action" value="terminer" />
                        </form>
                    </div>
                        <%
                            }else if(request.getAttribute("estFini")!=null){
                                out.println("Questionnaire fini");
                            }else{
                                out.println("Erreur");
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
