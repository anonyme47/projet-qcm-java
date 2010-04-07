/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.ArrayList;
import java.util.List;
import modele.Question;
import modele.Reponse;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marya
 */
public class QuestionDAOTest {

    /**
     * Test of getReponsesById method, of class QuestionDAO.
     */
    @Test
    public void testGetById() throws Exception {
        System.out.println("getById");
        int idQuestion = 1;
        Question expResult = new Question(1, "Question 1 Theme 1", 1, 1, 0, new ArrayList<Reponse>());
        Question result = QuestionDAO.getById(idQuestion);
        assertTrue(result.equals(expResult));
        for(int i=0; i<result.getReponses().size();i++){
            assertNotNull(result.getReponses().get(i));
            assertTrue(result.getReponses().get(i).getIdReponse()==i+1);
        }
        assertFalse(result.estModifiable());
     }

    /**
     * Test of getReponsesById method, of class QuestionDAO.
     */
    @Test
    public void testGetReponsesById() throws Exception {
        System.out.println("getReponsesById");
        int idQuestion = 6;
        List<Reponse> expResult = new ArrayList<Reponse>();
        expResult.add(new Reponse(6, "Réponse 1", "Descriptif Réponse 1 Question 6", false,0,6));
        List<Reponse> result = QuestionDAO.getReponsesById(idQuestion);
        assertEquals(expResult.get(0), result.get(0));
     }

    /**
     * Test of getByTheme method, of class QuestionDAO.
     */
    @Test
    public void testGetByTheme() throws Exception {
        System.out.println("getByTheme");
        int idTheme = 4;
        List<Question> expResult = new ArrayList<Question>();
        expResult.add(QuestionDAO.getById(21));
        List<Question> result = QuestionDAO.getByTheme(idTheme);
        assertEquals(expResult.get(0), result.get(0));
    }




}