package accounts;

import people.Person;

public class EmployeeAcc extends Account {

    public long phoneNumber;

    public EmployeeAcc(String accType, Person person, int id, long number) {
        super(accType, person, id);
        phoneNumber = number;
    }

}
