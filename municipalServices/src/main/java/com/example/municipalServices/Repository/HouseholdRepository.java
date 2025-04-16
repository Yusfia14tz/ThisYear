package com.example.municipalServices.Repository;

import com.example.municipalServices.Model.Household;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdRepository extends JpaRepository<Household, Long> {
}
