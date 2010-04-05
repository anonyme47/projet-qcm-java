<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map" %>
<%@page import="modele.Niveau" %>
<%@page import="modele.Theme" %>
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
                    <div id="choix_questionnaire">
                        <p>blablablabl blablabla</p>
                        <form id="choix_questionnaire_form"  action="CreerQuestionnaire" method="post" accept-charset="utf-8">
                            <label for="theme">Choisissez le thème</label>
                            <select name="theme" id="theme" >
                                <option value="0"/>
                                <%
                                            Map<Integer, Theme> themes = (Map<Integer,Theme>) request.getAttribute("themes");
                                            if (themes != null) {
                                                for (Integer idTheme : themes.keySet()) {
                                                    out.println("<option value='" + idTheme + "'");
                                                    out.print(">" + themes.get(idTheme).getLibelle() + "</option>");
                                                }
                                            }
                                %>
                            </select>

                            <label for="niveau">Choisissez le niveau</label>
                            <select name="niveau" id="niveau">
                                <option value="0"/>
                                <%
                                            Map<Integer, Niveau> niveaux = (Map) request.getAttribute("niveaux");
                                            if (niveaux != null) {
                                                for (Integer idNiveau : niveaux.keySet()) {
                                                    out.println("<option value='" + idNiveau + "'");
                                                    out.print(">" + niveaux.get(idNiveau).getLibelle() + "</option>");
                                                }
                                            }
                                %>
                            </select>
                            <br/>
                            <input type="text" name="libelle" value="" />
                            <input type="hidden" name="action" value="createQuestionnaire"/>
                            <br/><br/>
                            <input type="submit" value="Commencer" />
                        </form>

                        <br />
                    </div>
                    <div class="line"></div>

                   

                </div>
            </div>

            <!-- <img src="choisirQuestionnaire2.png" width="" height="" alt="" /> -->

            <div id="footer">
                <p>&copy; Copyright 2009 Ferrand &ndash; Rabarison &mdash; Design: Lou Ferrand &ndash; Maria Rabarison, <a href="#" title="Projet Java">DagoFly</a></p>
            </div>
        </div>
    </body>
</html>
