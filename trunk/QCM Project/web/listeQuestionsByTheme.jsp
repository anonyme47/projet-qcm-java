<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modele.Questionnaire" %>
<%@page import="modele.Question" %>
<%@page import="modele.Reponse" %>
<%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" href="css/screen.css" type="text/css" media="screen" title="css" charset="utf-8" />
        <title>Projet QCM</title>
        <style type="text/css" media="screen">
            .question_a_ajouter {
                display: none;
            }
        </style>
        <script type="text/javascript" charset="utf-8">
            function display_question() {
                var questions = document.getElementsByClassName('question_a_ajouter');
                for (var i = 0; i < questions.length; i++) {
                    questions[i].style.display = 'none';
                }
                var index = document.getElementById('question').selectedIndex - 1;
                if (index >= 0) {
                    document.getElementById('question_' + index).style.display = 'block';
                }
            }
            function ajouter_reponse() {
                var liste_reponses = document.getElementById('liste_reponses');
                var newChild = document.createElement("p");
                newChild.innerHTML = "blablabla";
                console.log(liste_reponses.lastChild.lastChild);
                liste_reponses.lastChild.insertBefore(newChild, liste_reponses.lastChild);
            }
        </script>
    </head>
    <body>
        <div id="content">
            <jsp:include page="scripts/header.jsp" />

            <div id="body">
                <jsp:include page="scripts/menu_left.jsp" />

                <div id="contenu">
                    <fieldset id="modifier_reponses" class="">
                        <legend>Questions du questionnaire</legend>
                        <ul class="questions">
                            <li>bla bla bla bla</li>
                            <li>bla bla bla bla</li>
                            <li>bla bla bla bla</li>
                            <li>bla bla bla bla</li>
                            <li>bla bla bla bla</li>
                            <li>bla bla bla bla</li>
                            <li>bla bla bla bla</li>
                        </ul>
                    </fieldset>

                    <div class="panel_left">
                        <%
                                    List<Question> questionsByThemeNewQuestionnaire = (List<Question>) request.getSession().getAttribute("questionsByThemeNewQuestionnaire");
                                    Questionnaire newQuestionnaire = (Questionnaire) request.getSession().getAttribute("newQuestionnaire");
                                    if (newQuestionnaire != null) {
                                        out.print("<h1>Nouveau questionnaire : &laquo; " + newQuestionnaire.getLibelle() + " &raquo;</h1>");
                        %>


                        <label for="question">Sélectionner une question existante à ajouter dans votre questionnaire :</label>
                        <select name="question" id="question" onchange="display_question()">
                            <option>Choisissez une question à ajouter</option>
                            <option value="0">Ajouter une nouvelle question</option>

                            <%
                                                                    if (questionsByThemeNewQuestionnaire != null) {
                                                                        for (Question q : questionsByThemeNewQuestionnaire) {
                                                                            out.println("<option value='" + q.getIdQuestion() + "'>" + q.getLibelle() + "</option>");
                                                                        }
                            %>
                        </select>



                        <div id="reponses">
                            <form id="question_0" class="question_a_ajouter" action="#" method="post">
                                <table>
                                    <tr>
                                        <td>
                                            <label for="libelleQuestion">Libellé de la question : </label>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <textarea id="libelleQuestion" cols="50" rows="5"></textarea>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="nbReponses">Nombre de réponses à cette question</label>
                                        </td>
                                        <td>
                                            <input type="text" id="nbReponses" size="3" />
                                        </td>
                                    </tr>
                                </table>

                                <form action='' method='post' accept-charset='utf-8'>
                                    <input type='hidden' name='idQuestionToAdd' value='" + q.getIdQuestion() + "' />
                                    <input type='hidden' name='action' value='applyToAddQuestionByTheme' />
                                    <input class='button' type='submit' value='Ajouter les réponses' />
                                </form>
                            </form>


                            <%
                                                for (Question q : questionsByThemeNewQuestionnaire) {
                                                    out.println("<div id='question_" + q.getIdQuestion() + "' class='question_a_ajouter'>");

                                                    out.println("<table id='question_a_ajouter' class='liste center question-a-ajouter' border='1'>");
                                                    out.println("<tr>");
                                                    out.println("<th class='libelle'>Libellé</th>");
                                                    out.println("<th class='descriptif'>Descriptif</th>");
                                                    out.println("<th class='note'>Note</th>");
                                                    out.println("<th class='correcte'>Réponse correcte</th>");
                                                    out.println("</tr>");

                                                    List<Reponse> reponses = q.getReponses();
                                                    if (reponses != null) {
                                                        for (Reponse reponse : reponses) {
                                                            out.println("<tr>");
                                                            out.println("<td>" + reponse.getLibelle() + "</td>");
                                                            out.println("<td>" + reponse.getDescriptif() + "</td>");
                                                            out.println("<td>" + reponse.getNote() + "</td>");
                                                            out.println("<td>" + (reponse.estCorrecte() ? "Oui" : "Non") + "</td>");
                                                            out.println("</tr>");
                                                        }
                                                    }
                                                    out.println("</table>");

                                                    out.println("<form action='' method='post' accept-charset='utf-8'>");
                                                    out.println("<input type='hidden' name='idQuestionToAdd' value='" + q.getIdQuestion() + "' />");
                                                    out.println("<input type='hidden' name='action' value='applyToAddQuestionByTheme' />");
                                                    out.println("<input class='button' type='submit' value='Ajouter cette question' />");
                                                    out.println("</form>");
                                                    out.println("</div>");
                                                }
                                            }
                                        } else {
                                            out.println("Un questionnaire correspondant à vos critères existe déjà");
                                        }
                            %>
                        </div>

                    </div>
                </div>
            </div>

            <div id="footer">
                <p>&copy; Copyright 2009 Ferrand &ndash; Rabarison &mdash; Design: Lou Ferrand &ndash; Maria Rabarison, <a href="#" title="Projet Java">DagoFly</a></p>
            </div>
        </div>
    </body>
</html>
