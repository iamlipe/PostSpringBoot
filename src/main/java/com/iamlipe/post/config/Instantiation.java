package com.iamlipe.post.config;

import com.iamlipe.post.domain.Post;
import com.iamlipe.post.domain.User;
import com.iamlipe.post.dto.AuthorDTO;
import com.iamlipe.post.repositories.PostRepository;
import com.iamlipe.post.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, Instant.parse("2019-07-22T15:21:22Z"), "Departed trip", "I'm going to São Paulo. Hugs", new AuthorDTO(maria));
        Post post2 = new Post(null, Instant.parse("2019-07-21T03:42:10Z"), "Good Morning", "I woke up happy today", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
