

package modele;

/**
 *
 * @author maria Rabarison et Lou Ferrand
 */
public class Niveau {
    private Integer idNiveau;
    private String libelle;

    /**
     * Constructeur de niveau
     * @param idNiveau L'identifiant du niveau
     * @param libelle Le libelle du niveau
     */
    public Niveau(int idNiveau, String libelle){
        this.idNiveau=idNiveau;
        this.libelle=libelle;
    }

    
    public Integer getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Integer idNiveau) {
        this.idNiveau = idNiveau;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Niveau other = (Niveau) obj;
        if ((this.libelle == null) ? (other.libelle != null) : !this.libelle.equals(other.libelle)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.libelle != null ? this.libelle.hashCode() : 0);
        return hash;
    }

    @Override
    /**
     * Permet d'avoir les informations sur le niveau
     */
    public String toString(){
        return "Niveau : "+getIdNiveau()+" - "+getLibelle();
    }
    
}
