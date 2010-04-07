package util;

import modele.Qcm;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lou
 */
public class QcmDAOTest {

    /**
     * Test of insert method, of class QcmDAO.
     */
    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        Qcm qcm = new Qcm(4, 3);
        QcmDAO.insert(qcm);
    }

    /**
     * Test of getIdContenu method, of class QcmDAO.
     */
    @Test
    public void testGetIdContenu() throws Exception {
        System.out.println("getIdContenu");
        int idQuestionnaire = 0;
        int idQuestion = 0;
        Integer expResult = null;
        Integer result = QcmDAO.getIdContenu(idQuestionnaire, idQuestion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
