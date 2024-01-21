package View;

import Model.Category;

import java.util.ArrayList;
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

    public void displayCategories(ArrayList<Category> categories) {
        // Print the table header
        System.out.println("+-------------------------+---------------------------+");
        System.out.println("|  ID                     |       Name                |");
        System.out.println("+-------------------------+---------------------------+");

        // Print each row of the table
        for (Category category : categories) {
            System.out.printf("| %-23d | %-25s |\n", category.getId(), category.getName());
        }

        // Print the table footer
        System.out.println("+-------------------------+---------------------------+");
    }

    public int deleteCategory() {
        System.out.print("\nEnter the Category Id for delete: ");

        int id = 0;
        if (scanner.hasNextLine()) {
            id = scanner.nextInt();
            scanner.nextLine();
        }

        return id;
    }
}
