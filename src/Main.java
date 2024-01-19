import Entity.Budget;
import Entity.BudgetItem;
import Entity.Category;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Create a Scanner object to read input from the user
    static Scanner scanner = new Scanner(System.in);
    static List<Category> categories = new ArrayList<Category>();
    static List<Budget> budgets = new ArrayList<Budget>();
    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu(){
        // Prompt the user to enter the option
        System.out.println("\n###################################");
        System.out.println("#    Welcome to Expense Tracker   #");
        System.out.println("###################################\n");
        System.out.println("1. Category");
        System.out.println("2. Budget");
        System.out.println("3. Transactions");
        System.out.print("Enter your choice: ");

        // Read the option from the user
        int option = scanner.nextInt();
        // Consume the newline character
        scanner.nextLine();

        switch (option) {
            case 1:
                displayCategoryMenu();
                break;
            case 2:
                displayBudgetMenu();
                break;
            default:
                break;
        }

        scanner.close();
    }

    public static void displayCategoryMenu(){
        // Prompt the user to enter the option
        System.out.println("\n=== Category Menu ===");
        System.out.println("1. Create Category");
        System.out.println("2. View Categories");
        System.out.println("3. Main Menu");
        System.out.print("Enter your choice: ");

        int option = scanner.nextInt();
        // Consume the newline character
        scanner.nextLine();

        switch (option) {
            case 1:
                createCategory();
                break;
            case 2:
                categoryDisplay(true);
                break;
            case 3:
                displayMainMenu();
                break;
            default:
                break;
        }
    }

    private static void categoryDisplay(Boolean isRedirect){

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
        if(isRedirect == true){
            displayCategoryMenu();
        }
    }

    private static void createCategory() {
        // Prompt the user to enter the Category Name
        System.out.print("Enter the Category Name: ");

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

        displayCategoryMenu();
    }

    private static void displayBudgetMenu(){
        // Prompt the user to enter the option
        System.out.println("\n=== Budget Menu ===");
        System.out.println("1. Create Budget");
        System.out.println("2. View Budget");
        System.out.println("3. Main Menu");
        System.out.print("Enter your choice: ");

        int option = scanner.nextInt();
        // Consume the newline character
        scanner.nextLine();

        switch (option) {
            case 1:
                createBudget();
                break;
            case 2:
                budgetDisplay();
                break;
            case 3:
                displayMainMenu();
                break;
            default:
                break;
        }
    }

    private static void createBudget() {
        List<BudgetItem> budgetItems = new ArrayList<BudgetItem>();
        // Prompt the user to enter the Budget Name
        System.out.print("Enter the Budget Name: ");

        String name = "";
        if (scanner.hasNextLine()) {
            name = scanner.nextLine();
        } else {
            System.out.println("No input found. Exiting.");
            return;
        }

        categoryDisplay(false);
        String isProceed = "yes";
        while (isProceed.equals("yes")){
            String categoryName = "Other";

            System.out.print("Enter Category Name : ");
            if (scanner.hasNextLine()) {
                categoryName = scanner.nextLine();
            } else {
                System.out.println("No input found. Exiting.");
                return;
            }

            Category category = getCategoryByName(categoryName);
            System.out.print("Enter Amount : ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            BudgetItem budgetItem = new BudgetItem(generateId(), amount, category);
            budgetItems.add(budgetItem);

            System.out.print("Do you want to add another item (yes/no) :");
            isProceed = scanner.nextLine().trim();
        }

        Budget budget = new Budget(generateId(), name, budgetItems);
        budgets.add(budget);
        System.out.println("Budget " + name + " added to the System");
        displayBudgetMenu();
    }

    private static void budgetDisplay(){
        System.out.println("Budget Names :");
        for(Budget budget: budgets){
            System.out.println("# " + budget.getName());
        }

        System.out.print("\nEnter Budget Name to display : ");
        String budgetName = "";
        if (scanner.hasNextLine()) {
            budgetName = scanner.nextLine();
        } else {
            System.out.println("No input found. Exiting.");
            return;
        }

        Budget budget = getBudgetByName(budgetName.trim());
        System.out.println("\nBudget for " + budgetName + "\n");
        // Print the table header
        System.out.println("+-------------------------+-------------------------------+-----------------------------+");
        System.out.println("|  ID                     |       Category                |       Amount                |");
        System.out.println("+-------------------------+-------------------------------+-----------------------------+");

        double total = 0.00;

        if(budget != null){
            // Print each row of the table
            for (BudgetItem budgetItem : budget.getBudgetItems()) {
                total += budgetItem.getAmount();
                System.out.printf("| %-23d | %-29s | %-27s |\n", budgetItem.getId(), budgetItem.getCategory().getName(), budgetItem.getAmount());
            }
        }

        System.out.println("+-------------------------+-------------------------------+-----------------------------+");
        System.out.printf("| %-23s | %-29s | %-27s |\n","","Total",total);
        // Print the table footer
        System.out.println("+-------------------------+-------------------------------+-----------------------------+");

        displayBudgetMenu();
    }

    private static Category getCategoryByName(String filterName){
        for(Category categoryItem: categories){
            if(categoryItem.getName().equals(filterName)){
                return categoryItem;
            }
        }
        return null;
    }

    private static Budget getBudgetByName(String filterName){
        for(Budget budgetItem: budgets){
            if(budgetItem.getName().equals(filterName)){
                return budgetItem;
            }
        }
        return null;
    }

    private static int generateId(){
        // Create a UUID
        UUID uuid = UUID.randomUUID();

        // Convert UUID to int using hashCode and make it positive
        int uuidAsInt = Math.abs(uuid.hashCode());

        return uuidAsInt;
    }
}
