package com.jobopertunity.jobopertunity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public BookingController() {}

    @PostMapping()
    public ResponseEntity<?> createBooking(@RequestBody Booking newBooking) {
        try {
            this.bookingRepository.save(newBooking);
            return new ResponseEntity("Booking created Successfully", HttpStatus.CREATED);
        } catch (ConstraintViolationException e) {
            return new ResponseEntity(new ErrorMsg(400, "clientId is needed to be provided when doing a booking"), HttpStatus.BAD_REQUEST);
        }

    }
}
