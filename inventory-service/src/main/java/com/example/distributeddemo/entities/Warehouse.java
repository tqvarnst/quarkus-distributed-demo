package com.example.distributeddemo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Warehouse {

    @Id
    public String id;

    public String name;

    public String location;

}
