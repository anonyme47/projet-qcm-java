<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map" %>
<%@page import="java.util.List" %>
<%@page import="modele.Reponse" %>
<%@page import="modele.Question" %>
<%@page import="modele.Questionnaire" %>
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
                    <%
                                Questionnaire questionnaire = (Questionnaire) request.getAttribute("questionnaire");

                                if (questionnaire != null) {%>
                    <h1><%=questionnaire.getLibelle()%></h1>
                    <a href="MesResultats?action=getQuestionnairesPasseByUser">&laquo; Retour</a>
                    <ol id="info_questionnaire">
                        <%
                                                            for (Question question : questionnaire.getQuestions()) {
                                                                out.println("<li>" + question.getLibelle() + "<ul class='liste'>");
                                                                for (Reponse reponse : question.getReponses()) {
                                                                    out.println("<li>");
                                                                    if (reponse.estCorrecte()) {
                                                                        out.println("<strong class='bon'>" + reponse.getLibelle());
                                                                        out.println(" (" + reponse.getDescriptif() + ")</strong>");
                                                                    } else {
                                                                        out.println(reponse.getLibelle());
                                                                        out.println(" (" + reponse.getDescriptif() + ")");
                                                                    }
                                                                    out.println("</li>");
                                                                }
                                                                out.println("</ul></li>");
                                                            }
                        %>
                    </ol>
                    <%}
                    %>
                </div>
            </div>

            <div id="footer">
                <p>&copy; Copyright 2009 Ferrand &ndash; Rabarison &mdash; Design: Lou Ferrand &ndash; Maria Rabarison, <a href="#" title="Projet Java">DagoFly</a></p>
            </div>
        </div>
    </body>
</html>
