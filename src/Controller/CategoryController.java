package Controller;

import Factory.IAppFactory;
import Model.Category;
import View.CategoryView;

import java.util.ArrayList;

public class CategoryController implements IAppFactory {
    private ArrayList<Category> categories;
    private CategoryView categoryView;

    public CategoryController(ArrayList<Category> categories, CategoryView categoryView) {
        this.categories = categories;
        this.categoryView = categoryView;
    }

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void create() {

    }

    @Override
    public void update(int id) {

    }

    @Override
    public Category getById(int id) {
        return null;
    }

    @Override
    public void getAll() {

    }

    @Override
    public void delete() {

    }
}
