package com.jobopertunity.jobopertunity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public DbSeeder() {}

    @Override
    public void run(String... strings) throws Exception {
        Resource r1 = new Resource("r1Host");
        Resource r2 = new Resource("r2Host");
        Resource r3 = new Resource("r3Host");
        Resource r4 = new Resource("r4Host");
        Resource r5 = new Resource("r5Host");

        Booking b1 = new Booking("client1", "r1Host");
        Booking b2 = new Booking("client2", "r2Host");
        Booking b3 = new Booking("client3", "r3Host");
        Booking b4 = new Booking("client4", "r4Host");
        Booking b5 = new Booking("client5", "r5Host");
        this.resourceRepository.deleteAll();

        List<Resource> resourceList = Arrays.asList(r1, r2, r3, r4, r5);
        List<Booking> bookingList = Arrays.asList(b1, b2, b3, b4, b5);

        this.resourceRepository.saveAll(resourceList);
        this.bookingRepository.saveAll(bookingList);
    }
}
