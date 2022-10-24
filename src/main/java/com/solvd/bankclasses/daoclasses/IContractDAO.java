package com.solvd.bankclasses.daoclasses;

import com.solvd.bankclasses.people.Contact;

import java.sql.SQLException;

public interface IContractDAO<C> extends IDAO<Contact> {
    @Override
    public Contact getObjectByID(int id) throws SQLException;

    @Override
    public int getIDbyObject(Contact p) throws SQLException;

    public void create(Contact p) throws SQLException;

    @Override
    public void update(Contact p) throws SQLException;
}