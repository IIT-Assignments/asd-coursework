package Entity;


public class Transaction {
    private int id;
    private Double amount;
    private String note;
    private Boolean isRecurring;
    private Category category;
    private String type;

    public Transaction() {
    }

    public Transaction(int id, Double amount, String note, Boolean isRecurring, Category category, String type ){
        this.id = id;
        this.amount = amount;
        this.note = note;
        this.isRecurring = isRecurring;
        this.category = category;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getRecurring() {
        return isRecurring;
    }

    public void setRecurring(Boolean recurring) {
        isRecurring = recurring;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
