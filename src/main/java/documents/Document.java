package documents;

import people.People;
import places.Bank;

public class Document implements IDocuments {

    private String type;
    private int id;
    private People customer;
    private Bank bank;

    public Document(String type, int id, People customer, Bank bank){
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
    public People getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(People people) {
        customer = people;
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
