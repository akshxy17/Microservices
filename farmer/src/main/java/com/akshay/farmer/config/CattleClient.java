package com.akshay.farmer.config;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CATTLE-SERVICE")
public interface CattleClient {

    @GetMapping("/cattles/farmer/{farmerId}")
    List<Object> getCattleByFarmerId(@PathVariable Long farmerId);
}


