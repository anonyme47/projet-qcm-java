package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import modele.Theme;

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

    public static Theme getById(int idTheme) throws SQLException {
        Theme theme = null;
        Connection connexion = Database.getConnection();
        String sql = "SELECT id_theme, libelle, id_user FROM theme WHERE id_theme = ?";
        PreparedStatement ordre = connexion.prepareStatement(sql);
        ordre.setInt(1, idTheme);
        ResultSet rs = ordre.executeQuery();
        if (rs.next()) {
            theme = new Theme(
                    rs.getInt("id_theme"),
                    rs.getInt("id_user"),
                    rs.getString("libelle"));
        }
        rs.close();
        ordre.close();
        connexion.close();
        return theme;
    }

    
}
