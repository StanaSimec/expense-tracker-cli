package com.simec.action;

import com.simec.Expense;
import com.simec.ExpenseService;

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

        for (Expense expense : expenseList) {
            System.out.println("id: " + expense.getId() + " description: " + expense.getDescription() + " amount: " + expense.getAmount());
        }
    }
}
