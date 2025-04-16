package com.example.municipalServices.Service;

import com.example.municipalServices.Model.Zone;
import com.example.municipalServices.Repository.ZoneRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneService {

    private final ZoneRepository zoneRepository;

    public ZoneService(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    public List<Zone> getAll() {
        return zoneRepository.findAll();
    }

    public Zone getById(Long id) {
        return zoneRepository.findById(id).orElse(null);
    }

    public Zone save(Zone zone) {
        return zoneRepository.save(zone);
    }

    public void delete(Long id) {
        zoneRepository.deleteById(id);
    }
}
