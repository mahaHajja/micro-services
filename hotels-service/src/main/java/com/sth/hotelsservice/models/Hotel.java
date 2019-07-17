package com.sth.hotelsservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Hotels")
public class Hotel {

    @Id
    private String id;
    private String name;
    private String owner;
    private String address;
    private String description;
    private int roomCount;
    private double pricePerDay;

    public Hotel(String name, String owner, String address, String description, int roomCount, double pricePerDay) {
        this.name = name;
        this.owner = owner;
        this.address = address;
        this.description = description;
        this.roomCount = roomCount;
        this.pricePerDay = pricePerDay;
    }
    public Hotel(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
