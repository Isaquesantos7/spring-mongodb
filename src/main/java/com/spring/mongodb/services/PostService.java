package com.spring.mongodb.services;

import com.spring.mongodb.entities.Post;
import com.spring.mongodb.repositories.PostRepository;
import com.spring.mongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {

        return this.postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }

    public List<Post> findByTitle(String text) {

        return this.postRepository.findByTitleContainingIgnoreCase(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {

        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return this.postRepository.fullSearch(text, minDate, maxDate);
    }
}
