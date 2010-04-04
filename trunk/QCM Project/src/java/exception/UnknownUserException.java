package exception;

/**
 *
 * @author Maria Rabarison et Lou Ferrand
 */
public class UnknownUserException extends Exception {

    String error;

    public UnknownUserException() {
        super();
        this.error = "Echec de l'authentification, login ou mot de passe incorrect.";
    }

    public UnknownUserException(String error) {
        super(error);
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
