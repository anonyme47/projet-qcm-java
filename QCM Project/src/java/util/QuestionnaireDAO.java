package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import modele.Questionnaire;

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

    public static Questionnaire getById(int idQuestionnaire) throws SQLException {
        Questionnaire questionnaire = null;
        Connection connexion = Database.getConnection();
        String sql = "SELECT questionnaire.libelle,questionnaire.date_creation,questionnaire.limite_temps,questionnaire.est_actif,questionnaire.id_theme,questionnaire.id_user,questionnaire.id_niveau,COUNT(questionnaire_passe.id_questionnaire) AS nbPasseParUser FROM questionnaire INNER JOIN questionnaire_passe ON questionnaire_passe.id_questionnaire=questionnaire.id_questionnaire WHERE questionnaire.id_questionnaire = ?";
        PreparedStatement ordre = connexion.prepareStatement(sql);
        ordre.setInt(1, idQuestionnaire);
        ResultSet rs = ordre.executeQuery();

        if (rs.next()) {
            questionnaire = new Questionnaire(
                    idQuestionnaire,
                    rs.getString("libelle"),
                    rs.getDate("date_creation"),
                    rs.getInt("limite_temps"),
                    rs.getBoolean("est_actif"),
                    rs.getInt("id_theme"),
                    rs.getInt("id_user"),
                    rs.getInt("id_niveau"),
                    QuestionnaireDAO.getQuestionsById(idQuestionnaire),
                    rs.getInt("nbPasseParUser")); 
        }
        rs.close();
        ordre.close();
        connexion.close();
        return questionnaire;
    }

    /**
     * Récupérer la liste de toutes les questions relatives à un questionnaire
     * @param idQuestionnaire L'identifiant du questionnaire dont on veut les questions
     * @return La liste des questions incluses dans le questionnaire spécifié en paramètre
     * @throws SQLException
     */
    public static ArrayList<Integer> getQuestionsById(int idQuestionnaire) throws SQLException {
        ArrayList<Integer> questions = new ArrayList<Integer>();
        Connection connexion = Database.getConnection();
        String sql = "SELECT contenu.id_question, question.id_theme AS theme_question, questionnaire.id_theme AS theme_questionnaire FROM contenu";
        sql += " INNER JOIN question ON (question.id_question=contenu.id_question)";
        sql += " INNER JOIN questionnaire ON (questionnaire.id_questionnaire=contenu.id_questionnaire)";
        sql += " WHERE contenu.id_questionnaire = ? ORDER BY id_contenu ASC";
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

/**
     * Récupérer tous les questionnaires d'un thème donné
     * @param idTheme L'identifiant du thème concerné
     * @return La liste de tous les questionnaires dont le thème est passé en argument
     * @throws SQLException
     */
    public static HashMap<Integer, String> getQuestionnairesByTheme(int idTheme) throws SQLException {
        HashMap<Integer, String> maMap = new HashMap<Integer, String>();
        Connection connexion = Database.getConnection();
        String sql = "SELECT id_questionnaire,libelle FROM questionnaire WHERE id_theme=? AND est_actif=?";
        PreparedStatement ordre = connexion.prepareStatement(sql);
        ordre.setInt(1, idTheme);
        ordre.setBoolean(2, true);
        ResultSet rs = ordre.executeQuery();

        while (rs.next()) {
            maMap.put(rs.getInt("id_questionnaire"), rs.getString("libelle"));
        }
        rs.close();
        ordre.close();
        connexion.close();
        return maMap;
    }


     /**
     * Récupérer tous les questionnaires d'un niveau donné
     * @param idNiveau L'identifiant du niveau concerné
     * @return La liste de tous les questionnaires dont le niveau est passé en argument
     * @throws SQLException
     */
    public static HashMap<Integer, String> getQuestionnairesByNiveau(int idNiveau) throws SQLException {
        HashMap<Integer, String> maMap = new HashMap<Integer, String>();
        Connection connexion = Database.getConnection();
        String sql = "SELECT id_questionnaire,libelle FROM questionnaire WHERE id_niveau=? AND est_actif=?";
        PreparedStatement ordre = connexion.prepareStatement(sql);
        ordre.setInt(1, idNiveau);
        ordre.setBoolean(2, true);
        ResultSet rs = ordre.executeQuery();
        while (rs.next()) {
            maMap.put(rs.getInt("id_questionnaire"), rs.getString("libelle"));
        }
        rs.close();
        ordre.close();
        connexion.close();
        return maMap;
    }


    

/**
     * Récupérer tous les questionnaires pour un niveau et un thème spécifiés
     * @param idTheme L'identifiant du thème concerné
     * @param idNiveau L'identifiant du niveau concerné
     * @return La liste de tous les questionnaires dont le thème et le niveau sont passés en argument
     * @throws SQLException
     */
    public static HashMap<Integer, String> getQuestionnairesByThemeAndNiveau(int idTheme, int idNiveau) throws SQLException {
        HashMap<Integer, String> maMap = new HashMap<Integer, String>();
        Connection connexion = Database.getConnection();
        String sql = "SELECT id_questionnaire,libelle FROM questionnaire WHERE id_theme=? AND id_niveau=? AND est_actif=?";
        PreparedStatement ordre = connexion.prepareStatement(sql);
        ordre.setInt(1, idTheme);
        ordre.setInt(2, idNiveau);
        ordre.setBoolean(3, true);
        ResultSet rs = ordre.executeQuery();

        while (rs.next()) {
            maMap.put(rs.getInt("id_questionnaire"), rs.getString("libelle"));
        }
        rs.close();
        ordre.close();
        connexion.close();
        return maMap;
    }

}
