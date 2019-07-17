package com.sth.users.reporitories;

import com.sth.commonmodels.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<User, String> {
}
