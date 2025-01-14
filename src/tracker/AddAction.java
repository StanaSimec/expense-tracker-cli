package tracker;

import java.util.regex.Pattern;

public class AddAction implements Action {

    private final ExpenseService expenseService;

    public AddAction() {
        this.expenseService = new ExpenseService();
    }

    @Override
    public void execute(String[] args) {
        Pattern pattern = Pattern.compile("add --description \\w{1,50} --amount \\d{1,10}");
        String argument = String.join(" ", args);
        if (!pattern.matcher(argument).matches()) {
            System.out.println("Invalid arguments. Please see README file how to add expense.");
            return;
        }

        boolean isCreated = expenseService.create(args[2], Integer.parseInt(args[4]));
        System.out.println(isCreated ? "Expense created" : "Expense not created");
    }
}
