package com.spring.mongodb.controllers;

import com.spring.mongodb.entities.User;
import com.spring.mongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> findById(@PathVariable(value = "id") String id) {
        User user = this.userService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

}
