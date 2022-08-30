package accounts;

import people.Person;

public class CustomerAcc extends Account {

    private double balance;

    public CustomerAcc(String accType, Person person, int id) {
        super(accType, person, id);
        balance = 20; // promotion + 20 $
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double balance) {
        this.balance += balance;
    }

    public void subtractBalance(double balance) {
        this.balance -= balance;
    }

}
