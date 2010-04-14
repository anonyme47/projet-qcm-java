<%-- 
    Document   : menu_left
    Created on : 27 mars 2010, 11:37:22
    Author     : Lou
--%>
<%@page import="modele.User" %>
<%
            User user = (User) request.getSession().getAttribute("user");
            if (user == null) {
                request.setAttribute("errorMessage", "Vous n'êtes pas connecté");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
                <div id="navigation">
                </div>


                <div id="navigation">
                    <ul class="menu_gauche">
                        <a href="PasserQuestionnaire?action=afficherChoixThemesNiveau"><li>Passer un questionnaire</li></a>
                        <a href="CreerQuestionnaire?action=applyToCreate"><li>Créer un questionnaire</li></a>
                        <a href="MesQuestionnaires?action=getCreatedQuestionnaires"><li>Mes questionnaires</li></a>
                        <a href="MesResultats?action=getQuestionnairesPasseByUser"><li>Mes résultats</li></a>
                        <a href="Accueil?action=logout"><li>Déconnexion</li></a>
                    </ul>
            <%
                if (user.getStatut().getLibelle().equals("Administrateur")) {
            %>
                    <ul class="menu_gauche"><h5>Admin</h5>
                        <a href="Admin?action=gererThemes"><li>Gérer les thèmes</li></a>
                        <a href="Admin?action=gererNiveaux"><li>Gérer les niveau</li></a>
                        <a href="Admin?action=gererQuestionnaires"><li>Gérer les questionnaires</li></a>
                        <a href="Admin?action=gererUtilisateurs"><li>Gérer les utilisateurs</li></a>
                    </ul>
            <% }%>
                </div>
