package com.example.municipalServices.Controller;

import com.example.municipalServices.Model.Zone;
import com.example.municipalServices.Repository.ZoneRepository;
import com.example.municipalServices.Service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zones")
@CrossOrigin
public class ZoneController {

    @Autowired
    private ZoneRepository zoneRepository;

    private final ZoneService zoneService;

    public ZoneController(ZoneService zoneService) {
        this.zoneService = zoneService;
    }

    @GetMapping
    public List<Zone> getAll() {
        return zoneService.getAll();
    }

    @GetMapping("/{id}")
    public Zone getById(@PathVariable Long id) {
        return zoneService.getById(id);
    }

    @PostMapping
    public Zone createZone(@RequestBody Zone zone) {
        return zoneRepository.save(zone); // Hakikisha hii ipo
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        zoneService.delete(id);
    }
    @PutMapping("/{id}")
    public Zone updateZone(@PathVariable Long id, @RequestBody Zone updatedZone) {
        return zoneRepository.findById(id)
                .map(zone -> {
                    zone.setName(updatedZone.getName());
                    return zoneRepository.save(zone);
                })
                .orElseThrow(() -> new RuntimeException("Zone not found with id " + id));
    }

}
