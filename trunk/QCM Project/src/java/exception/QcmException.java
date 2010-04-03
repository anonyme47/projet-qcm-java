package exception;

/**
 *
 * @author Maria Rabarison et Lou Ferrand
 */
public class QcmException extends Exception {

    /**
     * Exception sur la gestion de l'utilisateur
     */
    public static final Exception UnknownUserException = new Exception("UnknownUserException : Echec de l'authentification, login ou mot de passe incorrect.");

    public static final Exception UnknowQuestionnaireException = new Exception("UnknowQuestionnaireException : Le questionnaire n'existe pas.");

    public static final Exception UnknowQuestionException = new Exception("UnknowQuestionException : La question n'existe pas.");

    public static final Exception ExpiredSessionException = new Exception("ExpiredSessionException : Vous n'êtes pas connecté ou votre session a expiré.");

    

}
