package com.solvd.bankclasses.daoclasses;


import com.solvd.bankclasses.places.Bank;

import java.sql.SQLException;

public interface IBankDAO<B> extends IDAO<Bank> {
    @Override
    public Bank getObjectByID(int id) throws SQLException;

    @Override
    public int getIDbyObject(Bank p) throws SQLException;

    public void create(Bank p) throws SQLException;

    @Override
    public void update(Bank p) throws SQLException;
}