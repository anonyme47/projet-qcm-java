/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet.helper;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import modele.Questionnaire;
import util.QuestionnaireDAO;
import java.util.List;

/**
 *
 * @author marya
 */
public class MesQuestionnairesHelper extends RequestHelper{

    public MesQuestionnairesHelper(HttpServletRequest request) throws Exception {
        super(request);
    }

    public void setAttributeCreatedQuestionnairesByUser() throws SQLException{
        int idUser = getIdUser();
        /*
         List<Questionnaire> questionnaire = QuestionnaireDAO.getCreatedByUser(idUser);
         Map<Integer , String> mapQuestionnaires = new HashMap<Integer, String>();
         for(Questionnaire q: questionnaires){
            mapQuestionnaires.put(q.getIdQuestionnaire(), q.getLibelle());
         }
         * 
         */
    }

    @Override
    public void setAttributeInfoQuestionnaire() throws SQLException {
        Questionnaire questionnaire = QuestionnaireDAO.getById(Integer.parseInt(request.getParameter("questionnaire").toString()));
        request.setAttribute("questionnaire", questionnaire);
     }
    

}
