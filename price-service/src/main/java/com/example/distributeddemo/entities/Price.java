package com.example.distributeddemo.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Price extends PanacheEntity {
    public String salesId;
    public String country;
    public String currency;
    public Double price;

    public Price() {
    }

    public Price(String salesId, String country, String currency, Double price) {
        this.salesId = salesId;
        this.country = country;
        this.currency = currency;
        this.price = price;
    }
}
