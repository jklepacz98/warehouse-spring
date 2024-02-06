package com.example.warehousespring.controller;

import com.example.warehousespring.exception.ContractorNotFoundException;
import com.example.warehousespring.model.Contractor;
import com.example.warehousespring.repository.ContractorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContractorController {

    private ContractorRepository repository;

    ContractorController(ContractorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/contractor")
    List<Contractor> getAllContractors() {
        return repository.findAll();
    }

    @GetMapping("/contractor/{id}")
    Contractor getContractor(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ContractorNotFoundException(id));
    }

    @PostMapping("/contractor")
    Contractor postContractor(@RequestBody Contractor contractor) {
        return repository.save(contractor);
    }

    @PutMapping("contractor/{id}")
    Contractor putContractor(@RequestBody Contractor newContractor, @PathVariable Long id) {
        return repository.findById(id).map(contractor -> {
            contractor.setName(newContractor.getName());
            contractor.setSymbol(newContractor.getSymbol());
            return repository.save(contractor);

        }).orElseGet(() -> {
            newContractor.setId(id);
            return repository.save(newContractor);
        });
    }
}
