package accounts;

import people.People;

public class Account implements IAccounts {

    private String accType;
    private People people;
    private int id;

    public Account(String accType, People people, int id) {
        this.accType = accType;
        this.people = people;
        this.id = id;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public People getPerson() {
        return people;
    }

    public void setPerson(People people) {
        this.people = people;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
