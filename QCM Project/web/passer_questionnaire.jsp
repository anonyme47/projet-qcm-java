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
                    <fieldset id="modifier_reponses" class="">
                        <legend>Modifier mes réponses</legend>
                        <ul class="questions">
                            <a href="#"><li>titre question 1</li></a>
                            <a href="#"><li>titre question 2</li></a>
                            <a href="#"><li>titre question 3</li></a>
                            <a href="#"><li>titre question 1</li></a>
                            <a href="#"><li>titre question 2</li></a>
                            <a href="#"><li>titre question 3</li></a>
                            <a href="#"><li>titre question 1</li></a>
                            <a href="#"><li>titre question 2</li></a>
                            <a href="#"><li>titre question 3</li></a>
                            <a href="#"><li>titre question 1</li></a>
                            <a href="#"><li>titre question 2</li></a>
                            <a href="#"><li>titre question 3</li></a>
                            <a href="#"><li>titre question 1</li></a>
                            <a href="#"><li>titre question 2</li></a>
                            <a href="#"><li>titre question 3</li></a>
                            <a href="#"><li>titre question 1</li></a>
                            <a href="#"><li>titre question 2</li></a>
                            <a href="#"><li>titre question 3</li></a>
                            <a href="#"><li>titre question 1</li></a>
                            <a href="#"><li>titre question 2</li></a>
                            <a href="#"><li>titre question 3</li></a>
                            <a href="#"><li>titre question 1</li></a>
                            <a href="#"><li>titre question 2</li></a>
                            <a href="#"><li>titre question 3</li></a>
                            <a href="#"><li>titre question 1</li></a>
                            <a href="#"><li>titre question 2</li></a>
                            <a href="#"><li>titre question 3</li></a>
                        </ul>
                    </fieldset>
                    <form class="question" action="passer_questionnaire_suite.jsp" method="post" accept-charset="utf-8">
                        <fieldset id="titre_questionnaire" class="">
                            <legend><strong>Questionnaire numéro 1 : [Java Avancé]</strong></legend>
                            <p>
				Java est un langage
                            </p>
                        </fieldset>
                        <div id="reponses">
                            <input type="checkbox" name="reponse1" value="{id_reponse1}" id="reponse_1" /><label for="reponse_1">Compilé</label><br />
                            <input type="checkbox" name="reponse2" value="{id_reponse2}" id="reponse_2" /><label for="reponse_2">Interprété</label><br />
                            <input type="checkbox" name="reponse3" value="{id_reponse3}" id="reponse_3" /><label for="reponse_3">Compilé et interprété</label><br />
                            <input type="checkbox" name="reponse4" value="{id_reponse4}" id="reponse_4" /><label for="reponse_4">Ni compilé ni interprété</label><br />
                        </div>
                        <p><input type="submit" value="Valider la question" /></p>
                    </form>
                    <a class="button" href="resultat.jsp">Terminer maintenant &rarr;</a>
                    <div id="temps_restant">
                        <p>Il vous reste XX questions<br />et XX:XX minutes.</p>
                    </div>
                </div>
            </div>

            <div id="footer">
                <p>&copy; Copyright 2009 Ferrand &ndash; Rabarison &mdash; Design: Lou Ferrand &ndash; Maria Rabarison, <a href="#" title="Projet Java">DagoFly</a></p>
            </div>
        </div>
    </body>
</html>