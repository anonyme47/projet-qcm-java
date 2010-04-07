package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.Reponse;
import modele.Question;

/**
 *
 * @author marya
 */
public class QuestionDAO extends ModeleDAO{


    public static Question getById(int idQuestion) throws SQLException{
        Question question=null;
        String sql = "SELECT question.libelle, question.id_theme, question.id_user, "+
                "COUNT( questionnaire_passe.id_questionnaire ) AS nbQuestionnairePasseAppelant "+
                "FROM question "+
                "INNER JOIN contenu ON contenu.id_question = question.id_question "+
                "INNER JOIN questionnaire_passe ON questionnaire_passe.id_questionnaire = contenu.id_questionnaire "+
                "WHERE question.id_question =?";
        ResultSet rs = selectById(sql, idQuestion);
        if (rs.next()) {
            question = new Question(
                            idQuestion,
                            rs.getString("libelle"),
                            rs.getInt("id_theme"),
                            rs.getInt("id_user"),
                            rs.getInt("nbQuestionnairePasseAppelant"),
                            getReponsesById(idQuestion));
        }
        rs.close();
        return question;
    }

    
    public static List<Reponse> getReponsesById(int idQuestion) throws SQLException{
        List<Reponse> reponses= new ArrayList<Reponse>();
        String sql = "SELECT id_reponse FROM reponse WHERE id_question = ? ORDER BY id_reponse ASC";
        ResultSet rs = selectById(sql, idQuestion);
        while(rs.next()) {
            reponses.add(ReponseDAO.getById(rs.getInt("id_reponse")));
        }
        rs.close();
        return reponses;
    }


    public static List<Question> getByTheme(int idTheme) throws SQLException {
        List<Question> questions = new ArrayList<Question>();
        String sql ="SELECT id_question FROM question WHERE id_theme = ? ORDER BY id_question ASC";
        ResultSet rs = selectById(sql, idTheme);
        while(rs.next()){
            questions.add(getById(rs.getInt(1)));
        }
        rs.close();
        return questions;
    }



}
