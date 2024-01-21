package Controller;

import Factory.IAppFactory;
import Model.Transaction;

import java.util.ArrayList;

public class TransactionController implements IAppFactory {
    private ArrayList<Transaction> transactions = new ArrayList<>();
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
