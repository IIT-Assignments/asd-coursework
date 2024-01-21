package View;

import Model.Category;

import java.util.Scanner;

public class CategoryView {
    private
    static Scanner scanner = new Scanner(System.in);

    public Category createCategory() {
        // Prompt the user to enter the Category Name
        System.out.print("\nEnter the Category Name: ");

        String name = "";
        // Read the Category Name from the user
        if (scanner.hasNextLine()) {
            // Read the Category Name from the user
            name = scanner.nextLine();
        }

        // Create a Category object with the provided name
        Category category = new Category();
        category.setName(name);
        return category;
    }

    public void displayCategoryById(int id,String name) {
        System.out.print("id : " + id + "name : " + name);
    }
}
