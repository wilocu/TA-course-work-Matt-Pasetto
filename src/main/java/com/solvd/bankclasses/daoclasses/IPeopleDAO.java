package com.solvd.bankclasses.daoclasses;


import com.solvd.bankclasses.people.People;

import java.sql.SQLException;

public interface IPeopleDAO<P> extends IDAO<People> {
    @Override
    public People getObjectByID(int id) throws SQLException;

    @Override
    public int getIDbyObject(People p) throws SQLException;

    public int create(People p) throws SQLException;

    @Override
    public void update(People p) throws SQLException;
}