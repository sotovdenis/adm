package gpb.adminka.api.controller;

import gpb.adminka.model.Mechanic;
import gpb.adminka.repository.MechanicRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/mechanics")
public class MechanicController {

    private final MechanicRepository mechanicRepository;

    public MechanicController(MechanicRepository mechanicRepository) {
        this.mechanicRepository = mechanicRepository;
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Mechanic>> getAllMechanics() {
        return ResponseEntity.ok(mechanicRepository.getMechanics());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mechanic> getMechanicById(@PathVariable int id) {
        Mechanic mechanic = mechanicRepository.getMechanic(id);
        if (mechanic != null) {
            return ResponseEntity.ok(mechanic);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Mechanic> createMechanic(@RequestBody Mechanic mechanic) {
        mechanicRepository.setMechanic(mechanic);
        return ResponseEntity.status(HttpStatus.CREATED).body(mechanic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mechanic> updateMechanic(@PathVariable int id, @RequestBody Mechanic updatedMechanic) {
        Mechanic existingMechanic = mechanicRepository.getMechanic(id);
        if (existingMechanic != null) {
            updatedMechanic.setId(id);
            mechanicRepository.setMechanic(updatedMechanic);
            return ResponseEntity.ok(updatedMechanic);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMechanic(@PathVariable int id) {
        Mechanic mechanic = mechanicRepository.getMechanic(id);
        if (mechanic != null) {
            mechanicRepository.getMechanics().remove(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}