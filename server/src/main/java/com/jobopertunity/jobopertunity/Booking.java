package com.jobopertunity.jobopertunity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Booking {

    private String clientId;

    private String bookedResource;  //The Hostname of the booked resource

    public Booking() {}

    public String getClientId() { return clientId; }

    public String getBookedResource() { return bookedResource; }

}
