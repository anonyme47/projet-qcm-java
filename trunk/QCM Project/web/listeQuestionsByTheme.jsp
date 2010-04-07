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
			var index = document.getElementById('question').selectedIndex;
			if (index > 0) {
                            document.getElementById('question_' + index).style.display = 'block';
			}
		}
	</script>
    </head>
    <body>
        <div id="content">
            <jsp:include page="scripts/header.jsp" />

            <div id="body">
                <jsp:include page="scripts/menu_left.jsp" />

                <div id="contenu">
                    
                    <%
                    List<Question> questionsByThemeNewQuestionnaire = (List<Question>) request.getSession().getAttribute("questionsByThemeNewQuestionnaire");
                    Questionnaire newQuestionnaire = (Questionnaire) request.getSession().getAttribute("newQuestionnaire");
                        if(newQuestionnaire!=null){
                            out.print("<fieldset id='titre_questionnaire'><legend><strong>"+newQuestionnaire.getLibelle()+"</strong></legend></fieldset>");


                     %>

                     <label for="question">Sélectionner une question existante à ajouter dans votre questionnaire :</label>
                    <select name="question" id="question" onchange="display_question()">
                        <option></option>

                     <%
                            if(questionsByThemeNewQuestionnaire != null){
                                for(Question q : questionsByThemeNewQuestionnaire){
                                    out.println("<option value='"+q.getIdQuestion()+"'>"+q.getLibelle()+"</option>");
                                 }


                    %>
                    </select>





                    
                    <%
                                for(Question q : questionsByThemeNewQuestionnaire){
                                    out.println("<div id='question_"+q.getIdQuestion()+"' class='question_a_ajouter'>");
                                        out.println("<strong>Libelle de la question: "+q.getLibelle()+"</p><br/>");
                                        out.println("<p>Liste de ses réponses</p><br/>");
                                        out.println("<div>");

                                            List<Reponse> reponses = q.getReponses();
                                            if (reponses != null) {
                                                for (Reponse reponse : reponses) {
                                                    out.println("<p>Libelle : "+reponse.getLibelle()+"</p><br/>");
                                                    out.println("<p>Descriptif : "+reponse.getDescriptif()+"</p><br/>");
                                                    out.println("<p>Note : "+reponse.getNote()+"</p><br/>");
                                                    out.println("<p>Est correcte : "+reponse.estCorrecte()+"</p><br/>");
                                                }
                                            }



                                        out.println("</div>");
                                        out.println("<form action='' method='post' accept-charset='utf-8'>");
                                            out.println("<input type='hidden' name='idQuestionToAdd' value='"+q.getIdQuestion()+"'/>");
                                            out.println("<input type='hidden' name='action' value='applyToAddQuestionByTheme'/>");
                                            out.println("<input type='submit' value='Ajouter cette question'/>");
                                        out.println("</form>");
                                    out.println("</div>");
                                 }

                                    
                            }
                        }else{
                        out.println("Un questionnaire correspondant à vos critères existe déjà");
                        }
                    %>


                


                </div>
            </div>

            <div id="footer">
                <p>&copy; Copyright 2009 Ferrand &ndash; Rabarison &mdash; Design: Lou Ferrand &ndash; Maria Rabarison, <a href="#" title="Projet Java">DagoFly</a></p>
            </div>
        </div>
    </body>
</html>
