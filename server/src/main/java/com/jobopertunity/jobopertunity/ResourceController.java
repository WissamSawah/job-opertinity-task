package com.jobopertunity.jobopertunity;

import com.mongodb.MongoWriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ResourceRepository resourceRepository;

    public ResourceController() {}

    @GetMapping()
    public List<Resource> getAllResources()
    {
        List<Resource> allResources = this.resourceRepository.findAll();
        return allResources;
    }

    @GetMapping("/{hostName}")
    public Resource getResourceByHostName(@PathVariable String hostName) {
        return this.resourceRepository.getByHostName(hostName);
    }

    @PostMapping()
    public ResponseEntity<?> createResource(@RequestBody Resource newResource)
    {
        try {
            this.resourceRepository.save(newResource);
            return new ResponseEntity("Resource Added Successfully", HttpStatus.CREATED);
        } catch (DuplicateKeyException e) {
            return new ResponseEntity(new ErrorMsg(400, "Hostname must be a unique value"), HttpStatus.BAD_REQUEST);
        }

    }
}
