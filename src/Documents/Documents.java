package Documents;

import People.Person;

public interface Documents {

    String getDocType();

    void setDocType(String docType);

    Person getCustomer();

    void setCustomer(Person person);

    int getId();

    void setId(int id);

    int getBankId();

}
