package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lou
 */
public class QuestionnaireDAO {

    /**
     * Récupère le questionnaire dont on connaît l'identifiant en base de données
     * @param idQuestionnaire L'identifiant du questionnaire
     * @return Le questionnaire identifié par idQuestionnaire
     * @throws SQLException
     */
/*
    public static Questionnaire getById(int idQuestionnaire) throws SQLException {
        Questionnaire questionnaire = null;
        Connection connexion = Database.getConnection();
        String sql = "SELECT * FROM questionnaire WHERE id_questionnaire = ?";
        PreparedStatement ordre = connexion.prepareStatement(sql);
        ordre.setInt(1, idQuestionnaire);
        ResultSet rs = ordre.executeQuery();

        if (rs.next()) {
            questionnaire = new Questionnaire(
                    idQuestionnaire,
                    rs.getInt("id_theme"),
                    rs.getInt("id_niveau"),
                    rs.getInt("id_user"),
                    rs.getString("libelle"),
                    rs.getDate("date_creation"),
                    rs.getInt("limite_temps"),
                    rs.getBoolean("est_actif"),
                    QuestionnaireDAO.getQuestions(idQuestionnaire));
        }
        rs.close();
        ordre.close();
        connexion.close();
        return questionnaire;
    }
*/
    /**
     * Récupérer la liste de toutes les questions relatives à un questionnaire
     * @param idQuestionnaire L'identifiant du questionnaire dont on veut les questions
     * @return La liste des questions incluses dans le questionnaire spécifié en paramètre
     * @throws SQLException
     */
    public static ArrayList<Integer> getQuestions(int idQuestionnaire) throws SQLException {
        ArrayList<Integer> questions = new ArrayList<Integer>();
        Connection connexion = Database.getConnection();
        String sql = "SELECT contenu.id_question, question.id_theme AS theme_question, questionnaire.id_theme AS theme_questionnaire FROM contenu";
        sql += " INNER JOIN question ON (question.id_question=contenu.id_question)";
        sql += " INNER JOIN questionnaire ON (questionnaire.id_questionnaire=contenu.id_questionnaire)";
        sql += " WHERE contenu.id_questionnaire = ?";
        PreparedStatement ordre = connexion.prepareStatement(sql);
        ordre.setInt(1, idQuestionnaire);
        ResultSet rs = ordre.executeQuery();

        while (rs.next()) {
            assert rs.getInt("theme_question") == rs.getInt("theme_questionnaire");
            questions.add(rs.getInt("id_question"));
        }
        rs.close();
        ordre.close();
        connexion.close();
        return questions;
    }
}
