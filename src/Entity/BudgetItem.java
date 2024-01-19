package Entity;

public class BudgetItem {
    
    private int id;
    private double amount;
    Category category;

    public BudgetItem(){

    }
    
    public BudgetItem(int id, double amount, Category category) {
        this.id = id;
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

    public void getBudgetItem(){
        System.out.println("Item ID : " + id);
        System.out.println("Item Name : " + amount);
        System.out.println("Category : " + category);

    }
}
