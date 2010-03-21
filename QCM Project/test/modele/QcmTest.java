package modele;

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;
import tools.QCMTestCase;
import util.QuestionnaireDAO;

/**
 *
 * @author Lou
 */
public class QcmTest extends QCMTestCase {

    @Test
    public void testQcm() throws SQLException {
        System.out.println("Qcm");
        Qcm instance = new Qcm(1, 1);
        ArrayList<Integer> expResult = new ArrayList<Integer>();
        expResult.add(1);
        expResult.add(2);
        expResult.add(3);
        ArrayList<Integer> result = QuestionnaireDAO.getQuestions(instance.getIdQuestionnaire());
        assertTrue(expResult.containsAll(result) && result.containsAll(expResult));
        assertTrue(instance.getIterateur() != null);
    }

    /**
     * Test of getQuestionCourante method, of class Qcm.
     */
    @Test
    public void testGetQuestionCourante() {
        System.out.println("getQuestionCourante");
        Qcm instance = new Qcm(1, 1);
        int expResult = 1;
        int result = instance.getQuestionCourante();
        assertEquals(expResult, result);
    }

//    /**
//     * Test of setQuestionCourante method, of class Qcm.
//     */
//    @Test
//    public void testSetQuestionCourante() {
//        System.out.println("setQuestionCourante");
//        int questionCourante = 0;
//        Qcm instance = null;
//        instance.setQuestionCourante(questionCourante);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }


    /**
     * Test of invariant method, of class Qcm.
     */
//    @Test
//    public void testInvariant() {
//        System.out.println("invariant");
//        Qcm instance = null;
//        boolean expResult = false;
//        boolean result = instance.invariant();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}