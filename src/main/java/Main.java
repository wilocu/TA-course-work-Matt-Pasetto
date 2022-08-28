import Accounts.CustomerAcc;
import Exeptions.InvalidInputException;
import Exeptions.UnloadedExeption;
import People.Customer;
import People.Owner;
import Places.Bank;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static ArrayList<CustomerAcc> accs = new ArrayList<>();


    public static void countWords() throws IOException {
        //counters
        int charsCount = 0;
        int wordsCount = 0;
        int linesCount = 0;

        Scanner in = null;
        File file = new File("C:\\Users\\matpa\\IdeaProjects\\BankClasses\\src\\Other\\wordsfile.txt");

        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)))){

            while (scanner.hasNextLine()) {

                String tmpStr = scanner.nextLine();
                if (!tmpStr.equalsIgnoreCase("")) {
                    String replaceAll = tmpStr.replaceAll("\\s+", "");
                    charsCount += replaceAll.length();
                    wordsCount += tmpStr.split("\\s+").length;
                }
                ++linesCount;
            }

            File myObj = new File("C:\\Users\\matpa\\IdeaProjects\\BankClasses\\src\\Other\\results.txt");

            try {
                FileWriter myWriter = new FileWriter(myObj.getName());
                myWriter.write("# of chars: " + charsCount);
                myWriter.write("# of words: " + wordsCount);
                myWriter.write("# of lines: " + linesCount);
                myWriter.write("# of bytes: " + file.length());
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws UnloadedExeption, IOException {

        countWords();

        Bank bank = new Bank(1);
        bank.setOwner(new Owner("Matt", "Pasetto"));

        logger.info("Logger up and running");

        Scanner input = new Scanner(System.in);

        DataLoader.loadData();
        DataLoader.checkDataLoaded();
        DataLoader.getEmployees();

        logger.info("Welcome to the Bank of America, we are currently running a promotion, get 20$ when you open a new account with us.");

        // Create a customer
        logger.info("To become a customer we need some information");
        logger.info("Please enter your FirstName: ");
        String firstName = input.nextLine();

        logger.info("Please enter your LastName: ");
        String lastName = input.nextLine();

        logger.info("Thank you, hold on while we go threw out system.");

        Customer customer = new Customer(firstName, lastName, newId());
        DataLoader.addCustomer(customer);
        logger.info(customer.firstName + " " + customer.lastName + " thank you for your patience you have been added to the system.");


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
                    logger.warn(e.getMessage() + " Please try again.");
                }
            }
            switch (menu){
                case LIST_ACCOUNTS:
                    logger.info("");
                    if(accs.size() > 0){
                        for (CustomerAcc c : accs) {
                            logger.info("Account Id: " + c.getId() + ". Account Balance: " + c.getBalance());
                        }
                    }
                    else{
                        logger.info("You have no accounts");
                    }
                    break;
                case DEPOSIT:
                    logger.info("");
                    logger.info("What is the account ID you are depositing into");
                    int id = input.nextInt();
                    logger.info("How much do you want to deposit");
                    double depositAmount = input.nextInt();
                    for (CustomerAcc c : accs) {
                        if(c.getId() == id){
                            c.addBalance(depositAmount);
                            logger.info("Your new balance is: " + c.getBalance());
                        }
                    }
                    break;
                case WITHDRAW:
                    logger.info("");
                    logger.info("What is the account ID you are withdrawing into");
                    id = input.nextInt();
                    logger.info("How much do you want to withdraw");
                    double withdrawAmount = input.nextInt();
                    for (CustomerAcc c : accs) {
                        if(c.getId() == id){
                            if(c.getBalance() >= withdrawAmount){
                                c.subtractBalance(withdrawAmount);
                                logger.info("Your new balance is: " + c.getBalance());
                            }
                            else{
                                logger.info("The account does not have enough funds");
                            }
                        }
                    }
                    break;
                case CREATE_ACC:
                    logger.info("");
                    CustomerAcc customerAcc = new CustomerAcc("customer", customer, newId());
                    accs.add(customerAcc);
                    logger.info("Your account has a balance of " + customerAcc.getBalance());
                    logger.info("The account ID is " + customerAcc.getId());
                    break;
                case TRANSFER:
                    logger.info("");
                    logger.info("What is the account ID you want to move money from");
                    int idF = input.nextInt();
                    logger.info("What is the account ID you want to move money to");
                    int idT = input.nextInt();
                    logger.info("How much do you want to move");
                    double amount = input.nextInt();
                    for (CustomerAcc c : accs) {
                        if(c.getId() == idF){
                            if(c.getBalance() >= amount) {
                                boolean found = false;
                                for (CustomerAcc acc : accs) {
                                    if(acc.getId() == idT){
                                        found = true;
                                        c.subtractBalance(amount);
                                        logger.info("Your new balance for id: " + c.getId() + " is " + c.getBalance());
                                        acc.addBalance(amount);
                                        logger.info("Your new balance for id: " + acc.getId() + " is " + acc.getBalance());
                                    }
                                }
                                if(!found){
                                    logger.info("Invalid ID");
                                    break;
                                }
                            }
                            else{
                                logger.info("The account does not have enough funds");
                                break;
                            }
                        }
                    }
                    break;
                case EXIT_PROGRAM:
                    logger.info("");
                    logger.info("The bank is now closed");
                    exit = true;
                    break;
                case MAKE_DEADLOCK:
                    TestThread.ThreadDemo1 T1 = new TestThread.ThreadDemo1();
                    TestThread.ThreadDemo2 T2 = new TestThread.ThreadDemo2();
                    T1.start();
                    T2.start();
                    break;
            }
        } while (!exit);

    }

    private static int newId() {
        return accs.size()+1;
    }

}
