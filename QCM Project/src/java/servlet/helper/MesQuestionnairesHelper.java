/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet.helper;

import exception.ExpiredSessionException;
import exception.UnauthorizedActionException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import modele.Questionnaire;
import util.QuestionnaireDAO;
import java.util.List;
import java.util.Map;
import modele.User;

/**
 *
 * @author marya
 */
public class MesQuestionnairesHelper extends RequestHelper{

    public MesQuestionnairesHelper(HttpServletRequest request) throws ExpiredSessionException, IOException {
        super(request);
    }

    public void setAttributeCreatedQuestionnairesByUser() throws SQLException{
        int idUser = getIdUser();
        
         List<Questionnaire> questionnaires = QuestionnaireDAO.getCreatedByUser(idUser);
         Map<Integer , String> mapQuestionnaires = new HashMap<Integer, String>();
         System.out.print(questionnaires);
         for(Questionnaire q: questionnaires){
            mapQuestionnaires.put(q.getIdQuestionnaire(), q.getLibelle());
            System.out.print(q);
         }
         request.setAttribute("mapQuestionnaires", mapQuestionnaires);
    }

    public void setAttributeEditableQuestionnaire() throws SQLException, UnauthorizedActionException {
        Questionnaire questionnaire = QuestionnaireDAO.getById(Integer.parseInt(request.getParameter("questionnaire").toString()));
        int idUser = getIdUser();
        if(idUser != questionnaire.getIdUser()){
            throw new UnauthorizedActionException("Vous n'avez pas le droit d'éditer ce questionnaire car vous n'êtes pas son créateur.");
        }
        request.setAttribute("questionnaire", questionnaire);
     }
    

}
