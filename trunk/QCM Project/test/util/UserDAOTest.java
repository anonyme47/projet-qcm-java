/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import modele.Statut;
import modele.User;
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
public class UserDAOTest {

    

    /**
     * Test of getByLoginAndPassword method, of class UserDAO.
     */
    @Test
    public void testGetByLoginAndPassword() throws Exception {
        System.out.println("getByLoginAndPassword");
        String login = "Maria";
        String password = "maria";
        User expResult = new User(null,login,password,"maryarabarison@gmail.com",new Statut(1,"Enseignant"));
        User result = UserDAO.getByLoginAndPassword(login, password);
        assertEquals(expResult, result);
    }

}