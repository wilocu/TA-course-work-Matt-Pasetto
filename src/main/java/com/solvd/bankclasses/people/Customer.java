package com.solvd.bankclasses.people;

import java.util.Objects;

public class Customer extends People {

    public int id;

    public Customer(String firstName, String lastName, int id) {
        super(firstName, lastName);
        this.id = id;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Customer other = (Customer) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }

        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }

        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.firstName != null ? this.firstName.hashCode() : 0);
        hash = 53 * hash + (this.lastName != null ? this.lastName.hashCode() : 0);
        hash = 53 * hash + this.id;
        return hash;
    }

}
