package com.company.booking.controller;

import com.company.booking.service.DashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, Long>> getTripStatusStats() {
        return ResponseEntity.ok(dashboardService.getTripStatusStats());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Long> getTripsForUser(@PathVariable Long userId) {
        return ResponseEntity.ok(dashboardService.getTripsForUser(userId));
    }

    @GetMapping("/destination/{destination}")
    public ResponseEntity<Long> getTripsForDestination(@PathVariable String destination) {
        return ResponseEntity.ok(dashboardService.getTripsForDestination(destination));
    }

    @GetMapping("/month/{month}")
    public ResponseEntity<Long> getTripsInMonth(@PathVariable String month) {
        return ResponseEntity.ok(dashboardService.getTripsInMonth(month));
    }
}