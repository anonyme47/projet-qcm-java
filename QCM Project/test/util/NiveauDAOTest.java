package util;

import java.util.HashMap;
import modele.Niveau;
import org.junit.Test;
import tools.QCMTestCase;
import static org.junit.Assert.*;

/**
 *
 * @author Lou
 */
public class NiveauDAOTest extends QCMTestCase {

    /**
     * Test of getAll method, of class NiveauDAO.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        HashMap<Integer, Niveau> expResult = new HashMap<Integer, Niveau>();
        expResult.put(1, NiveauDAO.getById(1));
        expResult.put(2, NiveauDAO.getById(2));
        expResult.put(3, NiveauDAO.getById(3));
        HashMap<Integer, Niveau> result = NiveauDAO.getAll();
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
        Niveau expResult = new Niveau(1, "Débutant", 3, true);
        Niveau result = NiveauDAO.getById(1);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class NiveauDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Niveau niveau = new Niveau(1, "Débutant", 3, true);
        String nouveauLibelleTheme = "Nouveau libelle";
        niveau.setLibelle(nouveauLibelleTheme);
        NiveauDAO.update(niveau);
        assertTrue(NiveauDAO.getById(1).getLibelle().equals(nouveauLibelleTheme));
    }
}
