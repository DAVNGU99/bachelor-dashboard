package com.example.dashboardapp.config;

import com.example.dashboardapp.domain.entities.User;
import com.example.dashboardapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserSeeder {

    @Value("${user.app1.password}") private String pass1;
    @Value("${user.app2.password}") private String pass2;
    @Value("${user.app3.password}") private String pass3;
    @Value("${user.app4.password}") private String pass4;


    @Bean
    CommandLineRunner seedUsers(UserRepository repo, PasswordEncoder encoder) {
        return args -> {
            seed(repo, encoder, "davidnguyen", "test1@local.dev", pass1);
            seed(repo, encoder, "marcuvs", "test2@local.dev", pass2);
            seed(repo, encoder, "ingridvollset", "test3@local.dev", pass3);
            seed(repo, encoder, "mariahaukeberg", "test4@local.dev", pass4);
        };
    }

    private void seed(UserRepository repo, PasswordEncoder encoder,
                      String name, String email, String rawPassword) {

        if (repo.findByName(name).isPresent()) return;

        User u = new User(
                email,
                encoder.encode(rawPassword),
                name
        );

        repo.save(u);
    }
}
