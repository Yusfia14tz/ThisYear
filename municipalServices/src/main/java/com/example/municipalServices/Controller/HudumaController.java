package com.example.municipalServices.Controller;

import com.example.municipalServices.Model.Huduma;
import com.example.municipalServices.Service.HudumaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/huduma")
@CrossOrigin
public class HudumaController {

    private final HudumaService hudumaService;

    public HudumaController(HudumaService hudumaService) {
        this.hudumaService = hudumaService;
    }

    @GetMapping
    public List<Huduma> getAll() {
        return hudumaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Huduma> getById(@PathVariable Long id) {
        return hudumaService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Huduma> createHuduma(@RequestBody Huduma huduma) {
        Huduma createdHuduma = hudumaService.save(huduma);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHuduma);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        hudumaService.delete(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Huduma> updateHuduma(@PathVariable Long id, @RequestBody Huduma huduma) {
        Huduma updatedHuduma = hudumaService.update(id, huduma);
        return ResponseEntity.ok(updatedHuduma);
    }
}
