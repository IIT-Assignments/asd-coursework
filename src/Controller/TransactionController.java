package Controller;

import Factory.IAppFactory;
import Model.Transaction;
import View.TransactionView;

import java.util.ArrayList;
import java.util.UUID;

public class TransactionController implements IAppFactory {
    private final ArrayList<Transaction> transactions;
    private final TransactionView transactionView;

    public TransactionController(ArrayList<Transaction> transactions, TransactionView transactionView) {
        this.transactions = transactions;
        this.transactionView = transactionView;
    }

    @Override
    public int generateId() {
        UUID uuid = UUID.randomUUID();
        return Math.abs(uuid.hashCode());
    }

    @Override
    public void create() {
        Transaction transaction = this.transactionView.renderAndCreateTransaction();
        transaction.setId(this.generateId());
        transactions.add(transaction);
    }

    @Override
    public void update(int id) {
        Transaction transaction = this.transactionView.renderAndUpdateTransaction();

        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction1 = transactions.get(i);

            if (transaction1.getId() == id) {
                transactions.set(i, transaction);
                break;
            }
        }
    }

    @Override
    public Transaction getById(int id) {
        return transactions.get(id);
    }

    @Override
    public void getAll() {
        transactionView.renderAllTransactions(transactions);
    }

    @Override
    public void delete() {
        int transactionId = this.transactionView.renderAndDeleteTransaction();
        transactions.remove(transactionId);
    }
}
