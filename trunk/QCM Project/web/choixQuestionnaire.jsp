<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map" %>
<%@page import="modele.Niveau" %>
<%@page import="modele.Theme" %>
<%
            Integer theme = (Integer) request.getAttribute("theme");
            Integer niveau = (Integer) request.getAttribute("niveau");
%>
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
                    <div class="choice">
                        <p>Veuillez sélectionner le thème et / ou le niveau du questionnaire que vous souhaitez passer.</p>
                        <form id="choix_questionnaire_form" action="PasserQuestionnaire" method="post" accept-charset="utf-8">

                            <table class="no-border">
                                <tr>
                                    <td class="static"><label for="theme">Choisissez le thème : </label></td>
                                    <td>
                                        <select name="theme" id="theme" class="medium-input" onchange="document.getElementById('choix_questionnaire_form').submit();">
                                            <option value="0"></option>
                                            <%
                                                        Map<Integer, Theme> themes = (Map<Integer, Theme>) request.getAttribute("themes");
                                                        if (themes != null) {
                                                            for (Integer idTheme : themes.keySet()) {
                                                                out.println("<option value='" + idTheme + "'");
                                                                if (idTheme == theme) {
                                                                    out.print(" selected='selected' ");
                                                                }
                                                                out.print(">" + themes.get(idTheme).getLibelle() + "</option>");
                                                            }
                                                        }
                                            %>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="static"><label for="niveau">Choisissez le niveau : </label></td>
                                    <td>
                                        <select name="niveau" id="niveau" class="medium-input" onchange="document.getElementById('choix_questionnaire_form').submit();">
                                            <option value="0"></option>
                                            <%
                                                        Map<Integer, Niveau> niveaux = (Map) request.getAttribute("niveaux");
                                                        if (niveaux != null) {
                                                            for (Integer idNiveau : niveaux.keySet()) {
                                                                out.println("<option value='" + idNiveau + "'");
                                                                if (idNiveau == niveau) {
                                                                    out.print(" selected='selected' ");
                                                                }
                                                                out.print(">" + niveaux.get(idNiveau).getLibelle() + "</option>");
                                                            }
                                                        }
                                            %>
                                        </select>
                                    </td>
                                </tr>
                            </table>

                            <input type="hidden" name="action" value="choixQuestionnaire"/>
                        </form>
                    </div>
                    <div class="line"></div>

                    <h4 id="liste_questionnaires">Liste des questionnaires</h4>
                    <%
                                Map<Integer, String> questionnaires = (Map) request.getAttribute("questionnaires");
                                if (questionnaires != null) {
                                    out.println("<p>Cliquez sur un questionnaire pour le commencer.</p>");
                                    out.println("<ol class='liste'>");
                                    for (Integer idQuestionnaire : questionnaires.keySet()) {
                                        out.println("<a href='PasserQuestionnaire?action=afficherInfoQuestionnaire&questionnaire=" + idQuestionnaire + "'><li>" + questionnaires.get(idQuestionnaire) + "</li></a>");
                                    }
                                    out.println("</ol>");
                                } else {
                                    out.println("<p>Choisissez un thème et/ou un niveau</p>");
                                }
                    %>
                </div>
            </div>

            <!-- <img src="choisirQuestionnaire2.png" width="" height="" alt="" /> -->

            <div id="footer">
                <p>&copy; Copyright 2009 Ferrand &ndash; Rabarison &mdash; Design: Lou Ferrand &ndash; Maria Rabarison, <a href="#" title="Projet Java">DagoFly</a></p>
            </div>
        </div>
    </body>
</html>
