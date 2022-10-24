package com.solvd.bankclasses.actions;

public final class Action {

    private int id;
    private String description;
    private String actionType;

    public Action(int id, String description, String actionType) {
        this.id = id;
        this.description = description;
        this.actionType = actionType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }
}
