package util;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import modele.Statut;
import modele.User;

/**
 *
 * @author marya
 */
public class UserDAO extends ModeleDAO {

    public static User getByLoginAndPassword(String login, String password) throws SQLException {
        User user = null;
        Connection connexion = getConnection();
        String sql = "SELECT user.id_user, user.login, user.password, user.email, user.nom, user.prenom, user.est_actif, statut.id_statut, statut.libelle "
                + "FROM user "
                + " INNER JOIN statut ON user.id_statut=statut.id_statut"
                + " WHERE user.login=? and user.password=?";
        PreparedStatement ordre = connexion.prepareStatement(sql);
        ordre.setString(1, login);
        ordre.setString(2, password);
        ResultSet rs = ordre.executeQuery();

        if (rs.next()) {
            user = new User(
                    rs.getInt("id_user"),
                    rs.getString("login"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    new Statut(rs.getInt("id_statut"), rs.getString("libelle")),
                    rs.getBoolean("est_actif"));
        }
        rs.close();
        ordre.close();
        return user;
    }

    public static User getById(int idUser) throws SQLException {
        User user = null;
        String sql = "SELECT user.id_user, user.login, user.password, user.email, user.nom, user.prenom, user.est_actif, statut.id_statut, statut.libelle "
                + "FROM user "
                + "INNER JOIN statut ON user.id_statut = statut.id_statut "
                + "WHERE user.id_user = ?";
        ResultSet rs = selectById(sql, idUser);

        if (rs.next()) {
            user = new User(
                    rs.getInt("id_user"),
                    rs.getString("login"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    new Statut(rs.getInt("id_statut"), rs.getString("libelle")),
                    rs.getBoolean("est_actif"));
        }
        rs.close();
        return user;
    }

    public static HashMap<Integer, User> getAll() throws SQLException {
        HashMap<Integer, User> users = new HashMap<Integer, User>();
        String sql = "SELECT user.id_user, user.login, user.password, user.email, user.nom, user.prenom, user.est_actif, statut.id_statut, statut.libelle "
                + "FROM user INNER JOIN statut ON user.id_statut=statut.id_statut";
        ResultSet rs = getConnection().createStatement().executeQuery(sql);
        while (rs.next()) {
            int idUser = rs.getInt("id_user");
            users.put(idUser, new User(
                    idUser,
                    rs.getString("login"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    new Statut(rs.getInt("id_statut"), rs.getString("libelle")),
                    rs.getBoolean("est_actif")));
        }
        return users;
    }

    public static void update(User user) throws SQLException {
        String sql = "UPDATE user SET login = ?, nom = ?, prenom = ?, email = ?, password = ?, est_actif = ? WHERE id_user = ?";
        PreparedStatement ps = getConnection().prepareStatement(sql);
        ps.setString(1, user.getLogin());
        ps.setString(2, user.getNom());
        ps.setString(3, user.getPrenom());
        ps.setString(4, user.getEmail());
        ps.setString(5, user.getPassword());
        ps.setBoolean(6, user.estActif());

        ps.setInt(7, user.getIdUser());
        ps.executeUpdate();
        ps.close();
    }
}
