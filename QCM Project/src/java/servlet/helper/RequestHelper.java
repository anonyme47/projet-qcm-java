/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet.helper;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import util.*;
import exception.*;

/**
 *
 * @author marya
 */
public class RequestHelper {

    protected HttpServletRequest request;

    public RequestHelper(HttpServletRequest request) throws Exception{
        this.request=request;
        if(!isUserAuthentificated()){
            throw QcmException.ExpiredSessionException;
        }
    }


    /**
     * Vérifie si la session de l'utilisateur a été initialisée
     * @param request, Request sur laquelle on va testé l'existence de la session
     * @return true si la session n'est pas null, false sinon
     */
    public boolean isUserAuthentificated() {
        return request.getSession().getAttribute("user") != null;
    }


    /**
     * Initialise les attributs theme et niveau
     * @param request
     * @param idtheme
     * @param idNiveau
     * @throws SQLException
     */
    public void setAttributeThemeAndNiveau(int idtheme, int idNiveau) throws SQLException{
         request.setAttribute("theme", ThemeDAO.getById(idtheme).getLibelle());
         request.setAttribute("niveau", NiveauDAO.getById(idNiveau).getLibelle());
    }


    /**
     * Initialise l'attribut contenant tous les themes
     * @param request
     * @throws SQLException
     */
    public void setAttributeThemes() throws SQLException{
        request.setAttribute("themes", ThemeDAO.getAll());
    }


    /**
     * Initialise l'attribut contenant tous les niveaux
     * @param request
     * @throws SQLException
     */
    public void setAttributeNiveaux() throws SQLException{
        request.setAttribute("niveaux", NiveauDAO.getAll());
    }

    /**
     * Initialise les attributes contenant tous les themes et les niveaux
     * @param request
     * @throws SQLException
     */
    public void setAttributeThemesAndNiveaux() throws SQLException{
        setAttributeThemes();
        setAttributeNiveaux();
    }

    

    



}
