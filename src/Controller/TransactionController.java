package Controller;

import Factory.IAppFactory;
import Model.Transaction;
import Service.DataService;
import View.TransactionView;

import java.util.ArrayList;
import java.util.UUID;

public class TransactionController implements IAppFactory {
    private final DataService dataService;
    private final TransactionView transactionView;

    public TransactionController(DataService dataService, TransactionView transactionView) {
        this.dataService = dataService;
        this.transactionView = transactionView;
    }

    @Override
    public int generateId() {
        UUID uuid = UUID.randomUUID();
        return Math.abs(uuid.hashCode());
    }

    @Override
    public void create() {
        Transaction transaction = this.transactionView.renderAndCreateTransaction(this.dataService);
        System.out.println(transaction.toString());
        this.dataService.setTransaction(transaction);
    }

    @Override
    public void update(int id) {
        Transaction transaction = this.transactionView.renderAndUpdateTransaction(this.dataService);
        this.dataService.updateTransactionById(transaction);
    }

    @Override
    public Transaction getById(int id) {
        return this.dataService.getTransactionById(id);
    }

    @Override
    public void getAll() {
        transactionView.renderAllTransactions(this.dataService.getTransactions());
    }

    @Override
    public void delete() {
        int transactionId = this.transactionView.renderAndDeleteTransaction();
        this.dataService.deleteTransaction(transactionId);
    }
}
