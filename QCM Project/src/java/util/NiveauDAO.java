package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author marya
 */
public class NiveauDAO {

    public static HashMap<Integer, String> getAll() throws SQLException {
        HashMap<Integer, String> niveaux = new HashMap<Integer, String>();
        Connection connexion = Database.getConnection();
        String sql = "SELECT id_niveau, libelle FROM niveau ORDER BY id_niveau ASC";
        ResultSet rs = connexion.createStatement().executeQuery(sql);
        while (rs.next()) {
            niveaux.put(rs.getInt("id_niveau"), rs.getString("libelle"));
        }
        rs.close();
        connexion.close();
        return niveaux;
    }
}
