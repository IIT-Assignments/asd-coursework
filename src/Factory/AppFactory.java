package Factory;

import Controller.BudgetController;
import Controller.CategoryController;
import Controller.TransactionController;
import Service.DataService;
import View.BudgetView;
import View.CategoryView;
import View.TransactionView;

public class AppFactory {
    public IAppFactory getApp(AppType appType) {
        DataService dataService = DataService.getInstance();

        if (appType == AppType.CATEGORY) {
            CategoryView categoryView = new CategoryView();
            return new CategoryController(dataService, categoryView);
        } else if (appType == AppType.BUDGET) {
            BudgetView budgetView = new BudgetView();
            return new BudgetController(dataService, budgetView);
        } else if (appType == AppType.TRANSACTION) {
            TransactionView transactionView = new TransactionView();
            return new TransactionController(dataService, transactionView);
        } else {
            return null;
        }
    }
}