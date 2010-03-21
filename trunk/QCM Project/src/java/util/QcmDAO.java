/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Qcm;

/**
 *
 * @author marya
 */
public class QcmDAO {

    public static void insert(Qcm qcm) throws SQLException{
       int idQuestionnaire = qcm.getIdQuestionnaire();
       Connection connexion = Database.getConnection();
       String sql="INSERT INTO user_reponse(id_contenu,id_reponse) VALUES (?,?)";
       
       /*
        * TODO: pour chaque clé de userReponses on prend idQuestion
        * faire un Qcm.getIdContenu => renvoie le id_contenu
        * pour chaque reponse dans la liste des réponses de idQuestion
        * insert
        */

    }


    public static Integer getIdContenu(int idQuestionnaire, int idQuestion) throws SQLException{
        Integer result=null;
        Connection connexion = Database.getConnection();
        String sql = "SELECT id_contenu FROM contenu";
        sql += " WHERE id_questionnaire = ? AND id_question=?";
        PreparedStatement ordre = connexion.prepareStatement(sql);
        ordre.setInt(1, idQuestionnaire);
        ordre.setInt(2, idQuestion);
        ResultSet rs = ordre.executeQuery();

        if(rs.next()) {
            result=rs.getInt("id_contenu");
        }
        rs.close();
        ordre.close();
        connexion.close();
        return result;
    }
}
