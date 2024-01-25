package Test;
import Factory.AppFactory;
import Factory.AppType;
import Factory.IAppFactory;
import Model.Category;
import Model.Transaction;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TransactionTest {
    static AppFactory appFactory = new AppFactory();
    static IAppFactory transactionController = appFactory.getApp(AppType.TRANSACTION);
    @Test
    public void test() {
        Transaction transaction = (Transaction) transactionController.getById(1);
        Double expectedAmount = 5000.0;
        assertEquals(expectedAmount, transaction.getAmount());
    }
}
