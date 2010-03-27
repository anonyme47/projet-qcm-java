<%-- 
    Document   : login
    Created on : 27 mars 2010, 11:35:45
    Author     : Lou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
                <form id="connexion_form" action="accueil.jsp" method="post" accept-charset="utf-8">
                    <fieldset id="connexion" class="">
                        <legend>Connexion</legend>
                        <p class="error">Vous n'avez pas les prérequis.</p>
                        <table>
                            <tr><td><label for="identifiant">Identifiant</label></td><td><input type="text" name="identifiant" value="" id="identifiant" size="27" /></td></tr>
                            <tr><td><label for="mot_de_passe">Mot de passe</label></td><td><input type="password" name="mot_de_passe" value="" id="mot_de_passe" size="27" /></td></tr>

                            <tr><td></td><td><input type="submit" value="Connexion" /></td></tr>
                        </table>

                    </fieldset>
                </form>
