/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;
import java.sql.Date;

/**
 *
 * @author marya
 */
public class QuestionnairePasse {
    private int idQuestionnaire;
    private int idUser;
    private int note;
    private Date date;

    public QuestionnairePasse(int idQuestionnaire, int idUser, int note, Date date) {
        this.idQuestionnaire = idQuestionnaire;
        this.idUser = idUser;
        this.note = note;
        this.date = date;
    }

    public QuestionnairePasse(int idQuestionnaire, int idUser) {
        this.idQuestionnaire = idQuestionnaire;
        this.idUser = idUser;
    }


    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        assert date != null;
        this.date = date;
        assert invariant();
    }

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(int idQuestionnaire) {
        assert idQuestionnaire > 0;
        this.idQuestionnaire = idQuestionnaire;
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

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
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
        final QuestionnairePasse other = (QuestionnairePasse) obj;
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
        int hash = 7;
        hash = 29 * hash + this.idQuestionnaire;
        hash = 29 * hash + this.idUser;
        return hash;
    }


    protected boolean invariant(){
        assert getIdUser() > 0;
        assert getIdQuestionnaire() > 0;
        return true;
    }
    

}
