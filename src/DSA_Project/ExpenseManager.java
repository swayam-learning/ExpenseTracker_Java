package DSA_Project;

import java.util.*;
import java.util.Date;
import java.util.InputMismatchException;

public class ExpenseManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Expense> expenses = new ArrayList<>();

        while (true) {
            try {
                System.out.print("Enter expense amount (0 to exit): ₹");
                double amount = scanner.nextDouble();
                scanner.nextLine();  // Consume the newline

                if (amount == 0)
                    break;

                System.out.print("Enter expense category: ");
                String category = scanner.nextLine();

                System.out.print("Enter expense description: ");
                String description = scanner.nextLine();

                Expense expense = new Expense(new Date(), amount, category, description);
                expenses.add(expense);
                System.out.println("Expense added successfully.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid amount (a number).");
                scanner.nextLine();  // Consume the invalid input to prevent an infinite loop
            }
        }

        // Display expenses
        displayExpenses(expenses);

        // Save expenses to a text file
        ExpenseSaver.saveExpenses(expenses);
    }

    private static void displayExpenses(List<Expense> expenses) {
        System.out.println("\nExpense Summary:");
        for (Expense expense : expenses) {
            System.out.println(expense);
        }

        ExpenseTracker tracker = new ExpenseTracker();
        for (Expense expense : expenses) {
            tracker.addExpense(expense);
        }
        System.out.println("\nTotal Expenditure: ₹" + tracker.getTotalExpenditure());
    }
}
