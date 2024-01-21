package Model;

public class BudgetItem {

    private int id;
    private double amount;
    Category category;

    public BudgetItem(){

    }

    public BudgetItem(double amount, Category category) {
        this.amount = amount;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", budget category='" + category +
                '}';
    }
}
