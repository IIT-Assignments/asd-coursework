package Controller;

import Factory.IAppFactory;
import Model.Category;
import View.CategoryView;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class CategoryController implements IAppFactory {
    private ArrayList<Category> categories;
    private CategoryView categoryView;
    static Scanner scanner;
    public CategoryController(ArrayList<Category> categories, CategoryView categoryView) {
        this.categories = categories;
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
       category.setId(generateId());
       categories.add(category);
    }

    @Override
    public void update(int id) {

    }

    @Override
    public void getById(int id) {
        for(Category category: categories){
            if(category.getId() == id){
                categoryView.displayCategoryById(category.getId(),category.getName());
            }
        }

    }

    @Override
    public void getAll() {

    }

    @Override
    public void delete() {

    }
}
