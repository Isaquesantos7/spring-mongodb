package com.spring.mongodb.services;

import com.spring.mongodb.entities.Post;
import com.spring.mongodb.repositories.PostRepository;
import com.spring.mongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {

        return this.postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }
}