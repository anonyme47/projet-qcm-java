/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.HashMap;
import java.util.Map;
import modele.Questionnaire;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marya
 */
public class QuestionnaireDAOTest {

    public QuestionnaireDAOTest() {
    }

    /**
     * Test of getById method, of class QuestionnaireDAO.
     */
    @Test
    public void testGetById() throws Exception {
        System.out.println("getById");
        int idQuestionnaire = 1;
        Questionnaire questionnaire=new Questionnaire("Les exceptions en Java", 1, 1,1);
        Questionnaire result = QuestionnaireDAO.getById(idQuestionnaire);
        assert result.invariant();
        assertTrue(result.equals(questionnaire));
        assertFalse(result.getQuestions().isEmpty());

        assertFalse(result.estPasse());
    }

    /**
     * Test of getByThemeAndNiveau method, of class QuestionnaireDAO.
     */
    @Test
    public void testGetQuestionnairesByThemeAndNiveau() throws Exception {
        System.out.println("getByThemeAndNiveau");
        int idTheme = 4;
        int idNiveau = 1;
        Map<Integer, String> expResult = new HashMap<Integer, String>();
        expResult.put(4,"Test");
        Map<Integer, String> result = QuestionnaireDAO.getQuestionnairesByThemeAndNiveau(idTheme, idNiveau);
        assertEquals(expResult.get(4), result.get(4));
     }

    /**
     * Test of getByTheme method, of class QuestionnaireDAO.
     */
    @Test
    public void testGetQuestionnairesByTheme() throws Exception {
        System.out.println("getByTheme");
        int idTheme = 4;
        Map<Integer, String> expResult = new HashMap<Integer, String>();
        expResult.put(4,"Test");
        Map<Integer, String> result = QuestionnaireDAO.getQuestionnairesByTheme(idTheme);
        assertEquals(expResult.get(4), result.get(4));
    }

    /**
     * Test of getByNiveau method, of class QuestionnaireDAO.
     */
    @Test
    public void testGetQuestionnairesByNiveau() throws Exception {
        System.out.println("getByNiveau");
        int idNiveau = 2;
        HashMap<Integer, String> expResult = new HashMap<Integer, String>();
        expResult.put(2,"L'héritage en Ruby");
        HashMap<Integer, String> result = QuestionnaireDAO.getQuestionnairesByNiveau(idNiveau);
        assertEquals(expResult.get(2), result.get(2));
    }


}