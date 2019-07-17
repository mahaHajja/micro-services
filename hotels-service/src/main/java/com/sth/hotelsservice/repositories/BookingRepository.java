package com.sth.hotelsservice.repositories;

import com.sth.hotelsservice.models.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String> {

    List<Booking> findByHotel(String hId);
}
