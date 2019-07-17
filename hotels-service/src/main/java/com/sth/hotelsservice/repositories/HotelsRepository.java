package com.sth.hotelsservice.repositories;

import com.sth.hotelsservice.models.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelsRepository extends MongoRepository<Hotel, String> {
}
