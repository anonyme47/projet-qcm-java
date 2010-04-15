package util;

import java.util.HashMap;
import modele.Theme;
import org.junit.Test;
import tools.QCMTestCase;
import static org.junit.Assert.*;

/**
 *
 * @author Lou
 */
public class ThemeDAOTest extends QCMTestCase {

    /**
     * Test of getAll method, of class ThemeDAO.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        HashMap<Integer, Theme> expResult = new HashMap<Integer, Theme>();
        expResult.put(1, ThemeDAO.getById(1));
        expResult.put(2, ThemeDAO.getById(2));
        expResult.put(3, ThemeDAO.getById(3));
        expResult.put(4, ThemeDAO.getById(4));
        expResult.put(5, ThemeDAO.getById(5));
        expResult.put(6, ThemeDAO.getById(6));
        HashMap<Integer, Theme> result = ThemeDAO.getAll();
        assertEquals(expResult.get(1), result.get(1));
        assertEquals(expResult.get(2), result.get(2));
        assertEquals(expResult.get(3), result.get(3));
        assertEquals(expResult.get(4), result.get(4));
        assertEquals(expResult.get(5), result.get(5));
        assertEquals(expResult.get(6), result.get(6));
    }

    /**
     * Test of getById method, of class ThemeDAO.
     */
    @Test
    public void testGetById() throws Exception {
        System.out.println("getById");
        Theme expResult = new Theme(1, 1, "Java", 1, true);
        Theme result = ThemeDAO.getById(1);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class ThemeDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Theme theme = new Theme(1, 1, "Java", 1, true);
        String nouveauLibelleTheme = "Nouveau theme";
        theme.setLibelle(nouveauLibelleTheme);
        ThemeDAO.update(theme);
        assertTrue(ThemeDAO.getById(1).getLibelle().equals(nouveauLibelleTheme));
    }


}
