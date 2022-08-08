import Exeptions.UnloadedExeption;

public class Main {

    // action is the final class
    // person is the abstract class

    public static void main(String[] args) throws UnloadedExeption {

        DataLoader.loadData();
        DataLoader.checkDataLoaded();
        DataLoader.getEmployees();
        System.out.println("Bank opened");
    }

}
