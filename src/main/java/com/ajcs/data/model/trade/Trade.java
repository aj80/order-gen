package com.ajcs.data.model.trade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Trade {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long tradeId;

    private long secId;

    private String transType;

    private long orderQty;

    private double limitPrice;

    protected Trade() {
    }

    public Trade(long tradeId, long secId, String transType, long orderQty, double limitPrice) {
        this.tradeId = tradeId;
        this.secId = secId;
        this.transType = transType;
        this.orderQty = orderQty;
        this.limitPrice = limitPrice;
    }

    public long getTradeId() {
        return tradeId;
    }

    public long getSecId() {
        return secId;
    }

    public String getTransType() {
        return transType;
    }

    public long getOrderQty() {
        return orderQty;
    }

    public double getLimitPrice() {
        return limitPrice;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "tradeId=" + tradeId +
                ", secId=" + secId +
                ", transType='" + transType + '\'' +
                ", orderQty=" + orderQty +
                ", limitPrice=" + limitPrice +
                '}';
    }
}
