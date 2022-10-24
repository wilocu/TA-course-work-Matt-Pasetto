package com.solvd.bankclasses;

import com.solvd.bankclasses.exeptions.InvalidInputException;
import org.apache.log4j.Logger;

public enum Menu {
    LIST_ACCOUNTS (1, "List your com.solvd.bankclasses.accounts"),
    CREATE_ACC (2, "Make new account"),
    DEPOSIT (3, "Deposit cash"),
    WITHDRAW  (4, "Withdraw cash"),
    TRANSFER  (5, "Transfers cash"),
    BANK_INFO  (6, "Print bank info"),
    EMPLOYEE_LIST  (7, "Print employee list"),
    EXIT_PROGRAM (8, "Exit program"),
    MAKE_DEADLOCK(9, "Makes a deadlock"),
    REFLECT(10, "Reflection test");

    private static final Logger LOGGER = Logger.getLogger(MainOLD.class.getName());

    private int selectionNum;
    private String name;

    Menu(int selectionNum, String name) {
        this.selectionNum = selectionNum;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getSelectionNum() {
        return selectionNum;
    }

    public void printMenu() {
        int num = 1;
        LOGGER.info("");
        LOGGER.info("Bank menu:");
        for (Menu option : getClass().getEnumConstants()) {
            LOGGER.info(num + ". " + option.getName());
            num++;
        }
    }

    public Menu makeSelection(int selection) throws InvalidInputException {
        for (Menu option : getClass().getEnumConstants()) {
            if (selection == option.getSelectionNum())
                return option;
        }
        throw new InvalidInputException("com.solvd.bankclasses.Menu selection not in range.");
    }
}