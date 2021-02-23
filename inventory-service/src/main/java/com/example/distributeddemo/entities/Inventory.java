package com.example.distributeddemo.entities;

import javax.persistence.*;

@Entity
public class Inventory {

    @Id
    @GeneratedValue
    public String id;

    public String salesId;

    @ManyToOne
    public Warehouse warehouse;

    public Long stock;


}
