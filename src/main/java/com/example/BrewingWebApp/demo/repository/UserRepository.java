package com.example.BrewingWebApp.demo.repository;

import com.example.BrewingWebApp.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
