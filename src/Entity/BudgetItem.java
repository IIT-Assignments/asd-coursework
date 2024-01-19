package Entity;

public class BudgetItem {
    
    private int itemID;
    private double amount;
    Category category;

    public BudgetItem(){

    }
    
    public BudgetItem(int itemID, double amount, Category category) {
        this.itemID = itemID;
        this.amount = amount;
        this.category = category;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
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
        System.out.println("Item ID : " + itemID);
        System.out.println("Item Name : " + amount);
        System.out.println("Category : " + category);

    }

}
