package Controller;

import Factory.IAppFactory;
import Model.Transaction;
import View.TransactionView;

import java.util.ArrayList;
import java.util.UUID;

public class TransactionController implements IAppFactory {
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private TransactionView transactionView = new TransactionView();

    public TransactionController(ArrayList<Transaction> transactions, TransactionView transactionView) {
        this.transactions = transactions;
        this.transactionView = transactionView;
    }

    @Override
    public int generateId() {
        // Create a UUID
        UUID uuid = UUID.randomUUID();
        // Convert UUID to int using hashCode and make it positive
        return Math.abs(uuid.hashCode());
    }

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
