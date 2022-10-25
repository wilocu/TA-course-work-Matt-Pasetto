package com.solvd.bankclasses.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.log4j.Logger;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "accounts")
@XmlType(propOrder = { "id", "balance", "personId" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Accounts {
    @XmlTransient
    private static final Logger LOGGER = Logger.getLogger(Accounts.class.getName());

    @JsonProperty("id")
    @XmlAttribute
    private int id;

    @JsonProperty("balance")
    @XmlElement
    private double balance;

    @JsonProperty("personId")
    @XmlElement
    private int personId;
    private int interestRateId;
    private int actionLogId;

    public Accounts(double balance, int personId, int intrestRateId, int actionLogId) {
        this.balance = balance + 20;
        this.personId = personId;
        this.interestRateId = intrestRateId;
        this.actionLogId = actionLogId;
    }

    public Accounts(double balance, int personId){
        this.balance = balance + 20;
        this.personId = personId;
        interestRateId = 0;
        actionLogId =0;
    }

    public Accounts() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getInterestRateId() {
        return interestRateId;
    }

    public void setInterestRateId(int interestRateId) {
        this.interestRateId = interestRateId;
    }

    public int getActionLogId() {
        return actionLogId;
    }

    public void setActionLogId(int actionLogId) {
        this.actionLogId = actionLogId;
    }

    public void addBalance(double balance) {
        this.balance += balance;
    }

    public void subtractBalance(double balance) {
        this.balance -= balance;
    }


}
