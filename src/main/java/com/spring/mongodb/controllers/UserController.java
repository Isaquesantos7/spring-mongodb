package com.spring.mongodb.controllers;

import com.spring.mongodb.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> findAll() {
        List<User> list = new ArrayList<>();
        list.add(new User("1", "Isaque Santos", "Isaquesantos.1998@gmail.com"));
        list.add(new User("2", "Eliseu Santos", "elispdam.1999@gmail.com"));

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

}
