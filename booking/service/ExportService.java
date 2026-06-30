package com.company.booking.service;

import com.company.booking.entity.Trip;
import com.company.booking.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.List;

@Service
public class ExportService {

    private final TripRepository tripRepository;

    public ExportService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public ByteArrayInputStream exportTripsToCSV() {
        List<Trip> trips = tripRepository.findAll();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter(out);

        writer.println("id,destination,startDate,endDate,status,userId");

        for (Trip t : trips) {
            writer.println(
                    t.getId() + "," +
                    t.getDestination() + "," +
                    t.getStartDate() + "," +
                    t.getEndDate() + "," +
                    t.getStatus() + "," +
                    (t.getUser() != null ? t.getUser().getId() : "")
            );
        }

        writer.flush();
        return new ByteArrayInputStream(out.toByteArray());
    }
}