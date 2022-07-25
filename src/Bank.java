public class Bank extends Location {

    public int bankId;

    public Bank(Employee[] employees, Owner owner, Customer[] customers, Rules rules, int id) {
        super(employees, owner, customers, rules);
        bankId = id;
    }

}
