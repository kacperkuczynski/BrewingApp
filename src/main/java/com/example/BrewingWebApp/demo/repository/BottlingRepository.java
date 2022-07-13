package com.example.BrewingWebApp.demo.repository;

import com.example.BrewingWebApp.demo.model.Bottling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BottlingRepository extends JpaRepository<Bottling, Long> {
}
