package com.solvd.bankclasses.actions;

public interface IActionType {

    boolean approved();

    int getActionId();

    int getOriginAccId();

    int getDestinationAccId();

}
