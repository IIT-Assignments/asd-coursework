package Controller;

import Factory.IAppFactory;
import Model.Category;
import View.CategoryView;

import java.util.ArrayList;
import java.util.Scanner;

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
        return 0;
    }

    @Override
    public void create() {
        // Prompt the user to enter the Category Name
        System.out.print("\nEnter the Category Name: ");

        String name = "";
        // Read the Category Name from the user
        if (scanner.hasNextLine()) {
            // Read the Category Name from the user
            name = scanner.nextLine();
        } else {
            System.out.println("No input found. Exiting.");
            return;
        }

        // Create a Category object with the provided name
        Category category = new Category(generateId(), name);

        categories.add(category);

        // Print the Category object (assuming Category has a proper toString method)
        System.out.println(name + " added to category list");
    }

    @Override
    public void update(int id) {

    }

    @Override
    public Category getById(int id) {
        return null;
    }

    @Override
    public Object[] getAll() {
        return new Object[0];
    }

    @Override
    public void delete(int id) {

    }
}
