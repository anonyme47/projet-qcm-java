package util;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modele.Statut;
import modele.User;
/**
 *
 * @author marya
 */
public class UserDAO {
    public static User getByLoginAndPassword(String login, String password) throws SQLException {
        User user = null;
        Connection connexion = Database.getConnection();
        String sql = "SELECT user.id_user,user.login,user.password,user.email, statut.id_statut, statut.libelle FROM user " +
                " INNER JOIN statut ON user.id_statut=statut.id_statut" +
                " WHERE user.login=? and user.password=?";
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
                    new Statut(rs.getInt("id_statut"),rs.getString("libelle")));
        }
        rs.close();
        ordre.close();
        connexion.close();
        return user;
    }
}
