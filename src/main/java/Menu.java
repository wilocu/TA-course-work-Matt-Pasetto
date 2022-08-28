import Exeptions.InvalidInputException;
import org.apache.log4j.Logger;

public enum Menu {
    LIST_ACCOUNTS (1, "List your accounts"),
    CREATE_ACC (2, "Make new account"),
    DEPOSIT (3, "Deposit cash"),
    WITHDRAW  (4, "Withdraw cash"),
    TRANSFER  (5, "Transfers cash"),
    EXIT_PROGRAM (6, "Exit program");

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    private int selectionNum;
    private String name;

    Menu(int selectionNum, String name) {
        this.selectionNum = selectionNum;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getSelectionNum() {
        return selectionNum;
    }

    public void printMenu() {
        int num = 1;
        LOGGER.info("");
        LOGGER.info("Bank menu:");
        for (Menu option : getClass().getEnumConstants()) {
            LOGGER.info(num + ". " + option.getName());
            num++;
        }
    }

    public Menu makeSelection(int selection) throws InvalidInputException {
        for (Menu option : getClass().getEnumConstants()) {
            if (selection == option.getSelectionNum())
                return option;
        }
        throw new InvalidInputException("Menu selection not in range.");
    }
}