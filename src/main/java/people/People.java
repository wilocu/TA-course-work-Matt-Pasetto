package people;

public class People implements IPeople {

    private int id;
    public String firstName;
    public String lastName;
    private int personType; // 0 = owner, 1 = employee, 2 = customer

    public People(String firstName, String lastName, int ptype) {
        this.firstName = firstName;
        this.lastName = lastName;
        personType = ptype;
    }

    // default customer
    public People(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        personType = 2;
    }

    public String personInfo(){
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonType() {
        return personType;
    }

    public void setPersonType(int personType) {
        this.personType = personType;
    }
}
