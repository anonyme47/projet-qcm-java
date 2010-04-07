/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import modele.Reponse;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lou
 */
public class ReponseDAOTest {

    public ReponseDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of getById method, of class ReponseDAO.
     */
    @Test
    public void testGetById() throws Exception {
        System.out.println("getById");
        int idReponse = 0;
        Reponse expResult = null;
        Reponse result = ReponseDAO.getById(idReponse);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}