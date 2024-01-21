package View;

import Mediator.IControllerMediator;
import Model.Budget;
import Model.BudgetItem;
import Model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BudgetView {

    private final IControllerMediator mediator;

    public  BudgetView(IControllerMediator mediator) {
        this.mediator = mediator;
    }
    private final Scanner scanner = new Scanner(System.in);
    public Budget renderAndCreateBudget() {
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

            Category category = this.mediator.getCategoryById(categoryId);
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
