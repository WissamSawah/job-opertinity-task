package com.jobopertunity.jobopertunity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private ErrorMsg errorMsg;

    public ResourceController() {}

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping()
    public List<Resource> getAllResources()
    {
        List<Resource> allResources = this.resourceRepository.findAll();
        return allResources;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/{hostName}")
    public ResponseEntity<?> getResourceByHostName(@PathVariable String hostName) {
        Resource resource = this.resourceRepository.getByHostName(hostName);

        System.out.println(resource);
        if (resource == null) {
            this.errorMsg.setErrorMsg(404, "Resource with given hostName does not exist");
            return new ResponseEntity(this.errorMsg, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(resource, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/add")
    public ResponseEntity<?> createResource(@RequestBody Resource newResource)
    {
        try {
            this.resourceRepository.save(newResource);
            return new ResponseEntity("Resource Added Successfully", HttpStatus.CREATED);
        } catch (DuplicateKeyException e) {
            this.errorMsg.setErrorMsg(400, "Hostname must be a unique value");
            return new ResponseEntity(this.errorMsg, HttpStatus.BAD_REQUEST);
        }

    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/book")
    public ResponseEntity<?> createBooking(@RequestBody Booking booking)
    {
        if (this.userIsAlreadyBooked(booking.getClientId())) {
            this.errorMsg.setErrorMsg(400, "User with given clientId is already booked on a resource");
            return new ResponseEntity(this.errorMsg, HttpStatus.BAD_REQUEST);
        }
        if (booking.getBookedResource() != null) {
            try {
                Resource resource = this.resourceRepository.getByHostName(booking.getBookedResource());
                if (resource.getBookings().size() >= resource.getBookingLimit()) {
                    this.errorMsg.setErrorMsg(400, "Given resource is at it's limit of bookings");
                    return new ResponseEntity(this.errorMsg, HttpStatus.BAD_REQUEST);
                }

                resource.addBooking(booking.getClientId());
                this.resourceRepository.save(resource);
                //return new ResponseEntity("Booking created", HttpStatus.CREATED);
            } catch (NullPointerException e) {
                this.errorMsg.setErrorMsg(400,"Given hostName doesn't exist");
                return new ResponseEntity(this.errorMsg, HttpStatus.BAD_REQUEST);
            }
        } else {
            String hostName = this.getRandomAvailableResource();
            Resource resource = this.resourceRepository.getByHostName(hostName);
            if (resource.getBookings().size() >= resource.getBookingLimit()) {
                this.errorMsg.setErrorMsg(400, "Given resource is at it's limit of bookings");
                return new ResponseEntity(this.errorMsg, HttpStatus.BAD_REQUEST);
            }
            resource.addBooking(booking.getClientId());
            this.resourceRepository.save(resource);
        }
        return new ResponseEntity("Booking created", HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/release")
    public ResponseEntity<?> releaseResource(@RequestBody Booking booking) {
        List<Resource> resource = this.resourceRepository.getByHostNameAndClientId(booking.getBookedResource(), booking.getClientId());

        if (resource.size() == 0) {
            this.errorMsg.setErrorMsg(400,"Given hostName or clientId doesn't exist");
            return new ResponseEntity(this.errorMsg, HttpStatus.BAD_REQUEST);
        }
        resource.get(0).removeBooking(booking.getClientId());
        this.resourceRepository.save(resource.get(0));

        return new ResponseEntity("Booking removed", HttpStatus.NO_CONTENT);
    }

    private boolean userIsAlreadyBooked(String userId) {
        //Checks if the user that tries to book a resource is already booked on one
        List<Resource> resource = this.resourceRepository.getByBookingClientId(userId);

        if (resource.size() == 0) {
            return false;
        }

        if (resource.get(0).getBookings().contains(userId)) {
            return true;
        }
        return false;
    }

    private String getRandomAvailableResource() {
        List<String> availableResources = this.findFreeResources();
        Random rand = new Random();
        return availableResources.get(rand.nextInt(availableResources.size()));
    }
    private List<String> findFreeResources() {
        List<Resource> allResources = this.resourceRepository.findAll();
        List<String> availableResources = new ArrayList();
        for (int i= 0; i < allResources.size(); i++) {
            Resource currentR = allResources.get(i);
            if (currentR.getBookings().size() < currentR.getBookingLimit()) {
                availableResources.add(currentR.getHostName());
            }
        }
        return availableResources;
        //TODO throw error if list size is 0
    }
}
