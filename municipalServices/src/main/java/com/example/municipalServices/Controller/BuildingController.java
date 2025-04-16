package com.example.municipalServices.Controller;

import com.example.municipalServices.Model.Building;
import com.example.municipalServices.Service.BuildingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buildings")
@CrossOrigin
public class BuildingController {

    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping
    public List<Building> getAll() {
        return buildingService.getAll();
    }

    @GetMapping("/{id}")
    public Building getById(@PathVariable Long id) {
        return buildingService.getById(id);
    }


    @PostMapping("/household/{householdId}")
    public Building save(@PathVariable Long householdId, @RequestBody Building building) {
        return buildingService.save(building, householdId);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        buildingService.delete(id);
    }

    @PutMapping("/{buildingId}")
    public ResponseEntity<Building> updateBuilding(@PathVariable Long buildingId, @RequestBody Building building) {
        Building updatedBuilding = buildingService.updateBuilding(buildingId, building);
        if (updatedBuilding != null) {
            return ResponseEntity.ok(updatedBuilding);  // Return the updated object
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // Return 404 if not found
        }
    }


}
