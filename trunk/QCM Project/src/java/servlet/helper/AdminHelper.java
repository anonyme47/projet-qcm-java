package servlet.helper;

import exception.ExpiredSessionException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import modele.Niveau;
import modele.Questionnaire;
import modele.Theme;
import modele.User;
import util.NiveauDAO;
import util.QuestionnaireDAO;
import util.ThemeDAO;
import util.UserDAO;

/**
 *
 * @author Lou
 */
public class AdminHelper extends RequestHelper {

    public AdminHelper(HttpServletRequest request) throws ExpiredSessionException, IOException {
        super(request);
    }

    public void setThemes() throws SQLException {
        HashMap<Integer, Theme> themes = ThemeDAO.getAll();
        request.setAttribute("themes", themes);
    }

    public void setNiveaux() throws SQLException {
        HashMap<Integer, Niveau> niveaux = NiveauDAO.getAll();
        request.setAttribute("niveaux", niveaux);
    }

    public void setQuestionnaires() throws SQLException {
        HashMap<Integer, Questionnaire> questionnaires = QuestionnaireDAO.getAll();
        request.setAttribute("questionnaires", questionnaires);
    }

    public void setUsers() throws SQLException {
        HashMap<Integer, User> users = UserDAO.getAll();
        request.setAttribute("users", users);
    }
}
