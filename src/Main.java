import Accounts.CustomerAcc;
import Exeptions.UnloadedExeption;
import People.Customer;
import People.Owner;
import People.Person;
import Places.Bank;
import org.apache.log4j.Logger;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws UnloadedExeption {

        Bank bank = new Bank(1);
        bank.setOwner(new Owner("Matt", "Pasetto"));

        logger.info("Logger up and running");

        Scanner input = new Scanner(System.in);

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

        CustomerAcc customerAcc = new CustomerAcc("customer", customer, newId());
        logger.info("Your account has a balance of " + customerAcc.getBalance());
    }

    private static int newId() {
        return ThreadLocalRandom.current().nextInt(0, 100 + 1);
    }

}
