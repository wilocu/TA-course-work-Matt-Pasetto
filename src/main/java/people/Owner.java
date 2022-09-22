package people;

import places.Bank;

import java.util.Objects;

public class Owner extends People {

    public Bank bank;
    public Owner(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + bank.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Owner other = (Owner) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }

        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }

        return Objects.equals(this.bank, other.bank);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.firstName != null ? this.firstName.hashCode() : 0);
        hash = 53 * hash + (this.lastName != null ? this.lastName.hashCode() : 0);
        return hash;
    }

}
