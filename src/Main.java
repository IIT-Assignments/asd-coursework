import Entity.Budget;
import Entity.BudgetItem;
import Entity.Category;
import Entity.MainMenu;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Create a Scanner object to read input from the user

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.renderMainMeu();
    }
}
