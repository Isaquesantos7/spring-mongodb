package com.spring.mongodb.controllers;

import com.spring.mongodb.controllers.util.URL;
import com.spring.mongodb.entities.Post;
import com.spring.mongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/api/posts/{id}")
    public ResponseEntity<Post> findOnePost(@PathVariable(value = "id") String id) {
        Post post = this.postService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(post);
    }


    @GetMapping("/api/posts/titleSearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParams(text);
        List<Post> list = this.postService.findByTitle(text);

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/api/posts/fullSearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value="text", defaultValue="") String text,
            @RequestParam(value="minDate", defaultValue="") String minDate,
            @RequestParam(value="maxDate", defaultValue="") String maxDate) {
        text = URL.decodeParams(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<Post> list = this.postService.fullSearch(text, min, max);
        return ResponseEntity.ok().body(list);
    }
}
