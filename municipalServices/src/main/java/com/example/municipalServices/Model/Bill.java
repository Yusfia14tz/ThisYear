package com.example.municipalServices.Model;

import jakarta.persistence.*;



@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private String status;
    private String controlNo;

    // Many-to-One relationship with Huduma
    @ManyToOne(cascade = CascadeType.PERSIST) // You can change this to CascadeType.ALL if you want all operations to cascade
    @JoinColumn(name = "huduma_id") // Foreign key column for Huduma
    private Huduma huduma;

    // Getters and setters
    public Huduma getHuduma() {
        return huduma;
    }

    public void setHuduma(Huduma huduma) {
        this.huduma = huduma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getControlNo() {
        return controlNo;
    }

    public void setControlNo(String controlNo) {
        this.controlNo = controlNo;
    }
}
