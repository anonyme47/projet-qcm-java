/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.ArrayList;
import modele.Questionnaire;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
        assertTrue(result.estPasse());
    }

    /**
     * Test of getQuestions method, of class QuestionnaireDAO.
     */
    @Test
    public void testGetQuestions() throws Exception {
        System.out.println("getQuestions");
        //Déjà testé dans modele.QcmTest.java
        
    }

}