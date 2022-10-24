package com.solvd.bankclasses;

import com.solvd.bankclasses.accounts.EmployeeAcc;
import com.solvd.bankclasses.accounts.CustomerAcc;
import com.solvd.bankclasses.exeptions.InvalidInputException;
import com.solvd.bankclasses.other.TestThread;
import com.solvd.bankclasses.people.Employee;
import com.solvd.bankclasses.people.People;
import com.solvd.bankclasses.service.impl.BankServiceImpl;
import com.solvd.bankclasses.service.impl.AccountServiceImpl;
import com.solvd.bankclasses.service.impl.PeopleServiceImpl;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;


public class MainDatabaseWork {

    private static final Logger LOGGER = Logger.getLogger(MainOLD.class.getName());
    private static ArrayList<CustomerAcc> accs = new ArrayList<>();
    private static ArrayList<EmployeeAcc> eAccs = new ArrayList<>();


    public static void main(String[] args) {
        LOGGER.info("Set up Logger");
        Scanner input = new Scanner(System.in);

        LOGGER.info("Welcome to the Bank of America, we are currently running a promotion, get 20$ when you open a new account with us.");

        //Read data from xml DOM
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.parseFromXmlDOM("src/main/resources/xsd_dir/accounts.xsd", "src/main/resources/xml_dir/accounts.xml");

        BankServiceImpl bankService = new BankServiceImpl();
        bankService.parseFromXmlDOM("src/main/resources/xsd_dir/bank.xsd", "src/main/resources/xml_dir/bank.xml");

        PeopleServiceImpl peopleService = new PeopleServiceImpl();
        peopleService.parseFromXmlDOM("src/main/resources/xsd_dir/people.xsd", "src/main/resources/xml_dir/people.xml");

        LOGGER.info("Answer the following questions to sign up.");
        peopleService.addCustomer();

        Menu menu = Menu.LIST_ACCOUNTS;
        boolean exit = false;
        do {
            boolean validInput = false;
            menu.printMenu(); //Print menu options
            while (!validInput) {
                try {
                    menu = menu.makeSelection(Integer.parseInt(input.nextLine())); //Select menu option
                    validInput = true;
                } catch (NumberFormatException | InvalidInputException e) {
                    LOGGER.warn(e.getMessage() + " Please try again.");
                }
            }
            switch (menu){
                case LIST_ACCOUNTS:
                    break;
                case BANK_INFO:
                    break;
                case EMPLOYEE_LIST:
                    break;
                case DEPOSIT:
                    break;
                case WITHDRAW:
                    break;
                case CREATE_ACC:
                    break;
                case TRANSFER:
                    break;
                case EXIT_PROGRAM:
                    LOGGER.info("");
                    LOGGER.info("The bank is now closed");
                    exit = true;
                    break;
                case MAKE_DEADLOCK:
                    break;
                case REFLECT:
                    break;
            }
        } while (!exit);
    }

}
