package com.spring.mongodb.controllers;

import com.spring.mongodb.DTOS.UserDTO;
import com.spring.mongodb.entities.Post;
import com.spring.mongodb.entities.User;
import com.spring.mongodb.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/users/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable(value = "id") String id) {
        User user = this.userService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(user.getPosts());
    }

    @PostMapping("/api/users")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserDTO userDTO) {
        User user = new User();

        BeanUtils.copyProperties(userDTO, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.saveUser(user));
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") String id) {
        User user = this.userService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body("{\"message:\" \"User \""  + user.getName() +  "\" was deleted with success!\"}");
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") String id, @RequestBody @Valid UserDTO userDTO) {
        User updateUser = this.userService.update(id, userDTO);

        return ResponseEntity.status(HttpStatus.OK).body(updateUser);
    }

}
