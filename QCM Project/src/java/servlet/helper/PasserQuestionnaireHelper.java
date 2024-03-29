package servlet.helper;

import exception.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modele.Qcm;
import modele.Reponse;
import modele.User;
import util.*;

/**
 *
 * @author marya
 */
public class PasserQuestionnaireHelper extends RequestHelper {

    public PasserQuestionnaireHelper(HttpServletRequest request) throws ExpiredSessionException, IOException {
        super(request);
    }

    /**
     * Permet de recupérer tous les questinnaires correspondant à un choix
     * et de les mettre en attribut questionnaires
     * @param request
     * @throws SQLException
     */
    public void setAttributeQuestionnairesByChoice() throws SQLException {
        HashMap<Integer, String> questionnaires = null;
        Integer theme = Integer.parseInt(request.getParameter("theme").toString());
        Integer niveau = Integer.parseInt(request.getParameter("niveau").toString());

        if (theme == null || theme < 0) {
            throw new IllegalArgumentException("Veuillez selectionner un thème");
        } else if (niveau == null || niveau < 0) {
            throw new IllegalArgumentException("Veuillez selectionner un niveau");
        } else if (theme == 0) {
            request.setAttribute("niveau", niveau);
            questionnaires = QuestionnaireDAO.getQuestionnairesByNiveau(niveau);
        } else if (niveau == 0) {
            request.setAttribute("theme", theme);
            questionnaires = QuestionnaireDAO.getQuestionnairesByTheme(theme);
        } else {
            request.setAttribute("theme", theme);
            request.setAttribute("niveau", niveau);
            questionnaires = QuestionnaireDAO.getQuestionnairesByThemeAndNiveau(theme, niveau);
        }
        setAttributeNiveaux();
        setAttributeThemes();
        request.setAttribute("questionnaires", questionnaires);
    }

    public void setSessionAttributeQcm() throws SQLException, UnknownQuestionException {
        int idQuestionnaire = Integer.parseInt(request.getParameter("questionnaire").toString());
        int idUser = ((User) request.getSession().getAttribute("user")).getIdUser();
        Qcm qcm = new Qcm(idQuestionnaire, idUser);
        if (qcm == null) {
            throw new UnknownQuestionException("Questionnaire introuvable");
        }else if(userHasAlreadyPassedQuestionnaire(qcm.getQuestionnaire())){
            qcm.setEstFini(true);
        }else{
            request.setAttribute("questionCourante", QuestionDAO.getById(qcm.getQuestionSuivante()));
        }
        request.getSession().setAttribute("qcm", qcm);
        
    }

    public void setAttributeQuestionSuivante() throws SQLException{
        Qcm qcm = (Qcm) request.getSession().getAttribute("qcm");
        String[] reponses = request.getParameterValues("reponses");
        if (reponses != null && reponses.length != 0) {
            List<Integer> userReponses = new ArrayList<Integer>();
            for (String reponse : reponses) {
                userReponses.add(Integer.parseInt(reponse));
            }
            int idQuestion = Integer.parseInt(request.getParameter("idQuestion"));
            List<Reponse> reponsesDeQuestion = QuestionDAO.getById(idQuestion).getReponses();
            if (!qcm.estFini() && reponsesDeQuestion.size() > userReponses.size()) {
                qcm.setUserReponses(idQuestion, userReponses);
            }
        }
        Integer questionCourante = qcm.getQuestionSuivante();
        if (questionCourante == null) {
            request.setAttribute("questionCourante", null);
            request.setAttribute("estFini", true);
        } else {
            request.setAttribute("questionCourante", QuestionDAO.getById((int) questionCourante));
        }
    }

    public void prepareResultats() throws SQLException {
        Qcm qcm = (Qcm) request.getSession().getAttribute("qcm");
        request.setAttribute("theme", ThemeDAO.getById(qcm.getQuestionnaire().getIdTheme()).getLibelle());
        request.setAttribute("niveau", NiveauDAO.getById(qcm.getQuestionnaire().getIdNiveau()).getLibelle());
        if(!qcm.estFini() && !userHasAlreadyPassedQuestionnaire(qcm.getQuestionnaire())){
            qcm.save();
            request.getSession().setAttribute("qcm", qcm);
        }
        request.setAttribute("note", qcm.getNote());



    }

    public void applyToModifyResponses() throws SQLException {
        if(!((Qcm) request.getSession().getAttribute("qcm")).estFini()){
            int modifyQuestion = Integer.parseInt(request.getParameter("modifyQuestion").toString());
            request.setAttribute("questionCourante", QuestionDAO.getById(modifyQuestion));
        }
    }
}
