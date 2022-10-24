package com.solvd.bankclasses.actions;

import java.util.Date;

public class ActionLog {

    private int id;
    private Date date;
    private int actionsId;

    public ActionLog(int id, Date date, int actionsId) {
        this.id = id;
        this.date = date;
        this.actionsId = actionsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getActionsId() {
        return actionsId;
    }

    public void setActionsId(int actionsId) {
        this.actionsId = actionsId;
    }
}
