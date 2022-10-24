package com.solvd.bankclasses.places;

import org.apache.log4j.Logger;

public class ArmoredTransport {

    private static final Logger LOGGER = Logger.getLogger(ArmoredTransport.class.getName());

    private int id;
    private String nextDate;
    private double amount;

    public ArmoredTransport(int id, String nDate, double amount) {
        this.id = id;
        this.nextDate = nDate;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNextDate() {
        return nextDate;
    }

    public void setNextDate(String nextDate) {
        this.nextDate = nextDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
