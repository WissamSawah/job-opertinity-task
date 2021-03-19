package com.jobopertunity.jobopertunity;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {
    Booking getByClientId(String clientId);
    Booking getByBookedResource(String bookedResource);
}
