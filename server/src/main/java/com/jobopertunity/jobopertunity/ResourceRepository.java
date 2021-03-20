package com.jobopertunity.jobopertunity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends MongoRepository<Resource, String> {
    Resource getById(String id);
    Resource getByHostName(String hostName);
    @Query(value="{'bookings': ?0}", fields="{'bookings': 1}")
    List<Resource> getByBookingClientId(String clientId);

    @Query(value="{'hostName': ?0, 'bookings': ?1}")
    List<Resource> getByHostNameAndClientId(String hostName, String clientId);
}
