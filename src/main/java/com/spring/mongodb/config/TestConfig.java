package com.spring.mongodb.config;

import com.spring.mongodb.entities.User;
import com.spring.mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
//@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Isaque Santos", "isaquesantos.second.1998@gmail.com");
        User u2 = new User(null, "Eliseu Santos", "elispdam.1999@gmail.com");
        User u3 = new User(null, "Abigail Santos", "abigail123@gmail.com");

        this.userRepository.deleteAll();
        this.userRepository.saveAll(Arrays.asList(u1, u2, u3));
    }
}
