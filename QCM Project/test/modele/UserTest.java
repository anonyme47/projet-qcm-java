package modele;

import org.junit.Test;
import tools.QCMTestCase;

/**
 *
 * @author Lou
 */
public class UserTest extends QCMTestCase {

    /**
     * Test of isAdmin method, of class User.
     */
    @Test
    public void testIsAdmin() {
        System.out.println("isAdmin");
        User instance = new User(null, "maria", "maria", "maryarabarison@gmail.com", "Rabarison", "Maria", new Statut(1, "Enseignant"), true);
        boolean expResult = false;
        boolean result = instance.isAdmin();
        assertEquals(expResult, result);
        instance = new User(null, "lou", "lou", "ferrandlou@gmail.com", "Ferrand", "Lou", new Statut(3, "Administrateur"), true);
        expResult = true;
        result = instance.isAdmin();
        assertEquals(expResult, result);
    }

    /**
     * Test of isCreator method, of class User.
     */
    @Test
    public void testIsCreator() {
        System.out.println("isCreator");
        User instance = new User(null, "maria", "maria", "maryarabarison@gmail.com", "Rabarison", "Maria", new Statut(1, "Enseignant"), true);
        boolean expResult = true;
        boolean result = instance.isCreator();
        assertEquals(expResult, result);
    }

}