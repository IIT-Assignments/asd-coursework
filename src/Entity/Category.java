package Entity;

import java.util.ArrayList;
import java.util.List;

public class Category implements IRender {
    private int id;
    private String name;

    private final List<Category> categories = new ArrayList<Category>();

    private MainMenu mainMenu;

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name='" + name + '\'';
    }

    @Override
    public void renderMenu() {
        // Prompt the user to enter the option
        System.out.println("\n=== Category Menu ===");
        System.out.println("1. Create Category");
        System.out.println("2. View Categories");
        System.out.println("3. Main Menu");
        System.out.print("Enter your choice: ");

        int option = this.mainMenu.getScanner().nextInt();
        // Consume the newline character
        this.mainMenu.getScanner().nextLine();

        switch (option) {
            case 1:
                createCategory();
                break;
            case 2:
                categoryDisplay(true);
                break;
            case 3:
                this.mainMenu.renderMainMeu();
                break;
            default:
                break;
        }
    }

    private void createCategory() {
        // Prompt the user to enter the Category Name
        System.out.print("Enter the Category Name: ");

        String name = "";
        // Read the Category Name from the user
        if (this.mainMenu.getScanner().hasNextLine()) {
            // Read the Category Name from the user
            name = this.mainMenu.getScanner().nextLine();
        } else {
            System.out.println("No input found. Exiting.");
            return;
        }

        // Create a Category object with the provided name
        Category category = new Category(this.mainMenu.generateId(), name);

        categories.add(category);

        // Print the Category object (assuming Category has a proper toString method)
        System.out.println(name + " added to category list");

        this.mainMenu.renderMainMeu();
    }

    public void categoryDisplay(Boolean isRedirect) {
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
        if(isRedirect){
            this.mainMenu.renderMainMeu();
        }
    }

    public Category getCategoryByName(String filterName){
        for(Category categoryItem: categories){
            if(categoryItem.getName().equals(filterName)){
                return categoryItem;
            }
        }
        return null;
    }
}
