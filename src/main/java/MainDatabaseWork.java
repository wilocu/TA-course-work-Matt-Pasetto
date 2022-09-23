import accounts.EmployeeAcc;
import other.DataLoader;
import accounts.CustomerAcc;
import exeptions.InvalidInputException;
import exeptions.UnloadedExeption;
import other.TestThread;
import people.Customer;
import people.Employee;
import places.Bank;
import org.apache.log4j.Logger;

import java.io.*;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Scanner;


public class MainDatabaseWork {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static ArrayList<CustomerAcc> accs = new ArrayList<>();
    private static ArrayList<EmployeeAcc> eAccs = new ArrayList<>();


    public static void main(String[] args) {
        LOGGER.info("Set up Logger");
        Scanner input = new Scanner(System.in);

        LOGGER.info("Welcome to the Bank of America, we are currently running a promotion, get 20$ when you open a new account with us.");


    }

}
