package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author marya
 */
public class ThemeDAO {

    public static HashMap<Integer, String> getAll() throws SQLException {
        HashMap<Integer, String> themes = new HashMap<Integer, String>();
        Connection connexion = Database.getConnection();
        String sql = "SELECT id_theme, libelle FROM theme ORDER BY id_theme ASC";
        ResultSet rs = connexion.createStatement().executeQuery(sql);
        while (rs.next()) {
            themes.put(rs.getInt("id_theme"), rs.getString("libelle"));
        }
        rs.close();
        connexion.close();
        return themes;
    }

}
