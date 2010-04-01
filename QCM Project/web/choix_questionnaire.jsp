<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map" %>
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
                    <div id="choix_questionnaire">
                        <p>blablablabl blablabla</p>
                        <form id="choix_questionnaire_form"  action="ChoixQuestionnaire" method="post" accept-charset="utf-8">
                            <label for="theme">Choisissez le thème</label>
                            <select name="theme" id="theme" onchange="document.getElementById('choix_questionnaire_form').submit();">
                                <option value="0"/>
                                <%
                                    Map<Integer, String> themes = (Map) request.getAttribute("themes");
                                    if(themes!=null){
                                        for(Integer id_theme : themes.keySet()){
                                            out.println("<option value='"+id_theme+"'");
                                            if(id_theme==theme) out.print(" selected='selected' ");
                                            out.print(">"+themes.get(id_theme)+"</option>");
                                        }
                                    }
                                %>
                             </select>

                            <label for="niveau">Choisissez le niveau</label>
                            <select name="niveau" id="niveau" onchange="document.getElementById('choix_questionnaire_form').submit();">
                                <option value="0"/>
                                <%
                                    Map<Integer, String> niveaux= (Map) request.getAttribute("niveaux");
                                    if(niveaux!=null){
                                        for(Integer id_niveau : niveaux.keySet()){
                                            out.println("<option value='"+id_niveau+"'");
                                            if(id_niveau==niveau) out.print(" selected='selected' ");
                                            out.print(">"+niveaux.get(id_niveau)+"</option>");
                                        }
                                    }
                                %>
                            </select>
                        </form>
                        
                        <br />
                    </div>
                    <div class="line"></div>

                    <h4 id="liste_questionnaires">Liste des questionnaires</h4>
                    
                    
                    <%
                        Map<Integer, String> questionnaires = (Map) request.getAttribute("questionnaires");
                        if(questionnaires!=null){
                            out.println("<p>Cliquez sur un questionnaire pour le commencer.</p>");
                            out.println("<ol class='liste'>");
                            for(Integer idQuestionnaire : questionnaires.keySet()){
                                out.println("<a href='Warning?questionnaire="+idQuestionnaire+"'><li>"+questionnaires.get(idQuestionnaire)+"</li></a>");
                            }
                            out.println("</ol>");
                        }else{
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