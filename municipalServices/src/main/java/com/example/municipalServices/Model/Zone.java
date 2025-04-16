package com.example.municipalServices.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "zone")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "zone")
    private List<Household> households;

    public Zone() {}

    public Zone(String name) {
        this.name = name;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public List<Household> getHouseholds() { return households; }

    public void setHouseholds(List<Household> households) { this.households = households; }

    public Zone save(Zone zone) {
        return null;
    }
}
