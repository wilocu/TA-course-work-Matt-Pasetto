package com.solvd.bankclasses.service;

import com.solvd.bankclasses.places.Bank;

import java.util.List;

public interface BankService {

    public Bank getBankByID(int id);
    public List<Bank> parseFromXmlDOM(String schemaName, String XmlName);
}