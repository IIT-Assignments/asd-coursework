package View;

import Model.Budget;
import Model.BudgetItem;
import Model.Category;
import Model.Transaction;
import Service.DataService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BudgetView {

    public  BudgetView() {}
    private final Scanner scanner = new Scanner(System.in);
    public Budget renderAndCreateBudget(ArrayList<Category> categories) {
        int id;
        String name;
        List<BudgetItem> budgetItems = new ArrayList<>();
        double amount;
        int categoryId;

        System.out.println("Enter a Budget Id: ");
        id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter a Budget name: ");
        name = scanner.nextLine();
;
        String isProceed = "yes";
        while (isProceed.equals("yes")){

            System.out.println("Enter category id: ");
            categoryId = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter transaction amount: ");
            amount = scanner.nextDouble();
            scanner.nextLine();

            Category category = categories.get(categoryId);
            BudgetItem budgetItem = new BudgetItem(amount,category);
            budgetItems.add(budgetItem);


            System.out.print("Do you want to add another item (yes/no) :");
            isProceed = scanner.nextLine().trim();
        }
        if (!name.isEmpty() && !budgetItems.isEmpty())
        {
            return new Budget(id, name, budgetItems);
        }
        else
        {
            return null;
        }


    }

    public int renderAndDeleteBudget() {
        int budgetId;
        System.out.println("Enter budget id: ");
        budgetId = scanner.nextInt();
        scanner.nextLine();

        return budgetId;
    }

    public void renderBudgetById(DataService dataService) {

        System.out.print("Enter Budget Id : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Budget budget =  dataService.getBudgetById(id);

        System.out.println("\nBudget for " + budget.getName() + "\n");
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
    }
}
