package com.solvd.bankclasses.places;

import com.solvd.bankclasses.documents.Rules;
import com.solvd.bankclasses.people.Customer;
import com.solvd.bankclasses.people.Employee;
import com.solvd.bankclasses.people.Owner;

public interface ILocations {
    Employee[] getEmployees();

    void setEmployees(Employee[] employees);

    Owner getOwner();

    void setOwner(Owner owner);

    Customer[] getCustomers();

    void setCustomers(Customer[] customers);

    Rules getRules();

    void setRules(Rules rules);

}
