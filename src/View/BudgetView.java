package View;

import Model.Budget;
import Model.BudgetItem;
import Model.Category;
import Model.Transaction;

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
            return new Budget(name, budgetItems);
        }
        else
        {
            return null;
        }


    }
}
