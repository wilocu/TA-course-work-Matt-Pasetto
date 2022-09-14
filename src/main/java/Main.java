import accounts.EmployeeAcc;
import other.DataLoader;
import accounts.CustomerAcc;
import exeptions.InvalidInputException;
import exeptions.UnloadedExeption;
import other.TestThread;
import people.Customer;
import people.Employee;
import people.Owner;
import places.Bank;
import org.apache.log4j.Logger;

import java.io.*;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static ArrayList<CustomerAcc> accs = new ArrayList<>();
    private static ArrayList<EmployeeAcc> eAccs = new ArrayList<>();


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

    public static void main(String[] args) throws UnloadedExeption, IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // TODO functional interface (use at least 3)

        countWords();

        Bank bank = new Bank(1);
        bank.setOwner(new Owner("Matt", "Pasetto"));

        LOGGER.info("Logger up and running");

        Scanner input = new Scanner(System.in);

        DataLoader.loadData();
        DataLoader.checkDataLoaded();
        DataLoader.getEmployees();

        recruitEmployees();

        LOGGER.info("Welcome to the Bank of America, we are currently running a promotion, get 20$ when you open a new account with us.");

        // Create a customer
        LOGGER.info("To become a customer we need some information");
        LOGGER.info("Please enter your FirstName: ");
        String firstName = input.nextLine();

        LOGGER.info("Please enter your LastName: ");
        String lastName = input.nextLine();

        LOGGER.info("Thank you, hold on while we go threw out system.");

        Customer customer = new Customer(firstName, lastName, newId());
        DataLoader.addCustomer(customer);
        LOGGER.info(customer.firstName + " " + customer.lastName + " thank you for your patience you have been added to the system.");


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
                    LOGGER.info("");
                    if(accs.size() > 0){
                        accs.forEach(c -> LOGGER.info("Account Id: " + c.getId() + ". Account Balance: " + c.getBalance()));
                    }
                    else{
                        LOGGER.info("You have no accounts");
                    }
                    break;
                case BANK_INFO:
                    LOGGER.info("The Bank is called Bank of america");
                    LOGGER.info("Bank ID: " + bank.bankId);
                    LOGGER.info("Bank owner is: " + bank.getOwner().firstName + " " + bank.getOwner().lastName);
                    break;
                case EMPLOYEE_LIST:
                    LOGGER.info("");
                    LOGGER.info("");
                    LOGGER.info("The following are the employees in the bank: ");
                    for(int i = 0; i < eAccs.size(); i++){
                        LOGGER.info("Name: " + eAccs.get(i).getPerson().firstName + " " + eAccs.get(i).getPerson().lastName);
                        LOGGER.info("Phone Number: " + eAccs.get(i).phoneNumber);
                        LOGGER.info("");
                    }
                    LOGGER.info("");
                    LOGGER.info("");
                    break;
                case DEPOSIT:
                    LOGGER.info("");
                    LOGGER.info("What is the account ID you are depositing into");
                    int id = input.nextInt();
                    LOGGER.info("How much do you want to deposit");
                    double depositAmount = input.nextInt();
                    for (CustomerAcc c : accs) {
                        if(c.getId() == id){
                            c.addBalance(depositAmount);
                            LOGGER.info("Your new balance is: " + c.getBalance());
                        }
                    }
                    break;
                case WITHDRAW:
                    LOGGER.info("");
                    LOGGER.info("What is the account ID you are withdrawing into");
                    id = input.nextInt();
                    LOGGER.info("How much do you want to withdraw");
                    double withdrawAmount = input.nextInt();
                    for (CustomerAcc c : accs) {
                        if(c.getId() == id){
                            if(c.getBalance() >= withdrawAmount){
                                c.subtractBalance(withdrawAmount);
                                LOGGER.info("Your new balance is: " + c.getBalance());
                            }
                            else{
                                LOGGER.info("The account does not have enough funds");
                            }
                        }
                    }
                    break;
                case CREATE_ACC:
                    LOGGER.info("");
                    CustomerAcc customerAcc = new CustomerAcc("customer", customer, newId());
                    accs.add(customerAcc);
                    LOGGER.info("Your account has a balance of " + customerAcc.getBalance());
                    LOGGER.info("The account ID is " + customerAcc.getId());
                    break;
                case TRANSFER:
                    LOGGER.info("");
                    LOGGER.info("What is the account ID you want to move money from");
                    int idF = input.nextInt();
                    LOGGER.info("What is the account ID you want to move money to");
                    int idT = input.nextInt();
                    LOGGER.info("How much do you want to move");
                    double amount = input.nextInt();
                    for (CustomerAcc c : accs) {
                        if(c.getId() == idF){
                            if(c.getBalance() >= amount) {
                                boolean found = false;
                                for (CustomerAcc acc : accs) {
                                    if(acc.getId() == idT){
                                        found = true;
                                        c.subtractBalance(amount);
                                        LOGGER.info("Your new balance for id: " + c.getId() + " is " + c.getBalance());
                                        acc.addBalance(amount);
                                        LOGGER.info("Your new balance for id: " + acc.getId() + " is " + acc.getBalance());
                                    }
                                }
                                if(!found){
                                    LOGGER.info("Invalid ID");
                                    break;
                                }
                            }
                            else{
                                LOGGER.info("The account does not have enough funds");
                                break;
                            }
                        }
                    }
                    break;
                case EXIT_PROGRAM:
                    LOGGER.info("");
                    LOGGER.info("The bank is now closed");
                    exit = true;
                    break;
                case MAKE_DEADLOCK:
                    new Thread(() -> {
                        System.out.println("New threads created");
                    }).start();
                    TestThread.ThreadDemo1 T1 = new TestThread.ThreadDemo1();
                    TestThread.ThreadDemo2 T2 = new TestThread.ThreadDemo2();
                    T1.start();
                    T2.start();
                    break;
                case REFLECT:
                    Employee emp1 = new Employee("Test", "Test", 10);
                    Employee emp2 = Employee.class.getConstructor(String.class, String.class, int.class).newInstance("test2", "test2", 999);

                    LOGGER.info("Normal employee: " + emp1.firstName + " " + emp1.getEmployeeId());
                    LOGGER.info("New instanced employee: " + emp2.firstName + " " + emp2.getEmployeeId());
                    break;
            }
        } while (!exit);

    }

    private static void recruitEmployees(){
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", "Smith", 1));
        employees.add(new Employee("Alexa", "Montgomery", 2));
        employees.add(new Employee("Alex", "Johnson", 3));
        employees.add(new Employee("Mark", "Cruise", 4));
        employees.forEach(e -> eAccs.add(new EmployeeAcc("employee",e, e.getEmployeeId(),1345972551)));
    }

    private static int newId() {
        return accs.size()+1;
    }

}
