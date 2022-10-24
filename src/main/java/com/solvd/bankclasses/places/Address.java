package com.solvd.bankclasses.places;

import java.util.Objects;
import org.apache.log4j.Logger;

public class Address {
    private static final Logger LOGGER = Logger.getLogger(Address.class.getName());
    //Members
    private int id;
    private String streetAddress;
    private String city;
    private String state;
    private int zipcode;

    //Constructors
    public Address(String streetAddress, String city, String state, int zip) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        zipcode = zip;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int newID) {
        id = newID;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String newCity) {
        city = newCity;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zip) {
        zipcode = zip;
    }

    //Class Overrides
    @Override
    public String toString() {
        return streetAddress + ", " + city + ", " + state + ", " + zipcode + ", ";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Address)) return false;
        Address address = (Address) obj;

        return (Objects.equals(this.streetAddress, address.streetAddress) &&
                Objects.equals(this.city, address.city) &&
                Objects.equals(this.state, address.state) &&
                this.zipcode == address.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetAddress, city, state, zipcode);
    }
}