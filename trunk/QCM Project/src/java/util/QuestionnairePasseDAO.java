/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.QuestionnairePasse;

/**
 *
 * @author marya
 */
public class QuestionnairePasseDAO extends ModeleDAO {

    public static List<QuestionnairePasse> getByUser(int idUser) throws SQLException {
        List<QuestionnairePasse> qP = new ArrayList<QuestionnairePasse>();
        String sql = "SELECT id_questionnaire, libelle_questionnaire, id_user, note, date , limite_temps FROM questionnaire_passe WHERE id_user = ? ORDER BY id_questionnaire";
        ResultSet rs = selectById(sql, idUser);
        while (rs.next()) {
            qP.add(new QuestionnairePasse(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getInt(4), rs.getDate(5),rs.getInt(6)));
        }
        rs.close();
        return qP;
    }
}
