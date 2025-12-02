package com.akshay.farmer.dto;

import java.util.List;
import com.akshay.farmer.entity.Farmer;

import lombok.Data;

@Data
public class FarmerDetailsDTO {

    private Farmer farmer;
    private List<Object> crops;
    private List<Object> cattles;
    private List<Object> lands;
}
