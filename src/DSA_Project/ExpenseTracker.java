package DSA_Project;

import java.util.*;

class ExpenseTracker {
    public List<Expense> expenses;
    private Map<String, LinkedList<Expense>> expenseCategories;

    public ExpenseTracker() {
        expenses = new LinkedList<>();
        expenseCategories = new HashMap<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);

        // Categorize the expense
        String category = expense.getCategory();
        LinkedList<Expense> categoryExpenses = expenseCategories.getOrDefault(category, new LinkedList<>());
        categoryExpenses.add(expense);
        expenseCategories.put(category, categoryExpenses);
    }

    public List<Expense> viewExpensesByCategory(String category) {
        return expenseCategories.getOrDefault(category, new LinkedList<>());
    }

    public double getTotalExpenditure() {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }
}
