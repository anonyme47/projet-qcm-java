package modele;

import java.util.Iterator;
import java.util.List;

/**
 * Une question est créée par un utilisateur et peut faire partie d'un
 * questionnaire (qui est une liste de question). Une question doit avoir au
 * moins une réponse (qui sont contenues elles aussi dans une liste). Cette
 * question est rattachée à un thème et à un libellé (qui serait par exemple:
 * <em>"Quelle est la couleur du cheval blanc d'Henri IV ?"</em>).
 * @author Maria Rabarison et Lou Ferrand
 */
public class Question {

    private Integer idQuestion;
    private String libelle;
    private boolean estModifiable;
    private List<Reponse> reponses;
    private int idTheme;
    private int idUser;

    /**
     * Constructeur pour une nouvelle question
     * @param idQuestion 
     * @param libelle
     * @param idTheme
     * @param idUser
     */
    public Question(final Integer idQuestion, final String libelle,
            final int idTheme, final int idUser, final int nbQuestionnairePasseAppelant, List<Reponse> reponses) {
        assert idQuestion == null || idQuestion >= 0 : "idQuestion doit être non négatif (reçu: " + idQuestion + ")";
        assert libelle != null && libelle.matches("^\\s*$") : "le libellé ne doit être ni null ni vide";
        this.idQuestion = idQuestion;
        this.libelle = libelle;
        this.idTheme = idTheme;
        this.idUser = idUser;
        if (nbQuestionnairePasseAppelant > 0) {
            this.estModifiable = false;
        } else {
            this.estModifiable = true;
        }
        //assert reponses non null;
        this.reponses = reponses;
        assert invariant();
    }

    public boolean estModifiable() {
        return estModifiable;
    }

    public void setEstModifiable(final boolean estModifiable) {
        this.estModifiable = estModifiable;
        assert invariant();
    }

    public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(final int idQuestion) {
        assert idQuestion > 0 : "Le numéro de la question doit être positif";
        this.idQuestion = idQuestion;
        assert invariant();
    }

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(final int idTheme) {
        assert idTheme > 0 : "L'identifiant du thème doit être positif";
        this.idTheme = idTheme;
        assert invariant();
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(final int idUser) {
        assert idUser > 0 : "L'identifiant de l'utilisateur doit être positif";
        this.idUser = idUser;
        assert invariant();
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(final String libelle) {
        assert libelle != null && !libelle.matches("^\\s*$") : "le libellé ne doit être ni null ni vide";
        this.libelle = libelle;
        assert invariant();
    }

    public List<Reponse> getReponses() {
        return reponses;
    }

    public void setReponses(List<Reponse> reponses) {
        assert reponses != null;
        this.reponses = reponses;
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
        final Question other = (Question) obj;
        if ((this.libelle == null) ? (other.libelle != null) : !this.libelle.equals(other.libelle)) {
            return false;
        }
        if (this.idTheme != other.idTheme) {
            return false;
        }
        return true;
    }

    /**
     * reponse non null
     * reponse n'existe pas deja dans la liste des réponses pour cette question
     * la question doit être modifiable
     * @param reponses
     */
    public void addReponse(Reponse reponse) {
        assert reponse != null;
        assert !reponses.contains(reponse);
        assert estModifiable();
        assert reponse.getIdQuestion() == this.getIdQuestion();
        this.reponses.add(reponse);
        assert invariant();
    }

    public boolean hasMultipleResponse() {
        return (reponses.size() > 1);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (this.libelle != null ? this.libelle.hashCode() : 0);
        hash = 37 * hash + this.idTheme;
        return hash;
    }

    @Override
    public String toString() {
        return "[ " + idQuestion + " : " + libelle + " : " + idTheme + " ]";
    }

    public int getNoteMax() {
        int note = 0;
        Iterator<Reponse> it = this.getReponses().iterator();
        Reponse rep = null;

        while (it.hasNext()) {

            rep = it.next();
            if (rep.estCorrecte()) {
                note += rep.getNote();
            }
        }
        return note;

    }

    protected boolean invariant() {
        assert getIdQuestion() > 0 : "Le numéro de la question doit être positif";
        assert getIdUser() > 0 : "L'identifiant de l'utilisateur doit être positif";
        assert getLibelle() != null && !getLibelle().matches("^\\s*$") : "le libellé ne doit être ni null ni vide";
        return true;
    }
}
