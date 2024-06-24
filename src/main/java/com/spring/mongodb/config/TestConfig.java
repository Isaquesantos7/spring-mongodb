package com.spring.mongodb.config;

import com.spring.mongodb.entities.Comment;
import com.spring.mongodb.entities.Post;
import com.spring.mongodb.entities.User;
import com.spring.mongodb.repositories.PostRepository;
import com.spring.mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
//@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        this.userRepository.deleteAll();
        this.postRepository.deleteAll();

        User u1 = new User(null, "Isaque Santos", "isaquesantos.second.1998@gmail.com");
        User u2 = new User(null, "Eliseu Santos", "elispdam.1999@gmail.com");
        User u3 = new User(null, "Abigail Santos", "abigail123@gmail.com");

        Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", u1);
        Post p2 = new Post(null, sdf.parse("30/01/2024"), "Estudar está sendo uma loucura!", "Estou estudando java, springboot, typescript, modelagem de sistema e angular!", u1);

        Comment c1 = new Comment(null, "Boa viagem mano!", sdf.parse("21/03/2018"), u1);
        Comment c2 = new Comment(null, "Tenha uma excelente viagem!", sdf.parse("22/03/2018"), u1);
        Comment c3 = new Comment(null, "Realmente estudar as vezes e dificil mais tras muitas recompensas!", sdf.parse("30/01/2024"),u2);

        this.userRepository.saveAll(Arrays.asList(u1, u2, u3));
        this.postRepository.saveAll(Arrays.asList(p1, p2));

        u1.getPosts().addAll(Arrays.asList(p1, p2));
        p1.getCommentList().addAll(Arrays.asList(c1, c2));
        p2.getCommentList().add(c3);
        this.postRepository.saveAll(Arrays.asList(p1,p2));
        this.userRepository.save(u1);
    }
}
