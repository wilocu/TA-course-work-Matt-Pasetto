public class Location {

    private Employee[] employees;
    private Owner owner;
    private Customer[] customers;
    private Rules rules;

    public Location(Employee[] employees, Owner owner, Customer[] customers, Rules rules) {
        this.employees = employees;
        this.owner = owner;
        this.customers = customers;
        this.rules = rules;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public Rules getRules() {
        return rules;
    }

    public void setRules(Rules rules) {
        this.rules = rules;
    }

}
