/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet.helper;
import exception.*;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import modele.Qcm;
import modele.User;
import util.*;
/**
 *
 * @author marya
 */
public class PasserQuestionnaireHelper extends RequestHelper{

    public PasserQuestionnaireHelper(HttpServletRequest request) throws Exception{
        super(request);
    }

    
    /**
     * Permet de recupérer tous les questinnaires correspondant à un choix
     * et de les mettre en attribut questionnaires
     * @param request
     * @throws SQLException
     */
    public void setAttributeQuestionnairesByChoice() throws SQLException{
        HashMap<Integer,String> questionnaires= null;
        Integer theme = Integer.parseInt(request.getParameter("theme").toString());
        Integer niveau = Integer.parseInt(request.getParameter("niveau").toString());

            if(theme==null || theme<0 ){
                throw new IllegalArgumentException("Veuillez selectionner un thème");
            }else if(niveau==null || niveau<0){
                throw new IllegalArgumentException("Veuillez selectionner un niveau");
            }else if(theme==0){
                request.setAttribute("niveau",niveau);
                questionnaires = QuestionnaireDAO.getQuestionnairesByNiveau(niveau);
            }else if(niveau==0){
                request.setAttribute("theme", theme);
                questionnaires = QuestionnaireDAO.getQuestionnairesByTheme(theme);
            }else {
                request.setAttribute("theme", theme);
                request.setAttribute("niveau",niveau);
                questionnaires = QuestionnaireDAO.getQuestionnairesByThemeAndNiveau(theme, niveau);
            }
            setAttributeNiveaux();
            setAttributeThemes();
            request.setAttribute("questionnaires", questionnaires);
    }



    public void setSessionAttributeQcm() throws SQLException,Exception{
        int idQuestionnaire = Integer.parseInt(request.getParameter("questionnaire").toString());
        int idUser = ((User) request.getSession().getAttribute("user")).getIdUser();
        Qcm qcm = new Qcm(idQuestionnaire, idUser);
        if(qcm==null){
            throw QcmException.UnknowQuestionnaireException;
        }
        request.getSession().setAttribute("qcm", qcm);
        request.getSession().setAttribute("titreQuetionnaire", QuestionnaireDAO.getById(idQuestionnaire).getLibelle());
        request.getSession().setAttribute("questions", qcm.getQuestions());
        request.setAttribute("questionCourante", qcm.getQuestionCourante());
        
    }
}
