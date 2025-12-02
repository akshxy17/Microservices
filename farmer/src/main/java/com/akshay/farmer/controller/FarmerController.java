package com.akshay.farmer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.farmer.dto.FarmerDetailsDTO;
import com.akshay.farmer.entity.Farmer;
import com.akshay.farmer.service.FarmerService;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/farmers")
public class FarmerController {

    @Autowired
    private FarmerService service;

    @PostMapping
    public Farmer addFarmer(@Valid @RequestBody Farmer farmer) {
        return service.addFarmer(farmer);
    }

    @GetMapping
    public List<Farmer> getAllFarmers() {
        return service.getAllFarmers();
    }

    @GetMapping("/{id}")
    public Farmer getFarmerById(@PathVariable Long id) {
        return service.getFarmerById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteFarmer(@PathVariable Long id) {
        return service.deleteFarmer(id);
    }

    @PutMapping("/{id}")
    public Farmer updateFarmer(@RequestBody Farmer farmer, @PathVariable Long id) {
        return service.updateFarmer(id, farmer);
    }

    @PatchMapping("/{id}")
    public Farmer partialUpdate(@RequestBody Farmer farmer, @PathVariable Long id) {
        return service.partialUpdate(id, farmer);
    }

    /// --------Ms------//
    @GetMapping("/{id}/details")
    public FarmerDetailsDTO getFarmerDetails(@PathVariable Long id) {
        return service.getFarmerFullDetails(id);
    }

}
