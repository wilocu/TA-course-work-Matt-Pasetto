package com.solvd.bankclasses.bankutilities;

public class PoliceDepartment {

    private int policeId;
    private String phoneNumber;
    private int estimatedResponseTime;

    public PoliceDepartment(int policeId, String phoneNumber, int estimatedResponseTime) {
        this.policeId = policeId;
        this.phoneNumber = phoneNumber;
        this.estimatedResponseTime = estimatedResponseTime;
    }

    public int getPoliceId() {
        return policeId;
    }

    public void setPoliceId(int policeId) {
        this.policeId = policeId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getEstimatedResponseTime() {
        return estimatedResponseTime;
    }

    public void setEstimatedResponseTime(int estimatedResponseTime) {
        this.estimatedResponseTime = estimatedResponseTime;
    }
}
