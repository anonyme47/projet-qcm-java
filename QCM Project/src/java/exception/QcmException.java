package exception;

/**
 *
 * @author marya
 */
public class QcmException extends Exception {

    public static final Exception UnknownUserException = new Exception("Echec de l'authentification, login ou mot de passe incorrect.");

    public static final Exception UnknowQuestionnaireException = new Exception("Le questionnaire n'existe pas.");

    public static final Exception UnknowQuestionException = new Exception("La question n'existe pas.");

}
