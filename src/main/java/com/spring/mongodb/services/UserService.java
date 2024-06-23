package com.spring.mongodb.services;

import com.spring.mongodb.entities.User;
import com.spring.mongodb.repositories.UserRepository;
import com.spring.mongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {

        return userRepository.findAll();
    }

    public User findById(String id) {
       Optional<User> user = this.userRepository.findById(id);

       return user.orElseThrow(() -> new ObjectNotFoundException("Error: Object not found!"));
    }

}
