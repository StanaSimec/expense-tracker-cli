package tracker;

import java.util.regex.Pattern;

public class UpdateAction implements Action {

    private final ExpenseService expenseService;

    public UpdateAction() {
        this.expenseService = new ExpenseService();
    }

    @Override
    public void execute(String[] args) {
        Pattern pattern = Pattern.compile("update --id \\d{1,3} --description \\w{1,50} --amount \\d{1,10}");
        String argument = String.join(" ", args);
        if (!pattern.matcher(argument).matches()) {
            System.out.println("Invalid arguments. Please see README file how to update expense.");
            return;
        }

        try {
            boolean isUpdated = expenseService.updateExpense(Integer.parseInt(args[2]), args[4], Integer.parseInt(args[6]));
            System.out.println(isUpdated ? "Expense updated" : "Expense not updated");
        } catch (ExpenseNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
