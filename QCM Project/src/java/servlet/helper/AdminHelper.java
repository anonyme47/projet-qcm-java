package servlet.helper;

import exception.ExpiredSessionException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public void setQuestionnaires() throws SQLException {
        HashMap<Integer, Questionnaire> questionnaires = QuestionnaireDAO.getAll();
        request.setAttribute("questionnaires", questionnaires);
    }

    public void setUsers() throws SQLException {
        HashMap<Integer, User> users = UserDAO.getAll();
        request.setAttribute("users", users);
    }

    public void setAttributeNiveau() throws SQLException {
        Integer idNiveau = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("niveau", NiveauDAO.getById(idNiveau));
    }

    public void setAttributeTheme() throws SQLException {
        Integer idTheme = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("theme", ThemeDAO.getById(idTheme));
    }

    /**
     *
     */
    public void controleQuestionnaire() {
        Integer idQuestionnaire = Integer.parseInt(request.getParameter("id"));
        if (idQuestionnaire != null && idQuestionnaire >= 0) {
            try {
                Boolean estActif = Boolean.parseBoolean(request.getParameter("est_actif"));
                Questionnaire q = QuestionnaireDAO.getById(idQuestionnaire);
                q.setEstActif(estActif);
                QuestionnaireDAO.update(q);
                String message = "Le questionnaire <strong>" + q.getLibelle() + "</strong> a été ";
                if (estActif) {
                    message += "activé";
                } else {
                    message += "désactivé";
                }
                request.setAttribute("message", message);
            } catch (SQLException ex) {
                request.setAttribute("errorMessage", "Une erreur s'est produite lors de la mise à jour : " + ex.getMessage());
                Logger.getLogger(AdminHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.setAttribute("message", "Questionnaire inexistant");
        }
    }

    public void controleNiveau() {
        Integer idNiveau = Integer.parseInt(request.getParameter("id"));
        if (idNiveau != null && idNiveau >= 0) {
            try {
                Boolean estActif = Boolean.parseBoolean(request.getParameter("est_actif"));
                Niveau niveau = NiveauDAO.getById(idNiveau);
                niveau.setEstActif(estActif);
                NiveauDAO.update(niveau);
                String message = "Le niveau <strong>" + niveau.getLibelle() + "</strong> a été ";
                if (estActif) {
                    message += "activé";
                } else {
                    message += "désactivé";
                }
                request.setAttribute("message", message);
            } catch (SQLException ex) {
                request.setAttribute("errorMessage", "Une erreur s'est produite lors de la suppression : " + ex.getMessage());
                Logger.getLogger(AdminHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.setAttribute("message", "Niveau inexistant");
        }
    }

    public void controleTheme() {
        Integer idTheme = Integer.parseInt(request.getParameter("id"));
        if (idTheme != null && idTheme >= 0) {
            try {
                Boolean estActif = Boolean.parseBoolean(request.getParameter("est_actif"));
                Theme theme = ThemeDAO.getById(idTheme);
                theme.setEstActif(estActif);
                ThemeDAO.update(theme);
                String message = "Le thème <strong>" + theme.getLibelle() + "</strong> a été ";
                if (estActif) {
                    message += "activé";
                } else {
                    message += "désactivé";
                }
                request.setAttribute("message", message);
            } catch (SQLException ex) {
                request.setAttribute("errorMessage", "Une erreur s'est produite lors de la mise à jour : " + ex.getMessage());
                Logger.getLogger(AdminHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.setAttribute("message", "Thème inexistant");
        }
    }

    public void controleUser() {
        Integer idUser = Integer.parseInt(request.getParameter("id"));
        if (idUser != null && idUser >= 0) {
            System.out.println(idUser);
            try {
                Boolean estActif = Boolean.parseBoolean(request.getParameter("est_actif"));
                User user = UserDAO.getById(idUser);
                user.setEstActif(estActif);
                UserDAO.update(user);
                String message = "Le compte utilisateur de <strong>" + user.getNom() + " " + user.getPrenom() + "</strong> a été ";
                if (estActif) {
                    message += "activé";
                } else {
                    message += "désactivé";
                }
                request.setAttribute("message", message);
            } catch (SQLException ex) {
                request.setAttribute("errorMessage", "Une erreur s'est produite lors de la suppression : " + ex.getMessage());
                Logger.getLogger(AdminHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.setAttribute("message", "Utilisateur inexistant");
        }
    }

    public void editTheme() {
        Integer idTheme = Integer.parseInt(request.getParameter("id"));
        if (idTheme != null && idTheme >= 0) {
            try {
                String libelle = request.getParameter("libelle");
                Theme theme = ThemeDAO.getById(idTheme);
                theme.setLibelle(libelle);
                ThemeDAO.update(theme);
                request.setAttribute("message", "La modification du niveau s'est déroulée correctement.");
            } catch (SQLException ex) {
                request.setAttribute("errorMessage", "Une erreur s'est produite lors de la mise à jour : " + ex.getMessage());
                Logger.getLogger(AdminHelper.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException ex) {
                request.setAttribute("errorMessage", "Une erreur s'est produite lors de la mise à jour : " + ex.getMessage());
                Logger.getLogger(AdminHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.setAttribute("message", "Thème inexistant");
        }
    }

    public void editNiveau() {
        Integer idNiveau = Integer.parseInt(request.getParameter("id"));
        if (idNiveau != null && idNiveau >= 0) {
            try {
                String libelle = request.getParameter("libelle");
                Niveau niveau = NiveauDAO.getById(idNiveau);
                niveau.setLibelle(libelle);
                NiveauDAO.update(niveau);
                request.setAttribute("message", "La modification du niveau s'est déroulée correctement.");
            } catch (SQLException ex) {
                request.setAttribute("errorMessage", "Une erreur s'est produite lors de la mise à jour : " + ex.getMessage());
                Logger.getLogger(AdminHelper.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException ex) {
                request.setAttribute("errorMessage", "Une erreur s'est produite lors de la mise à jour : " + ex.getMessage());
                Logger.getLogger(AdminHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.setAttribute("message", "Niveau inexistant");
        }
    }
}
