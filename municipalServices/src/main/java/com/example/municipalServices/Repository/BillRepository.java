package com.example.municipalServices.Repository;

import com.example.municipalServices.Model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
    // You can add custom query methods if needed
}
