package com.example.distributeddemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Price {

    @JsonIgnore
    public String salesId;
    public String country;
    public String currency;
    public Double price;

}
