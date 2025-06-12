package com.example.productservicefeb25.service;

import com.example.productservicefeb25.exceptions.ProductNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CacheWarmUpService {
//
//    @Autowired
//    private ProductService productService;
//
//    @PostConstruct
//    public void initWarmUp() {
//        warmUpCacheAsync();  // Fire-and-forget async cache warm-up
//    }
//
//    @Async
//    public void warmUpCacheAsync() {
//        System.out.println("Starting async cache warm-up...");
//
//        for (Long id = 500L; id <= 520; id++) {
//            try {
//                productService.getProductById(id); // Caches product if found
//            } catch (Exception | ProductNotFoundException e) {
//                System.err.println("Skipping product ID " + id + ": " + e.getMessage());
//                // Optionally log the full stack trace if needed
//            }
//        }
//
//        System.out.println("Async cache warm-up completed.");
//    }
//
//    @Scheduled(cron = "0 0 */12 * * *") // Optional scheduled refresh every 12 hours
//    public void scheduledWarmUp() {
//        System.out.println("Scheduled cache warm-up triggered.");
//        warmUpCacheAsync();
//    }
}
