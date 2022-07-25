public class Account {

    private String accType;
    private Person person;
    private int id;

    public Account(String accType, Person person, int id) {
        this.accType = accType;
        this.person = person;
        this.id = id;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
