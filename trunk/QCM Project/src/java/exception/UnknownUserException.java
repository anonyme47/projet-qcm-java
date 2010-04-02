/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exception;


/**
 *
 * @author marya
 */
public class UnknownUserException extends Exception{
    public static final Exception UnknownQuestionnaireException = new Exception("jhsjdf");
    public static void main(String[] args){
        try{
            throw UnknownUserException.UnknownQuestionnaireException;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
