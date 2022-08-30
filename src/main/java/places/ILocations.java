package places;

import documents.Rules;
import people.Customer;
import people.Employee;
import people.Owner;

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
