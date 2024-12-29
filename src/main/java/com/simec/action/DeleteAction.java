package com.simec.action;

import com.simec.ExpenseService;

import java.util.regex.Pattern;

public class DeleteAction implements Action {

    private final ExpenseService expenseService;

    public DeleteAction() {
        expenseService = new ExpenseService();
    }

    @Override
    public void execute(String[] args) {
        Pattern pattern = Pattern.compile("delete --id \\d{1,1000}");
        String argument = String.join(" ", args);
        if (!pattern.matcher(argument).matches()) {
            System.out.println("Invalid arguments. Please see README file how to delete expense.");
            return;
        }

        boolean isDeleted = expenseService.deleteById(Integer.parseInt(args[2]));
        System.out.println(isDeleted ? "Expense deleted" : "Expense not deleted");
    }
}
