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

/**
 *
 * @author Maria Rabarison et Lou Ferrand
 */
public class Qcm {

    private int idQuestionnaire;
    private int idUser;
    private int note;
    private int questionCourante;
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
            this.note = 0;
        } catch (SQLException ex) {
            Logger.getLogger(Qcm.class.getName()).log(Level.SEVERE, null, ex);
        }
        assert invariant();
    }

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(final int idQuestionnaire) {
        assert idQuestionnaire > 0;
        this.idQuestionnaire = idQuestionnaire;
        assert invariant();
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(final int idUser) {
        assert idUser > 0;
        this.idUser = idUser;
        assert invariant();
    }

    public Iterator<Integer> getIterateur() {
        return iterateur;
    }

    public void setIterateur(Iterator<Integer> iterateur) {
        this.iterateur = iterateur;
    }

    public int getNote() {
        return note;
    }

    public void setNote(final int note) {
        this.note = note;
        assert invariant();
    }

    public int getQuestionCourante() {
        return questionCourante;
    }

    public void setQuestionCourante(final int questionCourante) {
        assert questionCourante > 0;
        this.questionCourante = questionCourante;
        assert invariant();
    }

    public Map<Integer, List<Integer>> getUserReponses() {
        return userReponses;
    }

    public void setUserReponses(final Map<Integer, List<Integer>> userReponses) {
        assert userReponses != null;
        this.userReponses = userReponses;
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
        assert getUserReponses() != null;
        assert getIdQuestionnaire() > 0;
        assert getQuestionCourante() > 0;
        return true;
    }
}
