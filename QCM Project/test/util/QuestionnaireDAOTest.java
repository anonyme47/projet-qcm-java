package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import modele.Question;
import modele.Questionnaire;
import modele.Reponse;
import org.junit.Test;
import tools.QCMTestCase;
import static org.junit.Assert.*;

/**
 *
 * @author marya
 */
public class QuestionnaireDAOTest extends QCMTestCase {

    /**
     * Test of getById method, of class QuestionnaireDAO.
     */
    @Test
    public void testGetById() throws Exception {
        System.out.println("getById");
        int idQuestionnaire = 1;
        Questionnaire questionnaire = new Questionnaire("Les exceptions en Java", 1, 1, 1);
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

    /**
     * Test of getQuestionsById method, of class QuestionnaireDAO.
     */
    @Test
    public void testGetQuestionsById() throws Exception {
        System.out.println("getQuestionsById");
        int idQuestionnaire = 2;
        ArrayList<Question> expResult = new ArrayList<Question>();
        expResult.add(new Question(21, "Question 11 Theme 2", 2, 1, 0, new ArrayList<Reponse>()));
        expResult.add(new Question(21, "Question 12 Theme 2", 2, 1, 0, new ArrayList<Reponse>()));
        ArrayList<Question> result = QuestionnaireDAO.getQuestionsById(idQuestionnaire);
        assertEquals(expResult, result);
    }

    /**
     * Test of search method, of class QuestionnaireDAO.
     */
    @Test
    public void testSearch() throws Exception {
        System.out.println("search");
        int idTheme = 2;
        int idNiveau = 2;
        String libelle = "L'héritage en Ruby";
        Questionnaire expResult = QuestionnaireDAO.getById(2);
        Questionnaire result = QuestionnaireDAO.search(idTheme, idNiveau, libelle);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class QuestionnaireDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Questionnaire q = QuestionnaireDAO.getById(2);
        Questionnaire q2 = QuestionnaireDAO.getById(2);
        q2.setLibelle("Test d'update");
        QuestionnaireDAO.update(q2);
        assertFalse(q.equals(q2));
    }

    /**
     * Test of insert method, of class QuestionnaireDAO.
     */
    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        Questionnaire questionnaire = QuestionnaireDAO.getById(4);
        questionnaire.setLibelle("Test d'insert");
        QuestionnaireDAO.insert(questionnaire);
        Questionnaire nouveauQuestionnaire = QuestionnaireDAO.getById(5);
        assertTrue(questionnaire.equals(nouveauQuestionnaire));
    }

}