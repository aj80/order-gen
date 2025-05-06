package com.ajcs.data.model.refdata;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Security {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long secId;
    private String ticker;
    private String secName;
    private double mkrPrice;

    protected Security() {

    }

    public Security(long secId, String ticker, String secName, double mktPrice) {
        this.secId = secId;
        this.ticker = ticker;
        this.secName = secName;
        this.mkrPrice = mktPrice;
    }

    public long getSecId() {
        return secId;
    }

    public String getTicker() {
        return ticker;
    }

    public String getSecName() {
        return secName;
    }

    public double getMkrPrice() {
        return mkrPrice;
    }

    @Override
    public String toString() {
        return "Security{" +
                "secId=" + secId +
                ", ticker='" + ticker + '\'' +
                ", secName='" + secName + '\'' +
                ", mkrPrice=" + mkrPrice +
                '}';
    }
}
