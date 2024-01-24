package Service;

import Model.Budget;
import Model.Category;
import Model.Transaction;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataService {
    private static final Logger LOGGER = Logger.getLogger(DataService.class.getName());
    private static DataService dataService;
    private static ArrayList<Category> categories;
    private static ArrayList<Transaction> transactions;
    private static ArrayList<Budget> budgets;

    private DataService(ArrayList<Category> categories, ArrayList<Transaction> transactions, ArrayList<Budget> budgets) {
        DataService.categories = categories;
        DataService.transactions = transactions;
        DataService.budgets = budgets;
    }

    public static DataService getInstance() {
        if (dataService == null) {
            categories = new ArrayList<>();
            transactions = new ArrayList<>();
            budgets = new ArrayList<>();

            dataService = new DataService(categories, transactions, budgets);
        }

        return dataService;
    }

    public void setCategory(Category category) {
        categories.add(category);
        this.saveCategoriesToFile();
    }

    public void setTransaction(Transaction transaction) {
        transactions.add(transaction);
        this.saveTransactionsToFile();
    }

    public void setBudget(Budget budget) {
        budgets.add(budget);
    }

    public Category getCategoryById(int id) {
        for(Category category: categories){
            if(category.getId() == id){
                return category;
            }
        }

        return null;
    }

    public Transaction getTransactionById(int id) {
        for(Transaction transaction: transactions){
            if(transaction.getId() == id){
                return transaction;
            }
        }
        return null;
    }

    public Budget getBudgetById(int id) {
        for(Budget budget: budgets){
            if(budget.getId() == id){
                return budget;
            }
        }
        return null;
    }

    public void updateCategoryById(Category category) {
        for (int i = 0; i < categories.size(); i++) {
            Category category1 = categories.get(i);

            if (category1.getId() == category.getId()) {
                categories.set(i, category);
                break;
            }
        }
    }

    public void updateTransactionById(Transaction transaction) {
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction1 = transactions.get(i);

            if (transaction1.getId() == transaction.getId()) {
                transactions.set(i, transaction);
                break;
            }
        }
    }

    public void updateBudgetById(Budget budget) {
        for (int i = 0; i < budgets.size(); i++) {
            Budget budget1 = budgets.get(i);

            if (budget1.getId() == budget.getId()) {
                budgets.set(i, budget);
                break;
            }
        }
    }

    public void deleteCategory(int id) {
        categories.remove(id);
    }

    public void deleteTransaction(int id) {
        transactions.remove(id);
    }

    public void deleteBudget(int id) {
        budgets.remove(id);
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public ArrayList<Budget> getBudgets() {
        return budgets;
    }

    private void saveCategoriesToFile() {
        Gson gson = new Gson();
        try {
            FileWriter fileWriter = new FileWriter("categories.json");
            gson.toJson(categories, fileWriter);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error occurred while reading the file", e);
        }
    }

    private void saveTransactionsToFile() {
        Gson gson = new Gson();
        try {
            FileWriter fileWriter = new FileWriter("transactions.json");
            gson.toJson(transactions, fileWriter);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error occurred while reading the file", e);
        }
    }

    private void loadDataToArrayLists() {
        Gson gson = new Gson();
        try {
            FileReader categoryFileReader = new FileReader("categories.json");
            Type categoryList = new TypeToken<ArrayList<Category>>(){}.getType();
            categories = gson.fromJson(categoryFileReader, categoryList);

            FileReader transactionFileReader = new FileReader("transactions.json");
            Type transactionList = new TypeToken<ArrayList<Transaction>>(){}.getType();
            transactions = gson.fromJson(transactionFileReader, transactionList);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error occurred while reading the file", e);
        }
    }
}
