package com.akshay.land.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.land.entity.Land;
import com.akshay.land.repo.LandRepo;
import com.akshay.land.service.LandService;


@RestController
@RequestMapping("/lands")
public class LandController {

    @Autowired
    private LandService ls;

    @GetMapping
    public List<Land> getLands() {
        return ls.getAllLand();
    }

    @GetMapping("/{id}")
    public Optional<Land> getLand(@PathVariable Long id) {
        return ls.getLandById(id);
    }

    @PostMapping
    public Land addLand( @RequestBody Land land) {
        return ls.addLand(land);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLand(@PathVariable Long id) {
        ls.deleteLand(id);
    }

    @Autowired
    private LandRepo repo;

    @GetMapping("/farmer/{farmerId}")
    public List<Land> getLandsByFarmerId(@PathVariable Long farmerId) {
        return repo.findByFarmerId(farmerId);
    }
}
