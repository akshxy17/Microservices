package com.akshay.farmer.config;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "LAND-SERVICE")
public interface LandClient {
    @GetMapping("/lands/farmer/{farmerId}")   // ✅ CORRECT
    List<Object> getLandsByFarmerId(@PathVariable Long farmerId);
}

