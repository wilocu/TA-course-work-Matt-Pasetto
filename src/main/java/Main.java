import Accounts.CustomerAcc;
import Exeptions.UnloadedExeption;
import People.Customer;
import People.Owner;
import Places.Bank;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

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
