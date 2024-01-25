package Test;
import Factory.AppFactory;
import Factory.AppType;
import Factory.IAppFactory;
import Model.Budget;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class BudgetTest {
    static AppFactory appFactory = new AppFactory();
    static IAppFactory budgetController = appFactory.getApp(AppType.BUDGET);
    @Test
    public void test() {
        Budget budget = (Budget) budgetController.getById(1);

        assertEquals("jan",budget.getName());
    }
}
