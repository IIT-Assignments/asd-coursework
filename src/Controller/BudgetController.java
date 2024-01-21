package Controller;

import Factory.IAppFactory;
import Model.Budget;
import java.util.ArrayList;

public class BudgetController implements IAppFactory {
    private ArrayList<Budget> budgets = new ArrayList<>();
    @Override
    public void create() {

    }

    @Override
    public void update() {

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

    }
}
