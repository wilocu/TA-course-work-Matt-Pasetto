package com.solvd.bankclasses.daoclasses;

import com.solvd.bankclasses.places.Address;

import java.sql.SQLException;

public interface IAddressDAO extends IDAO<Address> {
    @Override
    public Address getObjectByID(int id) throws SQLException;

    @Override
    public int getIDbyObject(Address p) throws SQLException;

    public void create(Address p) throws SQLException;

    @Override
    public void update(Address p) throws SQLException;
}