package View;

import Factory.AppFactory;
import Factory.AppType;
import Factory.IAppFactory;

import java.util.Scanner;

public class MenuView {
    static AppFactory appFactory = new AppFactory();
    static IAppFactory transactionController = appFactory.getApp(AppType.TRANSACTION);
    static IAppFactory categoryController = appFactory.getApp(AppType.CATEGORY);
    static IAppFactory budgetController = appFactory.getApp(AppType.BUDGET);
    private static Scanner scanner = new Scanner(System.in);

    public static void displayCategoryMenu(){
        // Prompt the user to enter the option
        System.out.println("\n=== Category Menu ===");
        System.out.println("1. Create Category");
        System.out.println("2. View Categories");
        System.out.println("3. Update Category");
        System.out.println("4. Delete Category");
        System.out.println("5. Main Menu");
        System.out.print("Enter your choice: ");

        int option = scanner.nextInt();
        // Consume the newline character
        scanner.nextLine();

        switch (option) {
            case 1:
                categoryController.create();
                displayCategoryMenu();
                break;
            case 2:
                categoryController.getAll();
                displayCategoryMenu();
                break;
            case 3:
                System.out.print("Enter Category Id for edit : ");
                int id = scanner.nextInt();
                scanner.nextLine();
                categoryController.update(id);
                displayCategoryMenu();
                break;
            case 4:
                categoryController.delete();
                displayCategoryMenu();
                break;
            case 5:
                displayMainMenu();
                break;
            default:
                break;
        }
    }
    private static void displayBudgetMenu(){
        // Prompt the user to enter the option
        System.out.println("\n=== Budget Menu ===");
        System.out.println("1. Create Budget");
        System.out.println("2. View Budget");
        System.out.println("3. Update Budget");
        System.out.println("4. Delete Budget");
        System.out.println("5. Main Menu");
        System.out.print("Enter your choice: ");

        int option = scanner.nextInt();
        // Consume the newline character
        scanner.nextLine();

        switch (option) {
            case 1:
                budgetController.create();
                displayBudgetMenu();
                break;
            case 2:
                budgetController.getAll();
                displayBudgetMenu();
                break;
            case 3:
                System.out.print("Enter Budget id for edit : ");
                int id = scanner.nextInt();
                scanner.nextLine();
                budgetController.update(id);
                displayBudgetMenu();
                break;
            case 4:
                budgetController.delete();
                displayBudgetMenu();
                break;
            case 5:
                displayMainMenu();
                break;
            default:
                break;
        }
    }
    private static void displayTransactionMenu(){
        // Prompt the user to enter the option
        System.out.println("\n=== Transaction Menu ===");
        System.out.println("1. Create Transaction");
        System.out.println("2. View Transaction");
        System.out.println("3. Update Transaction");
        System.out.println("4. Delete Transaction");
        System.out.println("5. Main Menu");
        System.out.print("Enter your choice: ");

        int option = scanner.nextInt();
        // Consume the newline character
        scanner.nextLine();

        switch (option) {
            case 1:
                transactionController.create();
                displayTransactionMenu();
                break;
            case 2:
                transactionController.getAll();
                displayTransactionMenu();
                break;
            case 3:
                System.out.print("Enter id for update transaction : ");
                int id = scanner.nextInt();
                scanner.nextLine();
                transactionController.update(id);
                displayTransactionMenu();
                break;
            case 4:
                transactionController.delete();
                displayTransactionMenu();
                break;
            case 5:
                displayMainMenu();
                break;
            default:
                break;
        }
    }
    public static void displayMainMenu(){
        // Prompt the user to enter the option
        System.out.println("\n###################################");
        System.out.println("#    Welcome to Expense Tracker   #");
        System.out.println("###################################\n");
        System.out.println("1. Category");
        System.out.println("2. Budget");
        System.out.println("3. Transactions");
        System.out.println("4. Exit");
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
            case 3:
                displayTransactionMenu();
                break;
            default:
                break;
        }

    }
}
