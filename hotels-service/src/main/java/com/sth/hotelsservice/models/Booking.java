package com.sth.hotelsservice.models;


import com.sth.commonmodels.Models.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Bookings")
public class Booking {
    @Id
    private String id;
    @DBRef
    private Hotel hotel;
    @DBRef
    private User user;

    private long from;
    private long to;

    public Booking(Hotel hotel, User user, long from, long to) {
        this.hotel = hotel;
        this.user = user;
        this.from = from;
        this.to = to;
    }

    public Booking(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getFrom() {
        return from;
    }

    public void setFrom(long from) {
        this.from = from;
    }

    public long getTo() {
        return to;
    }

    public void setTo(long to) {
        this.to = to;
    }
}
