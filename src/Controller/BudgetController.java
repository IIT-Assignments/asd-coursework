package Controller;

import Factory.IAppFactory;
import Model.Budget;
import java.util.ArrayList;

public class BudgetController implements IAppFactory {
    private ArrayList<Budget> budgets = new ArrayList<>();

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void create() {

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
    public void delete(int id) {

    }
}
