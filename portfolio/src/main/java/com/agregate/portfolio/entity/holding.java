package com.agregate.portfolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;

@Entity
public class holding {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String ticker;
    private BigDecimal shares;
    private BigDecimal purchasePrice;
    
    // JPA requires a no-arg constructor
    public Holding() {}
    
    // Convenience constructor (optional but useful)
    public Holding(String ticker, BigDecimal shares, BigDecimal purchasePrice) {
        this.ticker = ticker;
        this.shares = shares;
        this.purchasePrice = purchasePrice;
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

}
