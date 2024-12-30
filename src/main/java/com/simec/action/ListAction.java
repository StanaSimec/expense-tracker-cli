package com.simec.action;

import com.simec.Expense;
import com.simec.ExpenseService;

import java.text.SimpleDateFormat;
import java.util.List;

public class ListAction implements Action {

    private final ExpenseService expenseService;

    public ListAction() {
        this.expenseService = new ExpenseService();
    }

    @Override
    public void execute(String[] args) {
        List<Expense> expenseList = expenseService.findAll();

        if (expenseList.isEmpty()) {
            System.out.println("No expenses yet.");
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM");
        for (Expense expense : expenseList) {
            System.out.println("| ID: " + expense.getId() + " | Description: " + expense.getDescription()
                    + "  | Amount: " + expense.getAmount() + " | Created at: "
                    + dateFormat.format(expense.getCreatedAt()) + " |");
        }
    }
}
