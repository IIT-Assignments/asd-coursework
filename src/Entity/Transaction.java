package Entity;


public class Transaction implements IRender {
    private int id;
    private Double amount;
    private String note;
    private Boolean isRecurring;
    private Category category;
    private String type;

    private MainMenu mainMenu;

    public Transaction() {}

    public Transaction(int id, Double amount, String note, Boolean isRecurring, Category category, String type ){
        this.id = id;
        this.amount = amount;
        this.note = note;
        this.isRecurring = isRecurring;
        this.category = category;
        this.type = type;
    }

    @Override
    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    @Override
    public void renderMenu() {
        System.out.println("\n=== Transaction Menu ===");
        System.out.println("1. Income Transaction");
        System.out.println("2. Expense Transaction");
        System.out.println("3. Main Menu");
        System.out.print("Enter your choice: ");

        int option = this.mainMenu.getScanner().nextInt();
        this.mainMenu.getScanner().nextLine();

        switch (option) {
            case 1:
                this.renderCreateTransactionMenu(TransactionType.INCOME);
                break;
            case 2:
                this.renderCreateTransactionMenu(TransactionType.EXPENSE);
                break;
            case 3:
                this.mainMenu.renderMainMeu();
                break;
            default:
                break;
        }
    }

    private void renderCreateTransactionMenu(TransactionType transactionType) {

    }

//    private void renderAllTransactionsTable
}
