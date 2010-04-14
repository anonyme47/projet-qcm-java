package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import modele.Qcm;

/**
 *
 * @author Maria Rabarison et Lou Ferrand
 * TODO : Changer limite_temps à celui du qcm
 */
public class QcmDAO extends ModeleDAO {

    public static void insert(Qcm qcm) throws SQLException {
        Connection connexion = null;
        PreparedStatement ordre = null;

        try {
            connexion = getConnection();
            connexion.setAutoCommit(false);
            int idQuestionnaire = qcm.getQuestionnaire().getIdQuestionnaire();
            int idUser = qcm.getIdUser();
            String sql = "INSERT INTO user_reponse(id_contenu, id_reponse, id_user) VALUES (?,?,?)";
            ordre = connexion.prepareStatement(sql);
            ordre.setInt(3, idUser);
            Integer idContenu = null;
            List<Integer> reponses = null;
            Map<Integer, List<Integer>> userReponses = qcm.getUserReponses();
            for (Integer idQuestion : userReponses.keySet()) {
                idContenu = QcmDAO.getIdContenu(idQuestionnaire, idQuestion);
                reponses = userReponses.get(idQuestion);
                for (Integer idReponse : reponses) {
                    ordre.setInt(1, idContenu);
                    ordre.setInt(2, idReponse);
                    ordre.executeUpdate();
                }
            }
            sql = "INSERT INTO questionnaire_passe(id_questionnaire, id_user, note, date, libelle_questionnaire, limite_temps) " +
                    "VALUES (" + idQuestionnaire + "," + idUser + "," + qcm.getNote() + ",NOW(),\"" + qcm.getQuestionnaire().getLibelle() + "\"," + qcm.getQuestionnaire().getLimiteTemps() + ")";
                    System.out.println(sql);
            int result = connexion.createStatement().executeUpdate(sql);
            if (result > 0) {
                connexion.commit();
                qcm.setEstFini(true);
            } else {
                throw new SQLException("Insertion questionnaire_passe failed.");
            }

        } catch (SQLException ex) {
            if (connexion != null) {
                connexion.rollback();
            }
            throw ex;
        } finally {
            ordre.close();
        }
    }

    public static Integer getIdContenu(int idQuestionnaire, int idQuestion) throws SQLException {
        Integer result = null;
        Connection connexion = getConnection();
        String sql = "SELECT id_contenu FROM contenu";
        sql += " WHERE id_questionnaire = ? AND id_question=?";
        PreparedStatement ordre = connexion.prepareStatement(sql);
        ordre.setInt(1, idQuestionnaire);
        ordre.setInt(2, idQuestion);
        ResultSet rs = ordre.executeQuery();

        if (rs.next()) {
            result = rs.getInt("id_contenu");
        }
        rs.close();
        ordre.close();
        return result;
    }
}
