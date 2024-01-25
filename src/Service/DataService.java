package Service;

import Model.Budget;
import Model.Category;
import Model.Transaction;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataService {
    private static final Logger LOGGER = Logger.getLogger(DataService.class.getName());
    private static final DataService dataService = new DataService();
    private ArrayList<Category> categories = new ArrayList<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private ArrayList<Budget> budgets = new ArrayList<>();

    private DataService() {
        this.loadDataToArrayLists();
    }

    public static DataService getInstance() {
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
        this.saveBudgetsToFile();
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
                this.saveCategoriesToFile();
                break;
            }
        }
    }

    public void updateTransactionById(Transaction transaction) {
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction1 = transactions.get(i);

            if (transaction1.getId() == transaction.getId()) {
                transactions.set(i, transaction);
                this.saveTransactionsToFile();
                break;
            }
        }
    }

    public void updateBudgetById(Budget budget) {
        for (int i = 0; i < budgets.size(); i++) {
            Budget budget1 = budgets.get(i);

            if (budget1.getId() == budget.getId()) {
                budgets.set(i, budget);
                this.saveBudgetsToFile();
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
            System.out.println("Category Added");
            gson.toJson(categories, fileWriter);
            fileWriter.flush();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error occurred while reading the file", e);
        }
    }

    private void saveTransactionsToFile() {
        Gson gson = new Gson();
        try {
            FileWriter fileWriter = new FileWriter("transactions.json");
            gson.toJson(transactions, fileWriter);
            fileWriter.flush();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error occurred while reading the file", e);
        }
    }

    private void saveBudgetsToFile() {
        Gson gson = new Gson();
        try {
            FileWriter fileWriter = new FileWriter("budgets.json");
            gson.toJson(budgets, fileWriter);
            fileWriter.flush();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error occurred while reading the file", e);
        }
    }

    private void loadDataToArrayLists() {
        System.out.println("called");
        Gson gson = new Gson();
        try {
            File categoryFile = new File("categories.json");
            File transactionFile = new File("transactions.json");
            File budgetFile = new File("budgets.json");

            if (categoryFile.exists()) {
                FileReader categoryFileReader = new FileReader(categoryFile);
                Type categoryList = new TypeToken<ArrayList<Category>>(){}.getType();
                categories = gson.fromJson(categoryFileReader, categoryList);
            } else {
                categories = new ArrayList<>();
            }

            if (transactionFile.exists()) {
                FileReader transactionFileReader = new FileReader(transactionFile);
                Type transactionList = new TypeToken<ArrayList<Transaction>>(){}.getType();
                transactions = gson.fromJson(transactionFileReader, transactionList);
            } else {
                transactions = new ArrayList<>();
            }

            if (budgetFile.exists()) {
                FileReader budgetFileReader = new FileReader(budgetFile);
                Type budgetList = new TypeToken<ArrayList<Transaction>>(){}.getType();
                budgets = gson.fromJson(budgetFileReader, budgetList);
            } else {
                budgets = new ArrayList<>();
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error occurred while reading the file", e);
        }
    }
}
