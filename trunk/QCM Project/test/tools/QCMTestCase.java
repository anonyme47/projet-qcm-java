package tools;

import java.io.FileInputStream;
import org.dbunit.DBTestCase;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.CompositeOperation;
import org.dbunit.operation.DatabaseOperation;
import util.Database;

/**
 *
 * @author Lou
 */
public class QCMTestCase extends DBTestCase {

    /** Dataset representant la base de donnees initiale.
     * Cette methode est abstraite dans DBTestCase et peut etre implementee
     * de la meme facon pour tous les tests, d'ou sa place ici.
     */
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSet(new FileInputStream("data/base-QCM.xml"));
    }

    @Override
    /** Indispensable pour obtenir une connexion */
    protected IDatabaseTester newDatabaseTester() throws Exception {
        return new JdbcDatabaseTester(Database.DRIVER_NAME, Database.URL,
                Database.USER, Database.PASSWORD);
    }

    @Override
    /** Operation sur la base de donnees executee avant tout test */
    protected DatabaseOperation getSetUpOperation() throws Exception {
        DatabaseOperation result = new CompositeOperation(DatabaseOperation.TRUNCATE_TABLE,
                DatabaseOperation.INSERT);
        return result;
    }
}
