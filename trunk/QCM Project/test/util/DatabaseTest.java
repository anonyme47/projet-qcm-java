package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;
import tools.QCMTestCase;
import static org.junit.Assert.*;

/**
 *
 * @author Lou Ferrand
 */
public class DatabaseTest extends QCMTestCase {

    /**
     * Test of getConnection method, of class Database.
     */
    @Test
    public void testGetConnection() throws Exception {
        System.out.println("getConnection");
        Connection result = Database.getConnection();
        assertNotNull(result);
    }

    /**
     * Se connecte à la base pour vérifier que l'ordre SELECT fonctionne normalement
     * @throws Exception
     */
    @Test
    public void testSelect() throws SQLException {
        System.out.println("testSelect");
        Connection connexion = Database.getConnection();
//        String sql = "SELECT id_user, login, password FROM user WHERE id_user = 2 LIMIT 0,1";
        String sql = "SELECT id_reponse, libelle, descriptif, est_correcte, note FROM reponse WHERE id_reponse = 2 LIMIT 0,1";
        Statement ordre = connexion.createStatement();
        ResultSet rs = ordre.executeQuery(sql);
        while (rs.next()) {
//            assertEquals(rs.getInt("id_user"), 2);
//            assertEquals(rs.getString("login"), "Maria");
//            assertEquals(rs.getString("password"), "maria");
            assertEquals(rs.getInt("id_reponse"), 2);
            assertEquals(rs.getString("libelle"), "Réponse 2");
            assertEquals(rs.getString("descriptif"), "Descriptif Réponse 2 Question 1");
            assertEquals(rs.getBoolean("est_correcte"), false);
            assertEquals(rs.getInt("note"), 0);
        }

        rs.close();
        ordre.close();
        connexion.close();
    }

    /**
     * Test des contraintes sur Contenu
     * Ce test est censé lever une exception car il est impossible d'avoir dans
     * la table contenu la question 1 dans le questionnaire 1 une deuxieme fois
     * @throws SQLException
     */
    @Test
    public void testInsert() throws SQLException {
        //Ce test doit echouer!!
        int idQuestionnaire = 1;
        int idQuestion = 1;
        Connection connexion = Database.getConnection();
        String sql = "INSERT INTO contenu (id_questionnaire, id_question) VALUES (?, ?)";
        PreparedStatement ordre = connexion.prepareStatement(sql);
        ordre.setInt(1, idQuestionnaire);
        ordre.setInt(2, idQuestion);
        int ok = ordre.executeUpdate();
        ordre.close();
        connexion.close();
        System.out.println(ok);
        assertTrue(ok == 0);
    }
}
