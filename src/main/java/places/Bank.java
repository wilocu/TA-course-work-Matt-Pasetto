package places;

import documents.Rules;
import people.Customer;
import people.Employee;

import java.util.LinkedList;

public class Bank extends Location {

    public int bankId;
    private LinkedList<Employee> employees;
    private LinkedList<Customer> customers;
    private Rules rules;

    public Bank(int id) {
        super(id);
        bankId = id;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void removeCustomer(Customer customer){
        customers.remove(customer);
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public void removeEmployee(Employee employee){
        employees.remove(employee);
    }

}
