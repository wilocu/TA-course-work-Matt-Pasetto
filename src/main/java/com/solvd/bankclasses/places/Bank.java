package com.solvd.bankclasses.places;

import org.apache.log4j.Logger;

public class Bank {

    private static final Logger LOGGER = Logger.getLogger(Bank.class.getName());

    private int id;
    private int personId;
    private int addressId;
    private int locationId;
    private int fundsId;
    private int securityId;
    private int armoredTransportId;

    public Bank(int personId, int addressId, int locationId, int fundsId, int securityId, int armoredTransportId) {
        this.personId = personId;
        this.addressId = addressId;
        this.locationId = locationId;
        this.fundsId = fundsId;
        this.securityId = securityId;
        this.armoredTransportId = armoredTransportId;
    }

    public Bank(int id) {
        this.id = id;
    }

    public Bank() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getArmoredTransportId() {
        return armoredTransportId;
    }

    public void setArmoredTransportId(int armoredTransportId) {
        this.armoredTransportId = armoredTransportId;
    }
}
