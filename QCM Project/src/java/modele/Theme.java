/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author maria Rabarison et Lou Ferrand
 */
public class Theme {

    private Integer idTheme;
    private String libelle;
    private int idUser;

    public Theme(Integer idTheme, int idUser, String libelle) {
        assert libelle != null && !libelle.matches("^\\s*$") : "Le Libelle ne doit être ni null ni vide";
        assert idTheme == null || idTheme > 0 : "idTheme doit être non négatif (reçu: " + idTheme + " )";
        assert idUser > 0;
        this.idTheme = idTheme;
        this.libelle = libelle;
        assert invariant();
    }

    public Integer getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        assert idTheme > 0 : "idTheme doit être non négatif (reçu: " + idTheme + " )";
        this.idTheme = idTheme;
        assert invariant();
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        assert idUser > 0;
        this.idUser = idUser;
        assert invariant();
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        assert libelle != null && !libelle.matches("^\\s*$") : "Le Libelle ne doit être ni null ni vide";
        this.libelle = libelle;
        assert invariant();
    }

    protected boolean invariant() {
        assert getLibelle() != null && !getLibelle().matches("^\\s*$") : "Le Libelle ne doit être ni null ni vide";
        assert getIdUser() > 0;
        assert getIdTheme() == null || getIdTheme() > 0;
        return true;
    }
}
