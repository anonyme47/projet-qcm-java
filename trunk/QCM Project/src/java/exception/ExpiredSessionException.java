/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exception;

/**
 *
 * @author marya
 */
public class ExpiredSessionException extends Exception{

    public ExpiredSessionException(String message) {
        super(message);
    }

}
