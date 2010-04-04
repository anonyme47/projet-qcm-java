/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import util.QuestionnaireDAO;
import static org.junit.Assert.*;

/**
 *
 * @author marya
 */
public class QuestionnaireTest {

    public QuestionnaireTest() {
    }



    /**
     * Test of getNoteMax method, of class Questionnaire.
     */
    @Test
    public void testGetNoteMax() throws SQLException{
        System.out.println("getNoteMax");
        Questionnaire instance = QuestionnaireDAO.getById(4);
        int expResult = 6;
        int result = instance.getNoteMax();
        assertEquals(expResult, result);
    }

   
}