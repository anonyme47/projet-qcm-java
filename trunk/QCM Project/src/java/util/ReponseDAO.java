package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Reponse;

/**
 *
 * @author Maria Rabarison et Lou Ferrand
 */
public class ReponseDAO {

    public static Reponse getById(int idReponse) throws SQLException {
        Reponse reponse = null;
        Connection connexion = Database.getConnection();
        String sql = "SELECT id_reponse, libelle, descriptif, est_correcte, note FROM reponse WHERE id_reponse = ?";
        PreparedStatement ordre = connexion.prepareStatement(sql);
        ordre.setInt(1, idReponse);
        ResultSet rs = ordre.executeQuery();
        if (rs.next()) {
            reponse = new Reponse(
                    rs.getInt("id_reponse"),
                    rs.getString("libelle"),
                    rs.getString("descriptif"),
                    rs.getBoolean("est_correcte"),
                    rs.getInt("note"));
        }
        rs.close();
        ordre.close();
        connexion.close();
        return reponse;
    }

    public static int getNoteById(int idReponse) throws SQLException {
        int note = 0;
        Connection connexion = Database.getConnection();
        String sql = "SELECT note FROM reponse WHERE id_reponse = ?";
        PreparedStatement ordre = connexion.prepareStatement(sql);
        ordre.setInt(1, idReponse);
        ResultSet rs = ordre.executeQuery();
        if (rs.next()) {
            note = rs.getInt("note");
        }
        rs.close();
        ordre.close();
        connexion.close();
        return note;
    }

}
