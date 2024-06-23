package com.spring.mongodb.services;

import com.spring.mongodb.DTOS.UserDTO;
import com.spring.mongodb.entities.User;
import com.spring.mongodb.repositories.UserRepository;
import com.spring.mongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
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

       return this.userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User saveUser(User user) {

        return this.userRepository.save(user);
    }

    public User delete(String id) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found!"));

        this.userRepository.deleteById(id);
        return user;
    }

    public User update(String id, UserDTO userDTO) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found!"));

        BeanUtils.copyProperties(userDTO, user, "id");

        return this.userRepository.save(user);
    }
}
