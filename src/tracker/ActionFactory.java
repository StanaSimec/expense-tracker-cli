package tracker;

public class ActionFactory {

    private ActionFactory() {
    }

    public static Action fromName(String actionName) {
        return switch (actionName) {
            case "add" -> new AddAction();
            case "list" -> new ListAction();
            case "delete" -> new DeleteAction();
            case "summary" -> new SummaryAction();
            case "update" -> new UpdateAction();
            default -> throw new ActionNotFoundException("Action not found");
        };
    }
}
