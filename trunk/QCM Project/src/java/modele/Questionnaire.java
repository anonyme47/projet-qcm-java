package modele;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe Questionnaire est définie par un identifiant, un thème, un niveau,
 * un utilisateur qui a créé le questionnaire, un libellé, la date de création,
 * la limite de temps, le statut s'il est actif ou non et une collection de
 * questions le constituant.
 * 
 * @author Maria Rabarison et Lou Ferrand
 */
public class Questionnaire {

    private Integer idQuestionnaire;
    private String libelle;
    private Date dateCreation;
    private Integer limiteTemps;
    private List<Question> questions;
    private boolean estActif;
    private boolean estPasse;
    private int idTheme;
    private int idUser;
    private int idNiveau;

    /**
     * Constructeur pour un questionnaire existant
     * @param idQuestionnaire
     * @param libelle
     * @param dateCreation
     * @param limiteTemps
     * @param estActif
     * @param estPasse
     * @param idTheme
     * @param idUser
     * @param idNiveau
     */
    public Questionnaire(int idQuestionnaire, String libelle, Date dateCreation,
            Integer limiteTemps, boolean estActif, int idTheme, 
            int idUser, int idNiveau, ArrayList<Question> questions , int nbPasseParUser) {
        assert idQuestionnaire > 0;
        assert libelle != null && !libelle.matches("^\\s*$");
        assert dateCreation != null;
        assert idTheme > 0;
        assert idUser > 0;
        assert idNiveau > 0;
        assert limiteTemps == null || limiteTemps > 0;

        this.idQuestionnaire = idQuestionnaire;
        this.libelle = libelle;
        this.dateCreation = dateCreation;
        this.limiteTemps = limiteTemps;
        this.estActif = estActif;
        
        if(nbPasseParUser>0){
            this.estPasse = true;
        }else{
            this.estPasse = false;
        }
        
        this.idTheme = idTheme;
        this.idUser = idUser;
        this.idNiveau = idNiveau;
        this.questions = questions;
        assert invariant();
    }
    /**
     * Constructeur pour un nouveau questionnaire
     * @param idQuestionnaire
     * @param libelle
     * @param dateCreation
     * @param limiteTemps
     * @param estActif
     * @param estPasse
     * @param idTheme
     * @param idUser
     * @param idNiveau
     */
    public Questionnaire(String libelle, int idTheme, int idUser, int idNiveau) {
        assert libelle != null && !libelle.matches("^\\s*$");
        assert idTheme > 0;
        assert idUser > 0;
        assert idNiveau > 0;

        this.libelle = libelle;
        this.idTheme = idTheme;
        this.idUser = idUser;
        this.idNiveau = idNiveau;
        this.questions = new ArrayList<Question>();
        assert invariant();
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        assert dateCreation != null;
        this.dateCreation = dateCreation;
    }

    public boolean estActif() {
        return estActif;
    }

    public void setEstActif(boolean estActif) {
        this.estActif = estActif;
        assert invariant();
    }

    public boolean estPasse() {
        return estPasse;
    }

    

    public int getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(final int idNiveau) {
        assert idNiveau > 0 : "L'identifiant du niveau doit être > 0";
        this.idNiveau = idNiveau;
        assert invariant();
    }

    public Integer getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(final Integer idQuestionnaire) {
        assert idQuestionnaire == null || idQuestionnaire > 0 : "Le numéro du questionnaire doit être positif";
        this.idQuestionnaire = idQuestionnaire;
        assert invariant();
    }

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(final int idTheme) {
        assert idTheme > 0;
        this.idTheme = idTheme;
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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(final String libelle) {
        assert libelle != null && !libelle.matches("^\\s*$");
        this.libelle = libelle;
        assert invariant();
    }

    public Integer getLimiteTemps() {
        return limiteTemps;
    }

    public void setLimiteTemps(final Integer limiteTemps) {
        assert limiteTemps == null || limiteTemps > 0;
        this.limiteTemps = limiteTemps;
        assert invariant();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(final List<Question> questions) {
        assert questions != null;
        this.questions = questions;
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
        final Questionnaire other = (Questionnaire) obj;
        if ((this.libelle == null) ? (other.libelle != null) : !this.libelle.equals(other.libelle)) {
            return false;
        }
        if (this.idTheme != other.idTheme) {
            return false;
        }
        if (this.idNiveau != other.idNiveau) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + (this.libelle != null ? this.libelle.hashCode() : 0);
        hash = 19 * hash + this.idTheme;
        hash = 19 * hash + this.idNiveau;
        return hash;
    }

    @Override
    public String toString() {
        return "[" + libelle + ":" + idTheme + ":" + idNiveau + "]";
    }

    public boolean invariant() {
        assert getLibelle() != null && !getLibelle().matches("^\\s*$");
        assert getLimiteTemps() == null || getLimiteTemps() > 0;
        assert getIdQuestionnaire() == null || getIdQuestionnaire() > 0 : "Le numéro du questionnaire doit être positif";
        assert getIdUser() > 0;
        assert getIdNiveau() > 0;
        assert getIdTheme() > 0;
        return true;
    }
}
