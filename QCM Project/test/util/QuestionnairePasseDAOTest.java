/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lou
 */
public class QuestionnairePasseDAOTest {

    public QuestionnairePasseDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of getByUser method, of class QuestionnairePasseDAO.
     */
    @Test
    public void testGetByUser() throws Exception {
        System.out.println("getByUser");
        int idUser = 0;
        List expResult = null;
        List result = QuestionnairePasseDAO.getByUser(idUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}