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
public class ThemeDAO extends ModeleDAO {

    public static HashMap<Integer, String> getAll() throws SQLException {
        HashMap<Integer, String> themes = new HashMap<Integer, String>();
        String sql = "SELECT id_theme, libelle FROM theme ORDER BY id_theme ASC";
        ResultSet rs = selectAll(sql);
        while (rs.next()) {
            themes.put(rs.getInt("id_theme"), rs.getString("libelle"));
        }
        rs.close();
        return themes;
    }

    public static Theme getById(int idTheme) throws SQLException {
        Theme theme = null;
        String sql = "SELECT id_theme, libelle, id_user FROM theme WHERE id_theme = ?";
        ResultSet rs = selectById(sql, idTheme);
        if (rs.next()) {
            theme = new Theme(
                    rs.getInt("id_theme"),
                    rs.getInt("id_user"),
                    rs.getString("libelle"));
        }
        rs.close();
        return theme;
    }

    
}
