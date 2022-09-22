package people;

import accounts.EmployeeAcc;

import java.util.Objects;

public class Employee extends People {

    private int employeeId;
    private EmployeeAcc acc;

    public Employee(String firstName, String lastName, int id) {
        super(firstName, lastName);
        employeeId = id;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Employee other = (Employee) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }

        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }

        return this.employeeId == other.employeeId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.firstName != null ? this.firstName.hashCode() : 0);
        hash = 53 * hash + (this.lastName != null ? this.lastName.hashCode() : 0);
        hash = 53 * hash + this.employeeId;
        return hash;
    }

}
