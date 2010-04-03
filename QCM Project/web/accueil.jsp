<%-- 
    Document   : accueil
    Created on : 27 mars 2010, 11:46:04
    Author     : Lou
--%>

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
                    <h4>Accueil d'iQCM</h4>
                    <div class="start-qcm">
                        <a href="ChoixQuestionnaire">Choisissez un questionnaire</a>
                    </div>
                    <div id="statistiques">
                        <p>Voici les derniers questionnaire auxquels vous avez répondu :
                            <ul class="liste">
                                <li>blablabla</li>
                                <li>blablabla</li>
                                <li>blablabla</li>
                                <li>blablabla</li>
                                <li>blablabla</li>
                            </ul>
                        </p>
                        <p>Ces questionnaire peuvent vous intéresser :
                            <ul class="liste">
                                <li>blablabla</li>
                                <li>blablabla</li>
                                <li>blablabla</li>
                                <li>blablabla</li>
                                <li>blablabla</li>
                            </ul>
                        </p>
                    </div>
                </div>
            </div>

            <div id="footer">
                <p>&copy; Copyright 2009 Ferrand &ndash; Rabarison &mdash; Design: Lou Ferrand &ndash; Maria Rabarison, <a href="#" title="Projet Java">DagoFly</a></p>
            </div>
        </div>
    </body>
</html>