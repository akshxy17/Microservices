package com.akshay.farmer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akshay.farmer.entity.Farmer;

@Repository
public interface FarmerRepo extends JpaRepository<Farmer, Long> {

    
} 
