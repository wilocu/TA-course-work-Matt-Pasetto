package documents;

import people.Person;

public interface IDocuments {

    String getDocType();

    void setDocType(String docType);

    Person getCustomer();

    void setCustomer(Person person);

    int getId();

    void setId(int id);

    int getBankId();

}
