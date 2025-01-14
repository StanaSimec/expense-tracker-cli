package tracker;

public class Controller {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Missing arguments.");
            return;
        }
        String actionName = args[0];
        try {
            Action action = ActionFactory.fromName(actionName);
            action.execute(args);
        } catch (ActionNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}