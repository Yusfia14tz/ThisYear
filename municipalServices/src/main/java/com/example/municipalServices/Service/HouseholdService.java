package com.example.municipalServices.Service;

import com.example.municipalServices.Model.Household;
import com.example.municipalServices.Repository.HouseholdRepository;
import com.example.municipalServices.Repository.ZoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseholdService {

    private final HouseholdRepository householdRepository;
    private final ZoneRepository zoneRepository;

    public HouseholdService(HouseholdRepository householdRepository, ZoneRepository zoneRepository) {
        this.householdRepository = householdRepository;
        this.zoneRepository = zoneRepository;
    }

    public List<Household> getAll() {
        return householdRepository.findAll();
    }

    public Household getById(Long id) {
        return householdRepository.findById(id).orElse(null);
    }

    public Household save(Household household) {
        return householdRepository.save(household);
    }


    public void delete(Long id) {
        householdRepository.deleteById(id);
    }

    // Example of update method in HouseholdService

    public Household update(Long id, Household household) {
        // First, find the existing Household from the database
        Household existingHousehold = householdRepository.findById(id).orElseThrow(() -> new RuntimeException("Household not found"));

        // Now, update the fields you want
        existingHousehold.setHeadName(household.getHeadName());
        existingHousehold.setPhoneNumber(household.getPhoneNumber());

        // Save the updated Household back to the database
        return householdRepository.save(existingHousehold);
    }

}
