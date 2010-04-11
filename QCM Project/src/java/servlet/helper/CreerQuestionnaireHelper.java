/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet.helper;

import exception.ExpiredSessionException;
import exception.UnauthorizedActionException;
import exception.UnknownNiveauException;
import exception.UnknownQuestionnaireException;
import exception.UnknownThemeException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modele.Question;
import modele.Questionnaire;
import modele.Reponse;
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

    public void setSessionAttributeNewQuestionnaire() throws SQLException, UnknownThemeException , UnknownNiveauException{
        String libelle = request.getParameter("libelle").toString();

        if(request.getParameter("theme") == null){
            throw new UnknownThemeException("Merci de spécifier le thème de votre questionnaire");
        }else if(request.getParameter("niveau") == null){
            throw new UnknownNiveauException("Merci de spécifier le niveau");
        }else if(libelle.trim().isEmpty()){
            new UnknownQuestionnaireException("Merci de spécifier le libelle de votre questionnaire");
        }
        int idTheme = Integer.parseInt(request.getParameter("theme"));
        int idNiveau = Integer.parseInt(request.getParameter("niveau"));
        Questionnaire existeQuestionnaire = QuestionnaireDAO.search(idTheme, idNiveau, libelle);
        if(existeQuestionnaire == null){
            Questionnaire newQuestionnaire = new Questionnaire(libelle, idTheme, getIdUser(), idNiveau);
            setAttributeQuestionsByThemeNewQuestionnaire(newQuestionnaire.getIdTheme());
            request.getSession().setAttribute("newQuestionnaire", newQuestionnaire);
            
        }
    }

    private void setAttributeQuestionsByThemeNewQuestionnaire(int idThemeQuestionnaire) throws SQLException,UnknownThemeException{
        List<Question> questions = QuestionDAO.getByTheme(idThemeQuestionnaire);
        if(questions.isEmpty()){
            throw  new UnknownThemeException("Thème inconnu");
        }
        request.getSession().setAttribute("questionsByThemeNewQuestionnaire", QuestionDAO.getByTheme(idThemeQuestionnaire));
    }


    public void applyToAddQuestionByTheme() throws SQLException{
        Questionnaire newQuestionnaire = (Questionnaire) request.getSession().getAttribute("newQuestionnaire");
        List<Question> questionsByThemeNewQuestionnaire = (List<Question>) request.getSession().getAttribute("questionsByThemeNewQuestionnaire");
        int idQuestion = Integer.parseInt(request.getParameter("idQuestionToAdd").toString());
        Question questionToAdd =QuestionDAO.getById(idQuestion);
        if(questionsByThemeNewQuestionnaire.contains(questionToAdd) && !newQuestionnaire.getQuestions().contains(questionToAdd)){
            newQuestionnaire.addQuestion(questionToAdd);
            questionsByThemeNewQuestionnaire.remove(questionToAdd);
        }
        request.getSession().setAttribute("newQuestionnaire", newQuestionnaire);
        request.getSession().setAttribute("questionsByThemeNewQuestionnaire", questionsByThemeNewQuestionnaire);
    }

    public void applyToAddNewQuestion() throws UnauthorizedActionException{
        String libelleQuestion= request.getParameter("libelleQuestion").toString();
        int nbReponses = Integer.parseInt(request.getParameter("nbReponses"));
        if(libelleQuestion == null || libelleQuestion.trim().isEmpty()){
            throw new UnauthorizedActionException("Merci d'entrer le libellé de votre question");
        } else if(nbReponses <= 0){
            throw new UnauthorizedActionException("Merci d'entrer un nombre correct de réponses");
        }
        Questionnaire newQuestionnaire = (Questionnaire) request.getSession().getAttribute("newQuestionnaire");
        request.setAttribute("nbReponses", nbReponses);
        request.setAttribute("question", new Question(null, libelleQuestion, newQuestionnaire.getIdTheme(), getIdUser(),0, new ArrayList<Reponse>()));
    }


}
