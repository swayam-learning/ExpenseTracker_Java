package DSA_Project;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class ExpenseSaver {
    private static final String DATA_FILE = "expenses.txt";

    public static void saveExpenses(List<Expense> expenses) {
        try (PrintWriter writer = new PrintWriter(DATA_FILE)) {
            for (Expense expense : expenses) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = dateFormat.format(expense.getDate());
                writer.println("Date: " + formattedDate + ", Amount: ₹" + expense.getAmount() +
                        ", Category: " + expense.getCategory() + ", Description: " + expense.getDescription());
            }
            System.out.println("Expenses saved to " + DATA_FILE);
        } catch (IOException e) {
            System.out.println("An error occurred while saving expenses to the file.");
        }
    }
}
