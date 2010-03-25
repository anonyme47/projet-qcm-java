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
 */
public class QcmDAO {

    public static void insert(Qcm qcm) throws SQLException {
        Connection connexion = null;
        PreparedStatement ordre = null;

        try {
            connexion = Database.getConnection();
            connexion.setAutoCommit(false);
            int idQuestionnaire = qcm.getIdQuestionnaire();
            String sql = "INSERT INTO user_reponse(id_contenu, id_reponse, id_user) VALUES (?,?,?)";
            ordre = connexion.prepareStatement(sql);
            ordre.setInt(3, qcm.getIdUser());
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
            connexion.commit();
            qcm.setEstFini(true);
        } catch (SQLException ex) {
            if (connexion != null) {
                connexion.rollback();
            }
            throw ex;
        } finally {
            ordre.close();
            connexion.close();
        }
    }

    public static Integer getIdContenu(int idQuestionnaire, int idQuestion) throws SQLException {
        Integer result = null;
        Connection connexion = Database.getConnection();
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
        connexion.close();
        return result;
    }
}