package com.iamlipe.post.repositories;

import com.iamlipe.post.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
