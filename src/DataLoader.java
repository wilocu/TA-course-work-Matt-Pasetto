import Exeptions.UnloadedExeption;
import People.Customer;
import People.Employee;
import People.Owner;
import Places.Bank;

import java.util.ArrayList;
import java.util.logging.Logger;

public class DataLoader {
    private static final Logger logger = Logger.getLogger(DataLoader.class.getName());
    public static ArrayList<Employee> employees = new ArrayList<>();
    public static ArrayList<Customer> customers = new ArrayList<>();
    public static Owner owner;

    private DataLoader() {}

    public static void loadData() {
        loadEmployees();
        loadOwner();
        logger.info("Data loaded.");
    }

    private static void loadOwner() {
        owner = (new Owner("Tom", "Smoe"));
    }

    private static void loadEmployees() {
        employees.clear();
        employees.add(new Employee("John", "Smith", 1));
        employees.add(new Employee("Alexa", "Montgomery", 2));
        employees.add(new Employee("Alex", "Johnson", 3));
        employees.add(new Employee("Mark", "Cruise", 4));
    }

    public static void checkDataLoaded() throws UnloadedExeption {
        if (employees.isEmpty() || owner == null) {
            throw new UnloadedExeption("Attempting to access DataLoader data that has not been loaded");
        }
    }

    public static ArrayList<Employee> getEmployees() throws UnloadedExeption {
        try {
            checkDataLoaded();
            return employees;
        } catch (UnloadedExeption e) {
            throw new UnloadedExeption(e.getMessage());
        }
    }

}
