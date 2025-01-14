package tracker;

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

        try {
            boolean isDeleted = expenseService.deleteById(Integer.parseInt(args[2]));
            System.out.println(isDeleted ? "Expense deleted" : "Expense not deleted");
        } catch (ExpenseNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
