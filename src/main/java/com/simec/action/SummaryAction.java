package com.simec.action;

import com.simec.Expense;
import com.simec.ExpenseService;

import java.util.List;
import java.util.regex.Pattern;

public class SummaryAction implements Action {

    private final ExpenseService expenseService;

    public SummaryAction() {
        expenseService = new ExpenseService();
    }

    @Override
    public void execute(String[] args) {
        Pattern pattern = Pattern.compile("summary --month \\d{1,2}|summary");
        String argument = String.join(" ", args);
        if (!pattern.matcher(argument).matches()) {
            System.out.println("Invalid arguments. Please see README file how to summary expenses.");
            return;
        }

        List<Expense> expenses = expenseService.findAll();

        int summary = expenses.stream()
                .mapToInt(Expense::getAmount)
                .sum();

        System.out.println("Total summary: " + summary);
    }
}
