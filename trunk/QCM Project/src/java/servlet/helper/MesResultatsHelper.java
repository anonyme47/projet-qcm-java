/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet.helper;
import exception.*;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import modele.Questionnaire;
import util.QuestionnaireDAO;

/**
 *
 * @author marya
 */
public class MesResultatsHelper extends RequestHelper{

    public MesResultatsHelper(HttpServletRequest request) throws ExpiredSessionException, IOException{
        super(request);
    }

    public void setAttributeQuestionnairesPasses() throws SQLException{
        request.setAttribute("questionnairesPasses", getQuestionnairesPasseByUser(getIdUser()));
    }

    public void setAttributeCorrectionQuestionnaire() throws SQLException, UnauthorizedActionException {
        Questionnaire questionnaire = QuestionnaireDAO.getById(Integer.parseInt(request.getParameter("questionnaire").toString()));
        System.out.print(questionnaire);
        if(!userHasAlreadyPassedQuestionnaire(questionnaire)){
            throw new UnauthorizedActionException("Vous n'avez pas encore passé ce questionnaire");
        }
        request.setAttribute("questionnaire", questionnaire);
    }
    

}
