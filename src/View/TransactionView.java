package View;

import Mediator.IControllerMediator;
import Model.Category;
import Model.Transaction;

import java.util.Scanner;

public class TransactionView {
    private final IControllerMediator mediator;

    public  TransactionView(IControllerMediator mediator) {
        this.mediator = mediator;
    }

    private final Scanner scanner = new Scanner(System.in);
    public Transaction renderAndCreateTransaction() {
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

            if (recurringStatus.equalsIgnoreCase("y")) {
                isRecurring = true;
            } else {
                isRecurring = false;
            }

            Category category = this.mediator.getCategoryById(categoryId);
            return new Transaction(amount, note, isRecurring, category, type);
        } else {
            return null;
        }
    }
}
