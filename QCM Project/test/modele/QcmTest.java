package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import tools.QCMTestCase;
import util.Database;
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
    }

    /**
     * Test of getQuestionCourante method, of class Qcm.
     */
    @Test
    public void testGetQuestionCourante() throws SQLException {
        System.out.println("getQuestionCourante");
        Qcm instance = new Qcm(1, 1);
        int expResult = 1;
        int result = instance.getQuestionCourante();
        assertEquals(expResult, result);
    }



    /**
     * Test of setUserReponse method, of class Qcm.
     */
    @Test
    public void testSetUserReponses() {
        System.out.println("setUserReponse");
        int idQuestionnaire = 1;
        int idQuestion = 1;
        Qcm instance = new Qcm(idQuestionnaire, idQuestion);
        List<Integer> reponses= new ArrayList<Integer>();
        reponses.add(1);
        reponses.add(2);
        instance.setUserReponses(idQuestion,reponses);
        assertTrue(instance.getUserReponses().get(idQuestion).containsAll(reponses));
        assertTrue(reponses.containsAll(instance.getUserReponses().get(idQuestion)));
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

    /**
     *
     */
    @Test
    public void testGetNote() throws SQLException {
        System.out.println("getNote");
        int idQuestionnaire = 1;
        int idQuestion = 1;
        Qcm instance = new Qcm(idQuestionnaire, idQuestion);
        List<Integer> reponses= new ArrayList<Integer>();
        reponses.add(1);
        reponses.add(3);
        instance.setUserReponses(idQuestion,reponses);
        int expResult = 5;
        instance.setEstFini(true);
        int result = instance.getNote();
        assertEquals(expResult, result);
    }

        @Test
    public void testSave() throws SQLException {
        System.out.println("save");
        int idQuestionnaire = 1;
        int idQuestion = 1;
        Qcm instance = new Qcm(idQuestionnaire, idQuestion);
        List<Integer> reponses= new ArrayList<Integer>();
        reponses.add(1);
        reponses.add(3);
        instance.setUserReponses(idQuestion,reponses);
        System.out.println(instance.getQuestionCourante());
        System.out.println(instance.getQuestionCourante());
        System.out.println(instance.getQuestionCourante());
        instance.save();
        assertTrue(instance.estFini());
    }

}
