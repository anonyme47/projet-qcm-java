/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet.helper;

import exception.ExpiredSessionException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import modele.Questionnaire;
import util.QuestionnaireDAO;
import java.util.List;
import java.util.Map;

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

    @Override
    public void setAttributeInfoQuestionnaire() throws SQLException {
        Questionnaire questionnaire = QuestionnaireDAO.getById(Integer.parseInt(request.getParameter("questionnaire").toString()));
        request.setAttribute("questionnaire", questionnaire);
     }
    

}
