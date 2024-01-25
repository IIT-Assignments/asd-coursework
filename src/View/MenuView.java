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
        System.out.println("3. Main Menu");
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
        System.out.println("3. Main Menu");
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
        System.out.println("3. Main Menu");
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
