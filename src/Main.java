import Exeptions.UnloadedExeption;
import People.Customer;
import People.Person;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws UnloadedExeption {

        logger.info("Logger up and running");

        Scanner input = new Scanner(System.in);

        LinkedList<Person> profiles = new LinkedList<Person>();

        DataLoader.loadData();
        DataLoader.checkDataLoaded();
        DataLoader.getEmployees();

        logger.info("Welcome to the Bank of America, we are currently running a promotion, get 20$ when you open an account with us.");

        logger.info("To become a customer we need some information");
        logger.info("Please enter your FirstName: ");
        String firstName = input.nextLine();

        logger.info("Please enter your LastName: ");
        String lastName = input.nextLine();

        logger.info("Thank you, hold on while we go threw out system.");

        Customer customer = new Customer(firstName, lastName, newId());
        DataLoader.addCustomer(customer);
        logger.info(customer.firstName + " " + customer.lastName + " thank you for your patience you have been added to the system.");

    }

    private static int newId() {
        return ThreadLocalRandom.current().nextInt(0, 100 + 1);
    }

}
