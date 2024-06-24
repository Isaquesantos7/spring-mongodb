package com.spring.mongodb.controllers;

import com.spring.mongodb.entities.Post;
import com.spring.mongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/api/posts/{id}")
    public ResponseEntity<Post> findOnePost(@PathVariable(value = "id") String id) {
        Post post = this.postService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(post);
    }
}
