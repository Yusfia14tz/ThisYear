package com.example.municipalServices.Controller;

import com.example.municipalServices.Model.Household;
import com.example.municipalServices.Service.HouseholdService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/households")
@CrossOrigin
public class HouseholdController {

    private final HouseholdService householdService;

    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    @GetMapping
    public List<Household> getAll() {
        return householdService.getAll();
    }

    @GetMapping("/{id}")
    public Household getById(@PathVariable Long id) {
        return householdService.getById(id);
    }

    @PostMapping
    public Household save(@RequestBody Household household) {
        return householdService.save(household);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        householdService.delete(id);
    }
    @PutMapping("/{id}")
    public Household update(@PathVariable Long id, @RequestBody Household household) {
        return householdService.update(id, household);
    }

}
