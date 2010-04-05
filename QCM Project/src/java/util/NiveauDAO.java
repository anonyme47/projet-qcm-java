package util;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import modele.Niveau;

/**
 *
 * @author marya
 */
public class NiveauDAO extends ModeleDAO{


    public static HashMap<Integer, Niveau> getAll() throws SQLException {
        HashMap<Integer, Niveau> niveaux = new HashMap<Integer, Niveau>();
        String sql = "SELECT id_niveau, libelle FROM niveau ORDER BY id_niveau ASC";
        ResultSet rs = selectAll(sql);
        while (rs.next()) {
            Niveau niveau = new Niveau(rs.getInt("id_niveau"), rs.getString("libelle"));
            niveaux.put(niveau.getIdNiveau(), niveau);
        }
        rs.close();
        return niveaux;
    }

    public static Niveau getById(int idNiveau) throws SQLException {
        Niveau niveau = null;
        String sql = "SELECT id_niveau, libelle FROM niveau WHERE id_niveau = ?";
        ResultSet rs = selectById(sql, idNiveau);
        if (rs.next()) {
            niveau = new Niveau(
                    rs.getInt("id_niveau"),
                    rs.getString("libelle"));
        }
        rs.close();
        return niveau;
    }

    
}
