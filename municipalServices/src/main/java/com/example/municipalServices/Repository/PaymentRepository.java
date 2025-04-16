package com.example.municipalServices.Repository;

import com.example.municipalServices.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
