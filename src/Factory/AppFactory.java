package Factory;

import Controller.CategoryController;
import Controller.TransactionController;
import Mediator.ControllerMediator;
import Model.Category;
import Model.Transaction;
import View.CategoryView;
import View.TransactionView;

import java.util.ArrayList;

public class AppFactory {
    CategoryController categoryController;
    TransactionController transactionController;
    public IAppFactory getApp(AppType appType) {
        if (appType == AppType.CATEGORY) {
            if (categoryController != null) {
                return categoryController;
            } else {
                ArrayList<Category> categories = new ArrayList<>();
                CategoryView categoryView = new CategoryView();
                return new CategoryController(categories, categoryView);
            }
        } else if (appType == AppType.BUDGET) {

        } else if (appType == AppType.TRANSACTION) {
            if (transactionController != null) {
                return this.transactionController;
            } else {
                if (categoryController != null) {
                    ControllerMediator mediator = new ControllerMediator(this.categoryController);
                    ArrayList<Transaction> transactions = new ArrayList<>();
                    TransactionView transactionView = new TransactionView(mediator);
                    this.transactionController = new TransactionController(transactions, transactionView);
                    return this.transactionController;
                } else {
                    ArrayList<Category> categories = new ArrayList<>();
                    CategoryView categoryView = new CategoryView();
                    this.categoryController = new CategoryController(categories, categoryView);

                    ControllerMediator mediator = new ControllerMediator(this.categoryController);
                    ArrayList<Transaction> transactions = new ArrayList<>();
                    TransactionView transactionView = new TransactionView(mediator);
                    this.transactionController = new TransactionController(transactions, transactionView);
                    return this.transactionController;
                }
            }
        } else {
            return null;
        }

        return null;
    }
}
