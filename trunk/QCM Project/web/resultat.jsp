<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

                <div id="contenu">
                    <h4 id="liste">Résultats pour ce questionnaire</h4>
                    <div id="score">
                        <p>Votre note : <span class="score_value mauvais">10%</span></p>
                    </div>
                    <div class="recapitule_questionnaire">
                        <h5>Récapitulé du questionnaire</h5>
                        <table>
                            <tr>
                                <td class="static">Titre</td>
                                <td>Questionnaire numéro 1 : [Java Avancé]</td>
                            </tr>
                            <tr>
                                <td class="static">Thème</td>
                                <td>Java</td>
                            </tr>
                            <tr>
                                <td class="static">Niveau</td>
                                <td>Débutant</td>
                            </tr>
                            <tr>
                                <td class="static">Questions répondues</td>
                                <td>2 / 20</td>
                            </tr>
                            <tr>
                                <td class="static">Temps utilisé</td>
                                <td>50 secondes</td>
                            </tr>
                        </table>
                    </div>
                    <!-- <a href="accueil.html">Retour à l'accueil</a> -->
                    <p>Questions répondues : <br />Temps utilisé : </p>

                    <dl id="resultat" class="liste">
                        <!-- foreach question dans le questionnaire -->
                        <dt>Question 1</dt>
                        <dd>La réponse de l'utilisateur puis la vraie réponse</dd>
                        <dt>Question 2</dt>
                        <dd>La réponse de l'utilisateur puis la vraie réponse</dd>
                        <dt>Question 3</dt>
                        <dd>Vous n'avez pas répondu à cette question</dd>
                        <dt>Question 4</dt>
                        <dd>Vous n'avez pas répondu à cette question</dd>
                        <dt>Question 5</dt>
                        <dd>Vous n'avez pas répondu à cette question</dd>
                        <dt>Question 6</dt>
                        <dd>Vous n'avez pas répondu à cette question</dd>
                        <dt>Question 7</dt>
                        <dd>Vous n'avez pas répondu à cette question</dd>
                        <dt>Question 8</dt>
                        <dd>Vous n'avez pas répondu à cette question</dd>
                        <dt>Question 9</dt>
                        <dd>Vous n'avez pas répondu à cette question</dd>
                        <dt>Question 10</dt>
                        <dd>Vous n'avez pas répondu à cette question</dd>
                        <dt>Question 11</dt>
                        <dd>Vous n'avez pas répondu à cette question</dd>
                        <dt>Question 12</dt>
                        <dd>Vous n'avez pas répondu à cette question</dd>
                        <dt>Question 13</dt>
                        <dd>Vous n'avez pas répondu à cette question</dd>
                        <dt>Question 14</dt>
                        <dd>Vous n'avez pas répondu à cette question</dd>
                        <dt>Question 15</dt>
                        <dd>Vous n'avez pas répondu à cette question</dd>
                        <dt>Question 16</dt>
                        <dd>Vous n'avez pas répondu à cette question</dd>
                        <dt>Question 17</dt>
                        <dd>Vous n'avez pas répondu à cette question</dd>
                        <dt>Question 18</dt>
                        <dd>Vous n'avez pas répondu à cette question</dd>
                        <dt>Question 19</dt>
                        <dd>Vous n'avez pas répondu à cette question</dd>
                        <dt>Question 20</dt>
                        <dd>Vous n'avez pas répondu à cette question</dd>
                    </dl>
                    <a href="accueil.jsp">&laquo; Retour à l'accueil</a>
                </div>
            </div>

            <div id="footer">
                <p>&copy; Copyright 2009 Ferrand &ndash; Rabarison &mdash; Design: Lou Ferrand &ndash; Maria Rabarison, <a href="#" title="Projet Java">DagoFly</a></p>
            </div>
        </div>
    </body>
</html>