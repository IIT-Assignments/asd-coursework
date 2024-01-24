package View;

import Model.Category;
import Model.Transaction;

import java.util.ArrayList;
import java.util.Scanner;

public class TransactionView {
    public  TransactionView() {}

    private final Scanner scanner = new Scanner(System.in);
    public Transaction renderAndCreateTransaction(ArrayList<Category> categories) {
        return renderTransactionView(categories);
    }

    public Transaction renderAndUpdateTransaction(ArrayList<Category> categories) {
        return renderTransactionView(categories);
    }

    public void renderAllTransactions(ArrayList<Transaction> transactions) {
        System.out.println("+-------------------------+---------------------------+-----------------------------+-------------------------+-------------------------+------------------------------*");
        System.out.println("|  ID                     |       Amount              |  Category                   |       Type              |       Note              |       Recurring              |");
        System.out.println("+-------------------------+---------------------------+-----------------------------+-------------------------+-------------------------+------------------------------*");

        for (Transaction transaction : transactions) {
            System.out.printf("| %-23d | %-25s | %-25s | %-25s | %-25s | %-25s\n",
                    transaction.getId(),
                    transaction.getAmount(),
                    transaction.getCategory().getName(),
                    transaction.getType(),
                    transaction.getNote(),
                    transaction.getRecurring()
            );
        }

        System.out.println("+-------------------------+---------------------------+-----------------------------+-------------------------+-------------------------+------------------------------*");
    }

    public int renderAndDeleteTransaction() {
        int transactionId;
        System.out.println("Enter category id: ");
        transactionId = scanner.nextInt();
        scanner.nextLine();

        return transactionId;
    }

    private Transaction renderTransactionView(ArrayList<Category> categories) {
        double amount;
        String note;
        String recurringStatus;
        int categoryId;
        String type;

        System.out.println("Enter category id: ");
        categoryId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter transaction amount: ");
        amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter transaction type: ");
        type = scanner.nextLine();

        System.out.println("Enter a note: ");
        note = scanner.nextLine();

        System.out.println("Is the transaction recurring (y/n): ");
        recurringStatus = scanner.nextLine();

        if (amount != 0 && note != null && recurringStatus != null && categoryId != 0 && type != null) {
            boolean isRecurring;

            isRecurring = recurringStatus.equalsIgnoreCase("y");

            Category category = categories.get(categoryId);
            return new Transaction(amount, note, isRecurring, category, type);
        } else {
            return null;
        }
    }
}
