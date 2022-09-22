package BankUtilities;

import java.text.DecimalFormat;

public class InterestRates {

    private int id;
    private DecimalFormat rate;
    private int years;

    public InterestRates(int id, DecimalFormat rate, int years) {
        this.id = id;
        this.rate = rate;
        this.years = years;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DecimalFormat getRate() {
        return rate;
    }

    public void setRate(DecimalFormat rate) {
        this.rate = rate;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
}
