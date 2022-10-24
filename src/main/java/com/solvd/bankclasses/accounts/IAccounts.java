package com.solvd.bankclasses.accounts;

import com.solvd.bankclasses.people.People;

public interface IAccounts {

    String getAccType();

    void setAccType(String accType);

    People getPerson();

    void setPerson(People people);

    int getId();

    void setId(int id);
}
