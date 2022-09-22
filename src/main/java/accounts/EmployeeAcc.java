package accounts;

import people.People;

public class EmployeeAcc extends Account {

    public long phoneNumber;

    public EmployeeAcc(String accType, People people, int id, long number) {
        super(accType, people, id);
        phoneNumber = number;
    }

}
