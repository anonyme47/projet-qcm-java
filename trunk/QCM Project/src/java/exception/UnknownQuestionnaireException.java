package exception;

/**
 *
 * @author Maria Rabarison et Lou Ferrand
 */
public class UnknownQuestionnaireException extends Exception {

    String error;

    public UnknownQuestionnaireException() {
        super();
        this.error = "Le questionnaire n'existe pas.";
    }

    public UnknownQuestionnaireException(String error) {
        super(error);
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
