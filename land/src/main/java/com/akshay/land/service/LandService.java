package com.akshay.land.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.land.entity.Land;
import com.akshay.land.repo.LandRepo;

@Service
public class LandService {

    @Autowired
    private LandRepo repo;

    public List<Land> getAllLand() {
        return repo.findAll();
    }

    public Optional<Land> getLandById(Long id) {
        return repo.findById(id);
    }

    public Land addLand(Land land) {
        return repo.save(land);
    }

    public void deleteLand(Long id) {
        repo.deleteById(id);
    }
}
