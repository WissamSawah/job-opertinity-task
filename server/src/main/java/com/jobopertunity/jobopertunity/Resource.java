package com.jobopertunity.jobopertunity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Resources")
public class Resource {
    @Id
    private String id;

    @Indexed(unique = true)
    private String hostName;
    private int bookingLimit;

    public Resource() { }

    public Resource(String hostName) {
        this.hostName = hostName;
        this.bookingLimit = 1;
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
}