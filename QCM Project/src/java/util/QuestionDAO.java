/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class QuestionDAO {


    public static Question getById(int idQuestion) throws SQLException{
        Question question=null;
        Connection connexion = Database.getConnection();
        String sql = "SELECT question.libelle, question.id_theme, question.id_user, "+
                "COUNT( questionnaire_passe.id_questionnaire ) AS nbQuestionnairePasseAppelant "+
                "FROM question "+
                "INNER JOIN contenu ON contenu.id_question = question.id_question "+
                "INNER JOIN questionnaire_passe ON questionnaire_passe.id_questionnaire = contenu.id_questionnaire "+
                "WHERE question.id_question =?";
        PreparedStatement ordre = connexion.prepareStatement(sql);
        ordre.setInt(1, idQuestion);
        ResultSet rs = ordre.executeQuery();
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
        ordre.close();
        connexion.close();
        return question;
    }

    
    public static List<Reponse> getReponsesById(int idQuestion) throws SQLException{
        List<Reponse> reponses= new ArrayList<Reponse>();
        Connection connexion = Database.getConnection();
        String sql = "SELECT id_reponse FROM reponse WHERE id_question = ? ORDER BY id_reponse ASC";
        PreparedStatement ordre = connexion.prepareStatement(sql);
        ordre.setInt(1, idQuestion);
        ResultSet rs = ordre.executeQuery();
        while(rs.next()) {
            reponses.add(ReponseDAO.getById(rs.getInt("id_reponse")));
        }
        rs.close();
        ordre.close();
        connexion.close();
        return reponses;
    }

}
