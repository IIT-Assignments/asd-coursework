package Controller;

import Factory.IAppFactory;
import Model.Category;
import Model.Transaction;
import View.TransactionView;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class TransactionController implements IAppFactory {
    private ArrayList<Transaction> transactions;
    private TransactionView transactionView;

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
        Transaction transaction = this.transactionView.renderAndCreateTransaction();
        transaction.setId(this.generateId());
        transactions.add(transaction);

        for (Transaction transaction1: transactions) {
            System.out.println(transaction1.toString());
        }
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
