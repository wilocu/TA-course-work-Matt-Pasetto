package com.solvd.bankclasses.service;

import com.solvd.bankclasses.accounts.Accounts;

import java.util.List;

public interface AccountService {
    public void createAccount(Accounts d);

    public List<Accounts> getAccountByUser(int userID);

    public List<Accounts> parseFromXmlDOM(String schemaName, String XmlName);

    public void parseFromXmlJAXB(String schemaName, String XmlName);
}
