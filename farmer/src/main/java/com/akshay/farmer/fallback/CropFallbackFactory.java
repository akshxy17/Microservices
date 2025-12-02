package com.akshay.farmer.fallback;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import com.akshay.farmer.config.CropClient;

import java.util.List;

@Component
public class CropFallbackFactory implements FallbackFactory<CropClient> {

    @Override
    public CropClient create(Throwable cause) {

        System.out.println("🔥 CROP FALLBACK TRIGGERED due to: " + cause);

        return farmerId -> {
            return List.of();   // Return empty list
        };
    }
}
