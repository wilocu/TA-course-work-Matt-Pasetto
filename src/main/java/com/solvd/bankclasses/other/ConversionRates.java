package com.solvd.bankclasses.other;

public enum ConversionRates {
    DOLLARS ("dollars", 1),
    EUROS ("euros", 1.1),
    PESOS("mexican pesos", 20);

    private String name;
    private double conversionRate;

    ConversionRates(String name, double conversionRate) {
        this.name = name;
        this.conversionRate = conversionRate;
    }

    public String getName() {
        return name;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public double convert(double value) {
        return value * conversionRate;
    }
}