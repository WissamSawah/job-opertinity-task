package com.jobopertunity.jobopertunity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Document(collection = "Bookings")
@Validated
public class Booking {
    @Id
    private String id;

    @NotNull
    private String clientId;

    private String bookedResource;  //The Hostname of the booked resource
    private boolean released;

    public Booking() {
        this.released = false;
    }

    public Booking(String clientId, String bookedResource) {
        this.clientId = clientId;
        this.bookedResource = bookedResource;
        this.released = false;
    }

    public String getId() { return id; }

    public String getClientId() { return clientId; }

    public String getBookedResource() { return bookedResource; }

    public void setReleased(boolean released) { this.released = released; }
}
