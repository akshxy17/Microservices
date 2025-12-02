package com.akshay.farmer.config;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.akshay.farmer.fallback.CropFallbackFactory;

// @FeignClient(name = "CROP-SERVICE")
@FeignClient(name="CROP-SERVICE", fallbackFactory = CropFallbackFactory.class)
public interface CropClient {

    @GetMapping("/crops/farmer/{farmerId}")
    List<Object> getCropsByFarmerId(@PathVariable Long farmerId);
}

