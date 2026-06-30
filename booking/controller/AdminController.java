package com.company.booking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @GetMapping("/stats")
    public ResponseEntity<String> getAdminStats() {
        return ResponseEntity.ok("Admin-only statistics");
    }
}