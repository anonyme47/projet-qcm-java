package util;

import java.sql.Connection;
import java.sql.ResultSet;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lou
 */
public class ModeleDAOTest {

    /**
     * Test of getConnection method, of class ModeleDAO.
     */
    @Test
    public void testGetConnection() throws Exception {
        System.out.println("getConnection");
        Connection result = ModeleDAO.getConnection();
        assertTrue(result != null && result instanceof Connection);
//        assertFalse(expResult.equals(result));
    }

    /**
     * Test of execute method, of class ModeleDAO.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        String sql = "";
        ResultSet expResult = null;
        ResultSet result = ModeleDAO.execute(sql);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectById method, of class ModeleDAO.
     */
    @Test
    public void testSelectById() throws Exception {
        System.out.println("selectById");
        String sql = "SELECT libelle FROM questionnaire WHERE id_questionnaire = ?";
        int id = 1;
        ResultSet expResult = null;
        ResultSet result = ModeleDAO.selectById(sql, id);
        assertEquals(expResult, result);
    }

}