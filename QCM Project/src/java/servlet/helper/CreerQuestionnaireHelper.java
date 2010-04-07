/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet.helper;

import exception.ExpiredSessionException;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import modele.Questionnaire;
import util.QuestionDAO;
import util.QuestionnaireDAO;

/**
 *
 * @author marya
 */
public class CreerQuestionnaireHelper extends RequestHelper{
    
    public CreerQuestionnaireHelper(HttpServletRequest request) throws ExpiredSessionException, IOException {
        super(request);
    }

    public void setSessionAttributeNewQuestionnaire() throws SQLException{
        String libelle = request.getParameter("libelle").toString();
        int idTheme = Integer.parseInt(request.getParameter("theme"));
        int idNiveau = Integer.parseInt(request.getParameter("niveau"));
        Questionnaire existeQuestionnaire = QuestionnaireDAO.search(idTheme, idNiveau, libelle);
        if(existeQuestionnaire == null){
            Questionnaire newQuestionnaire = new Questionnaire(libelle, idTheme, getIdUser(), idNiveau);
            setAttributeQuestionsByThemeNewQuestionnaire(newQuestionnaire.getIdTheme());
            request.getSession().setAttribute("newQuestionnaire", newQuestionnaire);
            
        }
    }

    private void setAttributeQuestionsByThemeNewQuestionnaire(int idThemeQuestionnaire) throws SQLException{
        request.getSession().setAttribute("questionsByThemeNewQuestionnaire", QuestionDAO.getByTheme(idThemeQuestionnaire));
    }

}
