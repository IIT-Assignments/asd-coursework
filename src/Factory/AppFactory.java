package Factory;

import Controller.CategoryController;
import Model.Category;
import View.CategoryView;

import java.util.ArrayList;

public class AppFactory {
    CategoryController categoryController;
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

        } else {
            return null;
        }

        return null;
    }
}
