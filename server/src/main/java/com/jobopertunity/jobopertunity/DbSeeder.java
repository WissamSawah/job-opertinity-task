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

    public DbSeeder() {}

    @Override
    public void run(String... strings) throws Exception {
        Resource r1 = new Resource("r1Host", 2);
        Resource r2 = new Resource("r2Host", 5);
        Resource r3 = new Resource("r3Host", 1);
        Resource r4 = new Resource("r4Host", 3);
        Resource r5 = new Resource("r5Host", 7);

        this.resourceRepository.deleteAll();
        List<Resource> resourceList = Arrays.asList(r1, r2, r3, r4, r5);

        this.resourceRepository.saveAll(resourceList);
    }
}
