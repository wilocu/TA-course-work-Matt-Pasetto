package Places;

import Documents.Rules;
import People.Customer;
import People.Employee;
import People.Owner;

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
