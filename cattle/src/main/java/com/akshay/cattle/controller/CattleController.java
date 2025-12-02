package com.akshay.cattle.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.cattle.model.Cattle;
import com.akshay.cattle.repo.CattleRepo;
import com.akshay.cattle.service.CattleService;


@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/cattles")
// @Tag(name = "cattle", description = "cattle management APIs")
public class CattleController {

    private final CattleService cs;

    @Autowired
    public CattleController(CattleService cs) {
        this.cs = cs;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Cattle> getAllCattle() {
        // log.info("Fetching all cattles");
        return cs.getAllCattle();
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Cattle addCattle( @RequestBody Cattle c) {
        // log.info("Adding a new cattle: {}", c);
        return cs.addCattle(c);
    }

    @DeleteMapping("/remove/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void removeCattle(@PathVariable Long id) {
        // log.info("Deleting cattle with id: {}", id);
        cs.removeCattle(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<Cattle> getCattle(@PathVariable Long id) {
        // log.info("Fetching cattle with id: {}", id);
        return cs.getCattle(id);
    }

    // Custom endpoint to get cattles
    @GetMapping("/custom/all")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Cattle> customGetAllCattle() {
        // log.info("Fetching all cattles (custom)");
        return cs.customGetAllCattle();
    }

    // Custom endpoint to get cattles by id
    @GetMapping("/custom/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Cattle customGetCattle(@PathVariable Long id) {
        // log.info("Fetching cattle with id (custom): {}", id);
        return cs.customGetCattle(id);
    }

    @Autowired
    private CattleRepo repo;

    @GetMapping("/farmer/{farmerId}")
    public List<Cattle> getCattleByFarmerId(@PathVariable Long farmerId) {
        return repo.findByFarmerId(farmerId);
    }
}
