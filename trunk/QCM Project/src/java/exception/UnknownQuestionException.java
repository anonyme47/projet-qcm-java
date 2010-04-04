package exception;

/**
 *
 * @author Maria Rabarison et Lou Ferrand
 */
public class UnknownQuestionException extends Exception {

    String error;

    public UnknownQuestionException() {
        super();
        this.error = "La question n'existe pas.";
    }

    public UnknownQuestionException(String error) {
        super(error);
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
