package com.example.municipalServices.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "building")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String location;

    @ManyToOne
    @JoinColumn(name = "household_id")
    private Household household;

    // Constructors
    public Building() {
    }

    public Building(String type, String location, Household household) {
        this.type = type;
        this.location = location;
        this.household = household;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public Household getHousehold() { return household; }

    public void setHousehold(Household household) { this.household = household; }
}
