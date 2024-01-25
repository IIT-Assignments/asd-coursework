package Test;
import Factory.AppFactory;
import Factory.AppType;
import Factory.IAppFactory;
import Model.Category;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class CategoryTest {

    static AppFactory appFactory = new AppFactory();
    static IAppFactory categoryController = appFactory.getApp(AppType.CATEGORY);
    @Test
    public void test() {
        Category categoryTest = (Category) categoryController.getById(1);

        assertEquals("Food",categoryTest.getName());
    }
}
