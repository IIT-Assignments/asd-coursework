package Controller;

import Factory.IAppFactory;
import Model.Budget;
import View.BudgetView;

import java.util.ArrayList;
import java.util.UUID;

public class BudgetController implements IAppFactory {
    private ArrayList<Budget> budgets;
    private BudgetView budgetView;

    public BudgetController(ArrayList<Budget> budgets, BudgetView budgetView) {
        this.budgets = budgets;
        this.budgetView = budgetView;
    }
    @Override
    public int generateId() {
        UUID uuid = UUID.randomUUID();
        return Math.abs(uuid.hashCode());
    }

    @Override
    public void create() {
        Budget budget = this.budgetView.renderAndCreateBudget();
        budget.setId(this.generateId());
        budgets.add(budget);
    }

    @Override
    public void update(int id) {

    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public void getAll() {

    }

    @Override
    public void delete() {

    }
}
