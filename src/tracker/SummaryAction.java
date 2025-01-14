package tracker;

import java.util.Calendar;
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

        if (args.length == 1) {
            int summary = expenses.stream()
                    .mapToInt(Expense::getAmount)
                    .sum();

            System.out.println("Total summary: " + summary);
            return;
        }

        int inputMonth = Integer.parseInt(args[2]);
        if (inputMonth < 1 || inputMonth > 12) {
            System.out.println("Invalid month");
            return;
        }

        int summary = expenses.stream()
                .filter(e -> {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(e.getCreatedAt());
                    int createdAtMonth = calendar.get(Calendar.MONTH) + 1;
                    return inputMonth == createdAtMonth;
                })
                .mapToInt(Expense::getAmount)
                .sum();

        System.out.println("Month " + args[2] + " total summary: " + summary);
    }
}
