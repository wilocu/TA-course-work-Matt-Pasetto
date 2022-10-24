package com.solvd.bankclasses.places;


public class Location {

    private int locationId;
    private int locationType;

    public Location(int locationId, int locationType) {
        this.locationId = locationId;
        this.locationType = locationType;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getLocationType() {
        return locationType;
    }

    public void setLocationType(int locationType) {
        this.locationType = locationType;
    }
}
