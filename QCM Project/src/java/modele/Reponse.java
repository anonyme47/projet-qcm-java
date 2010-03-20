package modele;

/**
 *
 * @author Maria Rabarison et Lou Ferrand
 */
public class Reponse {
    private Integer idReponse;
    private String libelle;
    private String descriptif;
    private boolean estCorrecte;
    private int note;

    private int idQuestion;

    public Reponse(final Integer idReponse, final String libelle,
            final String descriptif, final boolean estCorrecte, final int note) {
        this.idReponse = idReponse;
        this.libelle = libelle;
        this.descriptif = descriptif;
        this.estCorrecte = estCorrecte;
        this.note = note;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public boolean isEstCorrecte() {
        return estCorrecte;
    }

    public void setEstCorrecte(boolean estCorrecte) {
        this.estCorrecte = estCorrecte;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Integer getIdReponse() {
        return idReponse;
    }

    public void setIdReponse(Integer idReponse) {
        this.idReponse = idReponse;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reponse other = (Reponse) obj;
        if ((this.libelle == null) ? (other.libelle != null) : !this.libelle.equals(other.libelle)) {
            return false;
        }
        if (this.idQuestion != other.idQuestion) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.libelle != null ? this.libelle.hashCode() : 0);
        hash = 29 * hash + this.idQuestion;
        return hash;
    }

    
}
