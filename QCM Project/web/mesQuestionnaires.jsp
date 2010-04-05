<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map" %>
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
                    <h4>Mes questionnaires passés</h4>
                    <%
                        Map<Integer , String> questionnaires = (Map<Integer , String>) request.getAttribute("mapQuestionnaires");
                        if(questionnaires != null && !questionnaires.isEmpty()){

                            out.println("<ol>");
                            for(Integer i : questionnaires.keySet()){
                            %>
                                <li><%= questionnaires.get(i) %></li>
                            <%
                            }
                            out.println("</ol>");
                        }
                    %>
                </div>
                <form action="MesQuestionnaires" method="post" id="getInfoCreatedQuestionnaire_form">
                    <input type="hidden" name="questionnaire" value=""/>
                    <input type="hidden" name="action" value="getInfoCreatedQuestionnaire" />
                    
                </form>
            </div>

            <div id="footer">
                <p>&copy; Copyright 2009 Ferrand &ndash; Rabarison &mdash; Design: Lou Ferrand &ndash; Maria Rabarison, <a href="#" title="Projet Java">DagoFly</a></p>
            </div>
        </div>
    </body>
</html>