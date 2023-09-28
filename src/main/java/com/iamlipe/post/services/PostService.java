package com.iamlipe.post.services;

import com.iamlipe.post.domain.Post;
import com.iamlipe.post.repositories.PostRepository;
import com.iamlipe.post.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Post not found"));
    }

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Instant minDate, Instant maxDate) {
        return repository.fullSearch(text, minDate, maxDate);
    }
}
