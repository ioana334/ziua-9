package com.company.booking.service;

import com.company.booking.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardService {

    private final TripRepository tripRepository;

    public DashboardService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Map<String, Long> getTripStatusStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("approved", tripRepository.countByStatus("APPROVED"));
        stats.put("pending", tripRepository.countByStatus("PENDING"));
        stats.put("rejected", tripRepository.countByStatus("REJECTED"));
        return stats;
    }

    public Long getTripsForUser(Long userId) {
        return tripRepository.countByUserId(userId);
    }

    public Long getTripsForDestination(String destination) {
        return tripRepository.countByDestinationContainingIgnoreCase(destination);
    }

    public Long getTripsInMonth(String month) {
        return (long) tripRepository.findByStartDateContaining(month).size();
    }
}