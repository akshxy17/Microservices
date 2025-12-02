package com.akshay.farmer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.farmer.config.CattleClient;
import com.akshay.farmer.config.CropClient;
import com.akshay.farmer.config.LandClient;
import com.akshay.farmer.dto.FarmerDetailsDTO;
import com.akshay.farmer.entity.Farmer;
import com.akshay.farmer.repository.FarmerRepo;

import lombok.NonNull;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepo repo;

    public Farmer addFarmer(@NonNull Farmer farmer) {
        Farmer f = repo.save(farmer);
        return f;
    }

    public List<Farmer> getAllFarmers() {
        return repo.findAll();
    }

    public Farmer getFarmerById(@NonNull Long id) {
        Farmer farmer = repo.findById(id).orElseThrow(() -> new RuntimeException("Farmer not found with id " + id));
        return farmer;
    }

    public String deleteFarmer(@NonNull Long id) {
        repo.deleteById(id);
        return "farmer deleted with id: " + id;

    }

    public Farmer updateFarmer(@NonNull Long id, Farmer farmer) {
        Farmer uf = repo.findById(id).orElseThrow(() -> new RuntimeException("Farmer not found with id " + id));

        uf.setName(farmer.getName());
        uf.setAge(farmer.getAge());
        uf.setGender(farmer.getGender());
        uf.setAddress(farmer.getAddress());
        uf.setContactNumber(farmer.getContactNumber());
        uf.setFarmingType(farmer.getFarmingType());

        return repo.save(uf);
    }

    public Farmer partialUpdate(@NonNull Long id, Farmer farmer) {

        Farmer farmer2 = repo.findById(id).orElseThrow(() -> new RuntimeException("Farmer not found with id " + id));

        if (farmer.getName() != null) {
            farmer2.setName(farmer.getName());
        }

        if (farmer.getAge() != 0) {
            farmer2.setAge(farmer.getAge());
        }
        if (farmer.getGender() != null) {
            farmer2.setGender(farmer.getGender());
        }
        if (farmer.getAddress() != null) {
            farmer2.setAddress(farmer.getAddress());
        }
        if (farmer.getContactNumber() != null) {
            farmer2.setContactNumber(farmer.getContactNumber());
        }
        if (farmer.getFarmingType() != null) {
            farmer2.setFarmingType(farmer.getFarmingType());
        }

        return repo.save(farmer2);

    }

    // ---------MICROSERVICES-------------//

    @Autowired
    private CropClient cropClient;

    @Autowired
    private CattleClient cattleClient;

    @Autowired
    private LandClient landClient;

    public FarmerDetailsDTO getFarmerFullDetails(Long id) {

        Farmer farmer = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));

        FarmerDetailsDTO dto = new FarmerDetailsDTO();
        dto.setFarmer(farmer);
        dto.setCrops(cropClient.getCropsByFarmerId(id));
        dto.setCattles(cattleClient.getCattleByFarmerId(id));
        dto.setLands(landClient.getLandsByFarmerId(id));

        return dto;
    }

}
