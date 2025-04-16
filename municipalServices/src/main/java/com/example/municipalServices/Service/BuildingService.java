package com.example.municipalServices.Service;

import com.example.municipalServices.Model.Building;
import com.example.municipalServices.Model.Household;
import com.example.municipalServices.Repository.BuildingRepository;
import com.example.municipalServices.Repository.HouseholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;
    @Autowired

    private final HouseholdRepository householdRepository;

    public BuildingService(BuildingRepository buildingRepository, HouseholdRepository householdRepository) {
        this.buildingRepository = buildingRepository;
        this.householdRepository = householdRepository;
    }

    public List<Building> getAll() {
        return buildingRepository.findAll();
    }

    public Building getById(Long id) {
        return buildingRepository.findById(id).orElseThrow(() -> new RuntimeException("Building not found"));
    }

    public Building save(Building building, Long householdId) {
        // Find the Household by ID
        Household household = householdRepository.findById(householdId).orElseThrow(() -> new RuntimeException("Household not found"));

        // Set the Household to the Building
        building.setHousehold(household);

        // Save and return the Building
        return buildingRepository.save(building);
    }

    public void delete(Long id) {
        buildingRepository.deleteById(id);
    }

    public Building updateBuilding(Long buildingId, Building building) {
        // Check if the building exists
        Optional<Building> existingBuilding = buildingRepository.findById(buildingId);

        if (existingBuilding.isPresent()) {
            Building update = existingBuilding.get();
            // Update the fields of the building
            update.setType(building.getType());
            update.setLocation(building.getLocation());
            // Set any other fields that might be updated

            // Save and return the updated building
            return buildingRepository.save(update);
        } else {
            // Return null if building not found
            return null;
        }
    }


}
