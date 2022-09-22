package BankUtilities;

public class Security {

    private int securityId;
    private int departmentId; //todo set a default???

    public Security(int securityId) {
        this.securityId = securityId;
    }

    public int getSecurityId() {
        return securityId;
    }

    public void setSecurityId(int securityId) {
        this.securityId = securityId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
