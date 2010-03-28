package util;

import java.util.HashMap;
import modele.Theme;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lou
 */
public class ThemeDAOTest {

    /**
     * Test of getAll method, of class ThemeDAO.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        HashMap<Integer, String> expResult = new HashMap<Integer, String>();
        expResult.put(1, "Java");
        expResult.put(2, "Ruby");
        expResult.put(3, "C++");
        expResult.put(4, "PHP");
        expResult.put(5, "UML");
        expResult.put(6, "POO");
        HashMap<Integer, String> result = ThemeDAO.getAll();
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
        Theme expResult = new Theme(1, 1, "Java");
        Theme result = ThemeDAO.getById(1);
        assertEquals(expResult, result);
    }
}
