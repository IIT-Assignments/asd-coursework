package Model;

import Entity.BudgetItem;

import java.util.List;

public class Budget {
    private int id;
    private String name;
    private List<BudgetItem> budgetItems;

    public Budget() {
    }

    public Budget(int id, String name, List<BudgetItem> budgetItems) {
        this.id = id;
        this.name = name;
        this.budgetItems = budgetItems;
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

    public List<BudgetItem> getBudgetItems() {
        return budgetItems;
    }

    public void setBudgetItems(List<BudgetItem> budgetItems) {
        this.budgetItems = budgetItems;
    }
}