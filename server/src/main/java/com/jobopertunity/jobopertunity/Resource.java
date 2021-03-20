package com.jobopertunity.jobopertunity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Resources")
public class Resource {
    @Id
    private String id;

    @Indexed(unique = true)
    private String hostName;
    private int bookingLimit;
    private List<String> bookings;

    public Resource() {
        this.bookingLimit = 1;
        this.bookings = new ArrayList<String>();
    }

    public Resource(String hostName, int bookingLimit) {
        this.hostName = hostName;
        this.bookingLimit = bookingLimit;
        this.bookings = new ArrayList<String>();
    }


    public String getId() {
        return id;
    }

    public String getHostName() {
        return hostName;
    }

    public int getBookingLimit() {
        return bookingLimit;
    }

    public void setBookingLimit(int bookingLimit) {
        this.bookingLimit = bookingLimit;
    }

    public List<String> getBookings() {
        return bookings;
    }

    public void addBooking(String clientId) {
        this.bookings.add(clientId);
    }

    public void removeBooking(String clientId) {
        this.bookings.remove(clientId);
    }
}