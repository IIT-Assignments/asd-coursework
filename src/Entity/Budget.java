package Entity;

import java.util.ArrayList;
import java.util.List;

public class Budget implements IRender {
    private int id;
    private String name;
    private List<BudgetItem> budgetItems;

    private final List<Budget> budgets = new ArrayList<Budget>();

    private MainMenu mainMenu;

    private Category category;

    public Budget(Category category) {
        this.category = category;
    }

    public Budget(int id, String name, List<BudgetItem> budgetItems) {
        this.id = id;
        this.name = name;
        this.budgetItems = budgetItems;
    }

    @Override
    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public void setCategory(Category category) { this.category = category; };

    public String getName() {
        return name;
    }

    public List<BudgetItem> getBudgetItems() {
        return budgetItems;
    }

    @Override
    public void renderMenu() {
        // Prompt the user to enter the option
        System.out.println("\n=== Budget Menu ===");
        System.out.println("1. Create Budget");
        System.out.println("2. View Budget");
        System.out.println("3. Main Menu");
        System.out.print("Enter your choice: ");

        int option = this.mainMenu.getScanner().nextInt();
        // Consume the newline character
        this.mainMenu.getScanner().nextLine();

        switch (option) {
            case 1:
                createBudget();
                break;
            case 2:
                budgetDisplay();
                break;
            case 3:
                this.mainMenu.renderMainMeu();
                break;
            default:
                break;
        }
    }

    private void createBudget() {
        List<BudgetItem> budgetItems = new ArrayList<BudgetItem>();
        // Prompt the user to enter the Budget Name
        System.out.print("Enter the Budget Name: ");

        String name = "";
        if (this.mainMenu.getScanner().hasNextLine()) {
            name = this.mainMenu.getScanner().nextLine();
        } else {
            System.out.println("No input found. Exiting.");
            return;
        }

        this.category.categoryDisplay(false);

        String isProceed = "yes";
        while (isProceed.equals("yes")){
            String categoryName = "Other";

            System.out.print("Enter Category Name : ");
            if (this.mainMenu.getScanner().hasNextLine()) {
                categoryName = this.mainMenu.getScanner().nextLine();
            } else {
                System.out.println("No input found. Exiting.");
                return;
            }

            Category category = this.category.getCategoryByName(categoryName);
            System.out.print("Enter Amount : ");
            double amount = this.mainMenu.getScanner().nextDouble();
            this.mainMenu.getScanner().nextLine();

            BudgetItem budgetItem = new BudgetItem(mainMenu.generateId(), amount, category);
            budgetItems.add(budgetItem);

            System.out.print("Do you want to add another item (yes/no) :");
            isProceed = this.mainMenu.getScanner().nextLine().trim();
        }

        Budget budget = new Budget(mainMenu.generateId(), name, budgetItems);
        budgets.add(budget);
        System.out.println("Budget " + name + " added to the System");
        this.mainMenu.renderMainMeu();
    }

    private void budgetDisplay() {
        System.out.println("Budget Names :");
        for(Budget budget: budgets){
            System.out.println("# " + budget.getName());
        }

        System.out.print("\nEnter Budget Name to display : ");
        String budgetName = "";
        if (this.mainMenu.getScanner().hasNextLine()) {
            budgetName = this.mainMenu.getScanner().nextLine();
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

        this.mainMenu.renderMainMeu();
    }

    private Budget getBudgetByName(String filterName){
        for(Budget budgetItem: budgets){
            if(budgetItem.getName().equals(filterName)){
                return budgetItem;
            }
        }
        return null;
    }
}
