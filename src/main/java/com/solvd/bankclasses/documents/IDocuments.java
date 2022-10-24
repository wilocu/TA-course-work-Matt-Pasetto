package com.solvd.bankclasses.documents;

import com.solvd.bankclasses.people.People;

public interface IDocuments {

    String getDocType();

    void setDocType(String docType);

    People getCustomer();

    void setCustomer(People people);

    int getId();

    void setId(int id);

    int getBankId();

}
