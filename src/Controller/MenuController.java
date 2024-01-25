package Controller;

import Factory.AppFactory;
import Factory.AppType;
import Factory.IAppFactory;
import Model.Budget;
import View.MenuView;

public class MenuController {
    AppFactory appFactory = new AppFactory();
    IAppFactory transactionController = appFactory.getApp(AppType.TRANSACTION);
    IAppFactory transactionController1 = appFactory.getApp(AppType.CATEGORY);
    private static MenuView menuView;

    public static void mainMenu() {
        menuView.displayMainMenu();
    }

}
