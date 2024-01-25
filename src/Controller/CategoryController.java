package Controller;

import Factory.IAppFactory;
import Model.Category;
import Model.Transaction;
import Service.DataService;
import View.CategoryView;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class CategoryController implements IAppFactory {
    private DataService dataService;
    private CategoryView categoryView;
    static Scanner scanner;
    public CategoryController(DataService dataService, CategoryView categoryView) {
        this.dataService = dataService;
        this.categoryView = categoryView;
    }

    @Override
    public int generateId() {
        // Create a UUID
        UUID uuid = UUID.randomUUID();
        // Convert UUID to int using hashCode and make it positive
        return Math.abs(uuid.hashCode());
    }

    @Override
    public void create() {
       Category category =  categoryView.createCategory();
       this.dataService.setCategory(category);
    }

    @Override
    public void update(int id) {
        Category category = this.categoryView.renderAndUpdateCategory();
        this.dataService.updateCategoryById(category);
    }

    @Override
    public Category getById(int id) {
        return this.dataService.getCategoryById(id);
    }

    @Override
    public void getAll() {
        categoryView.displayCategories(this.dataService.getCategories());
    }

    @Override
    public void delete() {
        int id = categoryView.deleteCategory();

        this.dataService.deleteCategory(id);
    }
}
