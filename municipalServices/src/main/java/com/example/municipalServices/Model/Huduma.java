package com.example.municipalServices.Model;

import jakarta.persistence.*;

@Entity
public class Huduma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    // Remove `nullable = false` so fee can be null
    @Column
    private Double fee;

    @Column
    private String place;

    @Column
    private String ownerName;

    @Column
    private String phoneNo;

    @Column
    private String kindFault;

    @Column
    private Double fine;

    // Constructors
    public Huduma() {}

    public Huduma(String name, Double fee) {
        this.name = name;
        this.fee = fee;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Double getFee() { return fee; }

    public void setFee(Double fee) { this.fee = fee; }

    public String getPlace() { return place; }

    public void setPlace(String place) { this.place = place; }

    public String getOwnerName() { return ownerName; }

    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getPhoneNo() { return phoneNo; }

    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }

    public String getKindFault() { return kindFault; }

    public void setKindFault(String kindFault) { this.kindFault = kindFault; }

    public Double getFine() { return fine; }

    public void setFine(Double fine) { this.fine = fine; }
}
