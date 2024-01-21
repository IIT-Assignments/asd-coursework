package Entity;

import java.util.Scanner;
import java.util.UUID;

public class MainMenu {
    private final Scanner scanner;
    private Transaction transaction;
    private Category category;
    private Budget budget;

    public MainMenu() {
        this.scanner = new Scanner(System.in);
    }

    public Scanner getScanner() {
        return this.scanner;
    }

    public void renderMainMeu() {
        // Prompt the user to enter the option
        System.out.println("\n###################################");
        System.out.println("#    Welcome to Expense Tracker   #");
        System.out.println("###################################\n");
        System.out.println("1. Category");
        System.out.println("2. Budget");
        System.out.println("3. Transactions");
        System.out.print("Enter your choice: ");

        // Read the option from the user
        int option = this.scanner.nextInt();
        // Consume the newline character
        scanner.nextLine();

        switch (option) {
            case 1:
                this.handleCategory();
                break;
            case 2:
                this.budget.renderMenu();
                break;
            case 3:
                this.transaction.renderMenu();
                break;
            default:
                break;
        }

        scanner.close();
    }

    private void handleCategory() {
        this.category = new Category();
        this.category.setMainMenu(this);
        this.category.renderMenu();
    }

    private void handleBudget() {
        this.budget = new Budget(this.category);
    }

    protected int generateId(){
        // Create a UUID
        UUID uuid = UUID.randomUUID();

        // Convert UUID to int using hashCode and make it positive
        int uuidAsInt = Math.abs(uuid.hashCode());

        return uuidAsInt;
    }
}
