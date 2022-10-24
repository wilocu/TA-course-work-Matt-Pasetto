package com.solvd.bankclasses.service;

import com.solvd.bankclasses.people.People;

import java.util.List;

public interface PeopleService {
    public People getPeopleByID(int id);
    public List<People> parseFromXmlDOM(String schemaName, String XmlName);
}

