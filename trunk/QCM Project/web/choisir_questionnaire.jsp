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
                    <div id="choix_questionnaire">
                        <p>blablablabl blablabla</p>
                        <label for="theme_choix">Choisissez le thème</label>
                        <select name="theme_choix" id="theme_choix" onchange="">
                            <option value="1">Java</option>
                            <option value="2">Ruby</option>
                            <option value="3">C++</option>
                            <option value="4">Test</option>
                        </select>

                        <label for="niveau_choix">Choisissez le niveau</label>
                        <select name="niveau_choix" id="niveau_choix">
                            <option value="1">Débutant</option>
                            <option value="2">Avancé</option>
                            <option value="3">Expert</option>
                        </select>
                        <br />
                    </div>
                    <div class="line"></div>

                    <h4 id="liste_questionnaires">Liste des questionnaires</h4>
                    <p>Cliquez sur un questionnaire pour le commencer.</p>
                    <ol class="liste">
                        <a href="warning.jsp"><li>Questionnaire numéro 1 : [Java Avancé]</li></a>
                        <a href="passer_questionnaire.jsp"><li>Questionnaire numéro 2 : [Java Débutant]</li></a>
                        <a href="passer_questionnaire.jsp"><li>Questionnaire numéro 3 : [Java Avancé]</li></a>
                        <a href="passer_questionnaire.jsp"><li>Questionnaire numéro 4 : [Ruby Expert]</li></a>
                        <a href="passer_questionnaire.jsp"><li>Questionnaire numéro 5 : [C++ Expert]</li></a>
                        <a href="passer_questionnaire.jsp"><li>Questionnaire numéro 6 : [Ruby Débutant]</li></a>
                        <a href="passer_questionnaire.jsp"><li>Questionnaire numéro 7 : [Java Expert]</li></a>
                        <a href="passer_questionnaire.jsp"><li>Questionnaire numéro 8 : [C++ Avancé]</li></a>
                    </ol>
                </div>
            </div>

            <!-- <img src="choisirQuestionnaire2.png" width="" height="" alt="" /> -->

            <div id="footer">
                <p>&copy; Copyright 2009 Ferrand &ndash; Rabarison &mdash; Design: Lou Ferrand &ndash; Maria Rabarison, <a href="#" title="Projet Java">DagoFly</a></p>
            </div>
        </div>
    </body>
</html>