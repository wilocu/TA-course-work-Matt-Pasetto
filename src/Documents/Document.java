package Documents;

import People.Person;
import Places.Bank;

public class Document implements Documents{

    private String type;
    private int id;
    private Person customer;
    private Bank bank;

    public Document(String type, int id, Person customer, Bank bank){
        this.type = type;
        this.id = id;
        this.customer = customer;
        this.bank = bank;
    }

    @Override
    public String getDocType() {
        return type;
    }

    @Override
    public void setDocType(String docType) {
        type = docType;
    }

    @Override
    public Person getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Person person) {
        customer = person;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getBankId() {
        return bank.bankId;
    }
}
