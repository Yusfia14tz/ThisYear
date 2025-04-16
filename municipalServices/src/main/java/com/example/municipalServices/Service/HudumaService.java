package com.example.municipalServices.Service;

import com.example.municipalServices.Model.Huduma;
import com.example.municipalServices.Repository.HudumaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HudumaService {

    private final HudumaRepository hudumaRepository;

    public HudumaService(HudumaRepository hudumaRepository) {
        this.hudumaRepository = hudumaRepository;
    }

    public List<Huduma> getAll() {
        return hudumaRepository.findAll();
    }

    public Optional<Huduma> getById(Long id) {
        return hudumaRepository.findById(id);
    }

    public Huduma save(Huduma huduma) {
        return hudumaRepository.save(huduma);
    }

    public void delete(Long id) {
        hudumaRepository.deleteById(id);
    }

    public Huduma update(Long id, Huduma huduma) {
        if (!hudumaRepository.existsById(id)) {

        }
        huduma.setId(id);  // Ensure the ID is set in the entity before saving
        return hudumaRepository.save(huduma);
    }
}
