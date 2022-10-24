package com.solvd.bankclasses.daoclasses;

import com.solvd.bankclasses.accounts.Accounts;

import java.sql.SQLException;
import java.util.List;

public interface IAccountsDAO<A> extends IDAO<Accounts> {
    @Override
    public Accounts getObjectByID(int id) throws SQLException;

    public List<Accounts> getAccountsByUser(int userID) throws SQLException;

    @Override
    public int getIDbyObject(Accounts p) throws SQLException;

    public int create(Accounts p) throws SQLException;

    @Override
    public void update(Accounts p) throws SQLException;
}