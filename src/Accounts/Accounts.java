package Accounts;

import People.Person;

public interface Accounts {

    String getAccType();

    void setAccType(String accType);

    Person getPerson();

    void setPerson(Person person);

    int getId();

    void setId(int id);
}
