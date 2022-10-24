package com.solvd.bankclasses.places;

public class ATM {

    private int atmId;
    private int personId;
    private int addressId;
    private int locationId;
    private int fundsId;
    private int securityId;

    public ATM(int atmId) {
        this.atmId = atmId;
    }

    public int getAtmId() {
        return atmId;
    }

    public void setAtmId(int atmId) {
        this.atmId = atmId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getFundsId() {
        return fundsId;
    }

    public void setFundsId(int fundsId) {
        this.fundsId = fundsId;
    }

    public int getSecurityId() {
        return securityId;
    }

    public void setSecurityId(int securityId) {
        this.securityId = securityId;
    }
}
