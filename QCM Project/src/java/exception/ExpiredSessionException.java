package exception;

/**
 *
 * @author Maria Rabarison et Lou Ferrand
 */
public class ExpiredSessionException extends Exception {

    String error;

    public ExpiredSessionException() {
        super();
        this.error = "Vous n'êtes pas connecté ou votre session a expiré.";
    }

    public ExpiredSessionException(String error) {
        super(error);
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
