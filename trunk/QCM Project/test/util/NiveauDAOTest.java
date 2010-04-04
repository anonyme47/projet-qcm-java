package util;

import java.sql.SQLException;
import java.util.HashMap;
import modele.Niveau;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lou
 */
public class NiveauDAOTest {

    /**
     * Test of getAll method, of class NiveauDAO.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        HashMap<Integer, String> expResult = new HashMap<Integer, String>();
        expResult.put(1, "Débutant");
        expResult.put(2, "Avancé");
        expResult.put(3, "Expert");
        HashMap<Integer, String> result = NiveauDAO.getAll();
        assertEquals(expResult.get(1), result.get(1));
        assertEquals(expResult.get(2), result.get(2));
        assertEquals(expResult.get(3), result.get(3));
    }

    /**
     * Test of getById method, of class NiveauDAO.
     */
    @Test
    public void testGetById() throws Exception {
        System.out.println("getById");
        Niveau expResult = new Niveau(1, "Débutant");
        Niveau result = NiveauDAO.getById(1);
        assertEquals(expResult, result);
    }

    /**
     * Test of getLibelleById, of class NiveauDAO
     * @throws SQLException
     */
    @Test
    public void testGetLibelleById() throws SQLException {
        System.out.println("getLibelleById");
        Niveau instance = new Niveau(1, "Débutant");
        String expResult = "Débutant";
        String result = NiveauDAO.getById(instance.getIdNiveau()).getLibelle();
        assertTrue(result.equals(expResult));
    }

}
