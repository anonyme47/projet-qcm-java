package util;

import java.util.HashMap;
import modele.Statut;
import modele.User;
import org.junit.Test;
import tools.QCMTestCase;
import static org.junit.Assert.*;

/**
 *
 * @author marya
 */
public class UserDAOTest extends QCMTestCase {

    /**
     * Test of getByLoginAndPassword method, of class UserDAO.
     */
    @Test
    public void testGetByLoginAndPassword() throws Exception {
        System.out.println("getByLoginAndPassword");
        String login = "Maria";
        String password = "maria";
        User expResult = new User(null, login, password, "maryarabarison@gmail.com", "Rabarison", "Maria", new Statut(1, "Enseignant"), true);
        User result = UserDAO.getByLoginAndPassword(login, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of getById method, of class UserDAO.
     */
    @Test
    public void testGetById() throws Exception {
        System.out.println("getById");
        int idUser = 1;
        User expResult = new User(null, "Lou", "lou", "ferrandlou@gmail.com", "Ferrand", "Lou", new Statut(3, "Administrateur"), true);
        User result = UserDAO.getById(idUser);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAll method, of class UserDAO.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        HashMap<Integer, User> expResult = new HashMap<Integer, User>();

        expResult.put(1, UserDAO.getById(1));
        expResult.put(2, UserDAO.getById(2));
        expResult.put(3, UserDAO.getById(3));
        expResult.put(4, UserDAO.getById(4));
        expResult.put(5, UserDAO.getById(5));
        expResult.put(6, UserDAO.getById(6));
        expResult.put(7, UserDAO.getById(7));
        expResult.put(8, UserDAO.getById(8));
        expResult.put(9, UserDAO.getById(9));
        expResult.put(10, UserDAO.getById(10));

        HashMap<Integer, User> result = UserDAO.getAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class UserDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        User user = new User(1, "lou", "lou", "ferrandlou@gmail.com", "Ferrand", "Lou", new Statut(3, "Administrateur"), true);
        String nouveauLoginUser = "Nouveau login";
        user.setLogin(nouveauLoginUser);
        UserDAO.update(user);
        assertTrue(UserDAO.getById(1).getLogin().equals(nouveauLoginUser));
    }

}