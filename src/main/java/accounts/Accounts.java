package accounts;

public class Accounts {

    private int id;
    private double balance;
    private int personId;
    private int interestRateId;
    private int actionLogId;

    public Accounts(double balance, int personId, int intrestRateId, int actionLogId) {
        this.balance = balance;
        this.personId = personId;
        this.interestRateId = intrestRateId;
        this.actionLogId = actionLogId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getInterestRateId() {
        return interestRateId;
    }

    public void setInterestRateId(int interestRateId) {
        this.interestRateId = interestRateId;
    }

    public int getActionLogId() {
        return actionLogId;
    }

    public void setActionLogId(int actionLogId) {
        this.actionLogId = actionLogId;
    }
}
