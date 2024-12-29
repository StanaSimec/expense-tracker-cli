package com.simec.action;

public class ActionFactory {

    private ActionFactory(){}

    public static Action fromName(String actionName) {
        switch (actionName) {
            case "add":
                return new AddAction();
            case "list":
                return new ListAction();
            case "delete":
                return new DeleteAction();
            case "summary":
                return new SummaryAction();
            default:
                throw new ActionNotFoundException("Action not found");
        }
    }
}
