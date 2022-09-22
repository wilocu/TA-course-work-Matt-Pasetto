package BankUtilities;

public class Loans {

    private int id;
    private int loanType;
    private double amount;
    private int interestRateId;
    private int personId;

    public Loans(int id, int loanType, double amount, int interestRateId, int personId) {
        this.id = id;
        this.loanType = loanType;
        this.amount = amount;
        this.interestRateId = interestRateId;
        this.personId = personId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLoanType() {
        return loanType;
    }

    public void setLoanType(int loanType) {
        this.loanType = loanType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getInterestRateId() {
        return interestRateId;
    }

    public void setInterestRateId(int interestRateId) {
        this.interestRateId = interestRateId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
