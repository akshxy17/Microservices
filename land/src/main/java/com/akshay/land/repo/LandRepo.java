package com.akshay.land.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.akshay.land.entity.Land;

@Repository
public interface LandRepo extends JpaRepository<Land, Long> {

    List<Land> findByFarmerId(Long farmerId);

}
