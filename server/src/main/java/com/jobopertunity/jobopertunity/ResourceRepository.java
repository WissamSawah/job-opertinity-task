package com.jobopertunity.jobopertunity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends MongoRepository<Resource, String> {
    Resource getById(String id);
    Resource getByHostName(String hostName);
}
