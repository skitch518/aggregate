package com.agregate.portfolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.math.BigDecimal;

@Entity
public class Holding {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String ticker;
    private BigDecimal shares;
    private BigDecimal purchasePrice;

    @Transient
    private BigDecimal currentPrice;

    // JPA requires a no-arg constructor
    public Holding() {}
    
    // Convenience constructor (optional but useful)
    public Holding(String ticker, BigDecimal shares, BigDecimal purchasePrice) {
        this.ticker = ticker;
        this.shares = shares;
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getCurrentValue() {
        if (currentPrice == null || shares == null) {
        return null;
        }
        return shares.multiply(currentPrice);
    }
    
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTicker() { return ticker; }
    public void setTicker(String ticker) { this.ticker = ticker; }
    
    public BigDecimal getShares() { return shares; }
    public void setShares(BigDecimal shares) { this.shares = shares; }
    
    public BigDecimal getPurchasePrice() { return purchasePrice; }
    public void setPurchasePrice(BigDecimal purchasePrice) { this.purchasePrice = purchasePrice; }

    public BigDecimal getCurrentPrice() {return currentPrice;}
    public void setCurrentPrice(BigDecimal currentPrice) {this.currentPrice = currentPrice;}

}
