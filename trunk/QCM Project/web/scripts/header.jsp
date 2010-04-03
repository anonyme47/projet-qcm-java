
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modele.User" %>
<%
            User user = (User) request.getSession().getAttribute("user");
            if (user == null) {
                request.setAttribute("errorMessage", "Vous n'êtes pas connecté");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
%>

                <p id="top">Bienvenue <%= user.getPrenom() %> <%= user.getNom()%>, <a href="Accueil?action=logout">Déconnexion</a></p>
                <div id="logo">
                    <h1><a href="index.jsp">iQCM</a></h1>
                </div>
                <ul id="menu">
                    <li><a href="accueil.jsp">Accueil</a></li>
                    <li><a href="#">Actualité</a></li>
                    <li><a href="#">A propos</a></li>
                    <li><a href="#">Contact</a></li>
                </ul>
                <div class="line"></div>