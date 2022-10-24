package com.solvd.bankclasses.documents;

import com.solvd.bankclasses.people.People;
import com.solvd.bankclasses.places.Bank;

public class Document  {

    private String type;
    private int id;
    private People customer;
    private Bank bank;

    public Document(String type, int id, People customer, Bank bank){
        this.type = type;
        this.id = id;
        this.customer = customer;
        this.bank = bank;
    }

    public String getDocType() {
        return type;
    }


    public void setDocType(String docType) {
        type = docType;
    }


    public People getCustomer() {
        return customer;
    }


    public void setCustomer(People people) {
        customer = people;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

//    @Override
//    public int getBankId() {
//        return bank.bankId;
//    }
}
