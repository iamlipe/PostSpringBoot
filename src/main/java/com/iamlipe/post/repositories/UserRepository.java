package com.iamlipe.post.repositories;

import com.iamlipe.post.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
