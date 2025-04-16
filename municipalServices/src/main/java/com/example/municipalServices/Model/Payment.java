package com.example.municipalServices.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double amountPaid;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @Column(nullable = false)
    private String status;

    public Payment() {}

    public Payment(Double amountPaid, Date date, Bill bill, String status) {
        this.amountPaid = amountPaid;
        this.date = date;
        this.bill = bill;
        this.status = status;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Double getAmountPaid() { return amountPaid; }

    public void setAmountPaid(Double amountPaid) { this.amountPaid = amountPaid; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public Bill getBill() { return bill; }

    public void setBill(Bill bill) { this.bill = bill; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}
