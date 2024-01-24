package Controller;

import Factory.IAppFactory;
import Model.Budget;
import Model.Category;
import Model.Transaction;
import Service.DataService;
import View.BudgetView;
import View.CategoryView;
import View.TransactionView;

import java.util.ArrayList;
import java.util.UUID;

public class BudgetController implements IAppFactory {
    private DataService dataService;
    private BudgetView budgetView;

    public BudgetController(DataService dataService, BudgetView budgetView) {
        this.dataService = dataService;
        this.budgetView = budgetView;
    }
    @Override
    public int generateId() {
        UUID uuid = UUID.randomUUID();
        return Math.abs(uuid.hashCode());
    }

    @Override
    public void create() {
        Budget budget = this.budgetView.renderAndCreateBudget(this.dataService.getCategories());
        this.dataService.setBudget(budget);
    }

    @Override
    public void update(int id) {
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public Object[] getAll() {
        return new Object[0];
    }

    @Override
    public void delete() {
        int id = budgetView.renderAndDeleteBudget();

        this.dataService.deleteBudget(id);
    }
}
