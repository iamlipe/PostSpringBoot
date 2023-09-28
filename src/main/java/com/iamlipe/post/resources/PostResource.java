package com.iamlipe.post.resources;

import com.iamlipe.post.domain.Post;
import com.iamlipe.post.resources.utils.URL;
import com.iamlipe.post.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByText(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParams(text);
        List<Post> posts = service.findByTitle(text);
        return ResponseEntity.ok().body(posts);
    }
}
