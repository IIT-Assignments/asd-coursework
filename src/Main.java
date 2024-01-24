import Factory.AppFactory;
import Factory.AppType;
import Factory.IAppFactory;

public class Main {
    public static void main(String[] args) {
        AppFactory appFactory = new AppFactory();
        IAppFactory transactionController = appFactory.getApp(AppType.TRANSACTION);
        IAppFactory transactionController1 = appFactory.getApp(AppType.CATEGORY);
//        transactionController.create();
        transactionController.getAll();
    }
}
