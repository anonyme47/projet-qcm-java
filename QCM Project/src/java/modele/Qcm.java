package modele;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.QuestionnaireDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import util.ReponseDAO;

/**
 *
 * @author Maria Rabarison et Lou Ferrand
 */
public class Qcm {

    private int idQuestionnaire;
    private int idUser;
    private int questionCourante;
    private boolean estFini;
    private Map<Integer, List<Integer>> userReponses;
    private Iterator<Integer> iterateur;

    public Qcm(final int idQuestionnaire, final int idUser) {
        assert idQuestionnaire > 0;
        assert idUser > 0;
        try {
            this.idQuestionnaire = idQuestionnaire;
            this.idUser = idUser;
            userReponses = new HashMap<Integer, List<Integer>>();
            ArrayList<Integer> questions = QuestionnaireDAO.getQuestions(idQuestionnaire);
            for (Integer i : questions) {
                userReponses.put(i, new ArrayList<Integer>());
            }
            iterateur = userReponses.keySet().iterator();
            questionCourante = iterateur.next();
            this.estFini = false;
        } catch (SQLException ex) {
            Logger.getLogger(Qcm.class.getName()).log(Level.SEVERE, null, ex);
        }
        assert invariant();
    }

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getNote() throws SQLException {
        assert estFini;
        int note = 0;
        List<Integer> reponses = null;
        for (Integer idQuestion : userReponses.keySet()) {
            reponses = userReponses.get(idQuestion);
            for (Integer reponse : reponses) {
                note += ReponseDAO.getNoteById(reponse);
            }
        }
        return note;
    }

    public boolean estFini() {
        return estFini;
    }

    public void setEstFini(boolean estFini) {
        this.estFini = estFini;
        assert invariant();
    }

    public int getQuestionCourante() {
        int idQuestionCourante = questionCourante;
        if (iterateur.hasNext()) {
            questionCourante = iterateur.next();
        }
        return idQuestionCourante;
    }

    public void setQuestionCourante(final int questionCourante) {
        assert questionCourante > 0;
        this.questionCourante = questionCourante;
        assert invariant();
    }

    public Map<Integer, List<Integer>> getUserReponses() {
        return userReponses;
    }

    /**
     * 
     * @param idQuestion
     * @param reponses
     */
    public void setUserReponses(Integer idQuestion, List<Integer> reponses) {
        assert idQuestion != null && idQuestion > 0;
        assert userReponses.containsKey(idQuestion);
        assert reponses != null;
        this.userReponses.put(idQuestion, reponses);
        assert invariant();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Qcm other = (Qcm) obj;
        if (this.idQuestionnaire != other.idQuestionnaire) {
            return false;
        }
        if (this.idUser != other.idUser) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.idQuestionnaire;
        hash = 53 * hash + this.idUser;
        return hash;
    }

    protected boolean invariant() {
        assert !estFini();
        assert getUserReponses() != null && getUserReponses().size() > 0;
        assert getIdQuestionnaire() > 0;
        assert getQuestionCourante() > 0;
        return true;
    }

    public void save() throws SQLException {
        assert invariant();
        /**
         * TODO: créer un QCM DAO
         */
        assert estFini();
    }

    /**
     * Remet l'itérateur au debut de la map pour recommencer le questionnaire
     */
    public void reset() {
        assert !estFini();
        iterateur = userReponses.keySet().iterator();
        questionCourante = iterateur.next();
        assert invariant();
    }

}
